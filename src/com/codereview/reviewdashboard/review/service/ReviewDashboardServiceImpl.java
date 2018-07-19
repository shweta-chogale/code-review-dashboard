package com.codereview.reviewdashboard.review.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codereview.reviewdashboard.http.HttpRequestResponseUtility;
import com.codereview.reviewdashboard.report.dao.CodeReviewDataDao;
import com.codereview.reviewdashboard.report.data.CodeReviewData;
import com.codereview.reviewdashboard.report.data.RawReportData;
import com.codereview.reviewdashboard.report.data.ReviewSummary;
import com.codereview.reviewdashboard.report.service.ReviewReportService;
import com.codereview.reviewdashboard.review.ReviewDashboardConstants;
import com.codereview.reviewdashboard.review.data.Reviews;

/**
 * code review dashboard service for fetching review data and generating report
 * @author Shweta Chogale
 *
 */
@Service
public class ReviewDashboardServiceImpl implements ReviewDashboardService {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	ReviewReportService reviewReportService;
	
	@Autowired
	CodeReviewDataDao codeReviewDataDao;
	
	@Value("#{'${authors}'.split(',')}")
	private List<String> authors;
	
	@Value("${save.data.db}")
	private boolean isdbSaveEnabled;
	
	//Fetches all reviews for mentioned authors, gets review specific details and creates csv format data for code reviews data
	@Override
	public void generateReviewDashboardData() {
		//Get all reviews
		List<Reviews> openReviews = getAllOpenReviews();
		
		//Get per review details like num of comments, num of files in a review
		List<RawReportData> allReviewsReportData = reviewReportService.getRawReviewReport(openReviews);
		
		//Converts raw data into formatted data model
		List<CodeReviewData> reviewDataList = convertRawDataToReportData(allReviewsReportData);
		
		//Saves review to DB id save is enabled
		if(isdbSaveEnabled) {
			codeReviewDataDao.saveAllCodeReviews(reviewDataList);
		}
		
		//Generates csv file for the review data
		reviewReportService.generateCsvFile(reviewDataList);
	}

	//Converts raw data into formatted data model
	private List<CodeReviewData> convertRawDataToReportData(List<RawReportData> allReviewsReportData) {
		List<CodeReviewData> reviewDataList = new ArrayList<CodeReviewData>();
		
		for(RawReportData rawReportData : allReviewsReportData){
			
			for(ReviewSummary reviewSummary : rawReportData.getReviewList()){
				CodeReviewData codeReviewData = new CodeReviewData();
				
				codeReviewData.setAuthorName(rawReportData.getName());
				codeReviewData.setTeamName(rawReportData.getTeamName());
				codeReviewData.setCodeReviewId(reviewSummary.getReviewNum());
				codeReviewData.setNumOfFilesReveiwed(reviewSummary.getNumOfFilesInReview());
				codeReviewData.setNumOfReviewComments(reviewSummary.getNumOfComments());
				codeReviewData.setReviewCreatedDate(reviewSummary.getReviewCreationDate());
				codeReviewData.setReviewClosedDate(reviewSummary.getReviewClosedDate());
				
				reviewDataList.add(codeReviewData);
			}
		}
		
		return reviewDataList;
	}

	//Get all open reviews
	private List<Reviews> getAllOpenReviews() {
		HttpHeaders headers = HttpRequestResponseUtility.updateRequest();
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		List<Reviews> allReviews = new ArrayList<Reviews>();
		
		
		for(String authorname : authors){
			
			Reviews reviews = getOpenReviewsForAuthor(headers, restTemplate, authorname);			
						
			allReviews.add(reviews);
		}
				
		
		return allReviews;
	}

	//Gets open reviews for particular author
	private Reviews getOpenReviewsForAuthor(HttpHeaders headers, RestTemplate restTemplate, String authorname) {
		Map<String, Object> urlVariables = new HashMap<String, Object>();
		
		populateUrlVariables(urlVariables, authorname);
		
		ResponseEntity<Reviews> result = restTemplate.exchange(HttpRequestResponseUtility.getFullURL(ReviewDashboardConstants.ALL_REVIEWS_URL), HttpMethod.GET, 
				new HttpEntity<HttpHeaders>(null, headers), Reviews.class, urlVariables);
		
		return result.getBody();
	}

	//Populates URL specific variables
	private void populateUrlVariables(Map<String,Object> urlVariables, String authorname) {
		urlVariables.put(ReviewDashboardConstants.URL_KEY_AUTHOR, authorname);
		
		Date today = new Date();
		long last7days = today.getTime() - (7 * 24 * 60 * 60 * 1000);
		
		urlVariables.put(ReviewDashboardConstants.URL_KEY_FROMDATE, last7days);
		urlVariables.put(ReviewDashboardConstants.URL_KEY_TODATE, today.getTime());
	}
	
}
