package com.codereview.reviewdashboard.report.data;

import java.util.Date;

public class ReviewSummary {

	private String reviewNum;
	
	private Integer numOfFilesInReview = 0;
	
	private Integer numOfComments = 0;
	
	private Date reviewCreationDate;
	
	private Date reviewClosedDate;

	public String getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}

	public Integer getNumOfFilesInReview() {
		return numOfFilesInReview;
	}

	public void setNumOfFilesInReview(Integer numOfFilesInReview) {
		this.numOfFilesInReview = numOfFilesInReview;
	}

	public Integer getNumOfComments() {
		return numOfComments;
	}

	public void setNumOfComments(Integer numOfComments) {
		this.numOfComments = numOfComments;
	}

	public Date getReviewCreationDate() {
		return reviewCreationDate;
	}

	public void setReviewCreationDate(Date reviewCreationDate) {
		this.reviewCreationDate = reviewCreationDate;
	}

	public Date getReviewClosedDate() {
		return reviewClosedDate;
	}

	public void setReviewClosedDate(Date reviewClosedDate) {
		this.reviewClosedDate = reviewClosedDate;
	}
	
	
}
