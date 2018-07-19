package com.codereview.reviewdashboard.report.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codereview.reviewdashboard.report.data.CodeReviewData;
import com.codereview.reviewdashboard.report.data.RawReportData;
import com.codereview.reviewdashboard.report.data.ReviewSummary;
import com.codereview.reviewdashboard.review.ReviewDashboardConstants;
import com.codereview.reviewdashboard.review.data.Comments;
import com.codereview.reviewdashboard.review.data.ReviewData;
import com.codereview.reviewdashboard.review.data.ReviewItem;
import com.codereview.reviewdashboard.review.data.ReviewItems;
import com.codereview.reviewdashboard.review.data.Reviews;
import com.codereview.reviewdashboard.review.service.ReviewDataService;

@Service
public class ReviewReportServiceImpl implements ReviewReportService {
	
	@Autowired
	ReviewDataService reviewDataService;
	
	@Autowired
	FileGenerationUtility fileGenerationUtility;
	
	@Value("${multiple.team.data}")
	private boolean setTeamFlag;
	
	@Value("${multiple.teams}")
	private String teamDetails;

	//Gets review detail data for review list
	@Override
	public List<RawReportData> getRawReviewReport(List<Reviews> openReviews) {
		
		List<RawReportData> reviewRawReportDataList = new ArrayList<RawReportData>();
		
		for(Reviews reviews : openReviews){
			
			if(reviews.getReviewData() != null && reviews.getReviewData().size() > 0){
				RawReportData rawReportData = new RawReportData();
				rawReportData.setName(reviews.getReviewData().get(0).getAuthor().getDisplayName());
				if(setTeamFlag) {
					setTeamName(rawReportData);
				}
				rawReportData.setReviewList(getReviewListForReport(reviews.getReviewData()));
				reviewRawReportDataList.add(rawReportData);
			}
		}
		
		
		
		return reviewRawReportDataList;
	}

	//Sets team name for authors if specified in application.properties
	private void setTeamName(RawReportData rawReportData) {

		if(teamDetails != null) {
			
			String[] teams = teamDetails.split(";");
			for(String team: teams) {
				if(team.indexOf(rawReportData.getName()) != -1) {
					rawReportData.setTeamName(team.substring(0, team.indexOf(":")));
				}
			}
		}
		
	}

	//Creates review report from the raw review data
	private List<ReviewSummary> getReviewListForReport(List<ReviewData> reviewData) {
		List<ReviewSummary> reviewSummaryList = new ArrayList<ReviewSummary>();
		
		for(ReviewData reviewDataDetails: reviewData){
			ReviewSummary reviewSummary = new ReviewSummary();
			reviewSummary.setReviewNum(reviewDataDetails.getPermaId().get("id"));
			reviewSummary.setReviewCreationDate(reviewDataDetails.getCreateDate());
			reviewSummary.setReviewClosedDate(reviewDataDetails.getCloseDate());
			
			setReviewSummaryDetails(reviewSummary);
			
			reviewSummaryList.add(reviewSummary);
		}
		return reviewSummaryList;
	}

	//sets the details for review report - num of files committed and comments received for the review
	private void setReviewSummaryDetails(ReviewSummary reviewSummary) {
		
		setNumFilesForReview(reviewSummary);
		setNumOfComments(reviewSummary);
	}

	private void setNumOfComments(ReviewSummary reviewSummary) {
		
		Comments comments = reviewDataService.getReviewCommentsData(reviewSummary.getReviewNum());

		if(comments != null && comments.getComments() != null && comments.getComments().size() > 0){
			
			reviewSummary.setNumOfComments(comments.getComments().size());
		}
		
	}

	private void setNumFilesForReview(ReviewSummary reviewSummary) {
		
		ReviewItems reviewItems = reviewDataService.getReviewItemsForReview(reviewSummary.getReviewNum());
		
		for(ReviewItem review : reviewItems.getReviewItem()){
				
			if(ReviewDashboardConstants.FILE.equals(review.getFileType())){
					reviewSummary.setNumOfFilesInReview(reviewSummary.getNumOfFilesInReview()+1);
			}
		}
		
	}

	@Override
	public void generateCsvFile(List<CodeReviewData> reviewDataList) {
		
		fileGenerationUtility.generateReviewDataFile(reviewDataList);
		
	}

}
