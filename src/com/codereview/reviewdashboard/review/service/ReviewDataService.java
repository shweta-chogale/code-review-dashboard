package com.codereview.reviewdashboard.review.service;



import com.codereview.reviewdashboard.review.data.Comments;
import com.codereview.reviewdashboard.review.data.ReviewItems;

public interface ReviewDataService {

	ReviewItems getReviewItemsForReview(String id);
	
	Comments getReviewCommentsData(String id);
}
