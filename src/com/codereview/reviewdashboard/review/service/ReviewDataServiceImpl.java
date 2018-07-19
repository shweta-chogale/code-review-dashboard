package com.codereview.reviewdashboard.review.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codereview.reviewdashboard.http.HttpRequestResponseUtility;
import com.codereview.reviewdashboard.review.ReviewDashboardConstants;
import com.codereview.reviewdashboard.review.data.Comments;
import com.codereview.reviewdashboard.review.data.ReviewItems;

@Service
public class ReviewDataServiceImpl implements ReviewDataService {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Override
	public ReviewItems getReviewItemsForReview(String id) {
		
		HttpHeaders headers = HttpRequestResponseUtility.updateRequest();
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		Map<String, Object> urlVariables = new HashMap<String, Object>();
		
		populateUrlVariables(urlVariables, id);
		
		ResponseEntity<ReviewItems> result = restTemplate.exchange(HttpRequestResponseUtility.getFullURL(ReviewDashboardConstants.REVIEW_DETAIL_URL), HttpMethod.GET, 
				new HttpEntity<HttpHeaders>(null, headers), ReviewItems.class, urlVariables);
		
		
		return result.getBody();
	}
	
	private void populateUrlVariables(Map<String,Object> urlVariables, String id) {
		urlVariables.put(ReviewDashboardConstants.URL_KEY_ID, id);
	}

	@Override
	public Comments getReviewCommentsData(String id) {
		HttpHeaders headers = HttpRequestResponseUtility.updateRequest();
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		Map<String, Object> urlVariables = new HashMap<String, Object>();
		
		populateUrlVariables(urlVariables, id);
		
		ResponseEntity<Comments> result = restTemplate.exchange(HttpRequestResponseUtility.getFullURL(ReviewDashboardConstants.REVIEW_COMMENTS_URL), HttpMethod.GET, 
				new HttpEntity<HttpHeaders>(null, headers), Comments.class, urlVariables);
		
		
		return result.getBody();
	}

}
