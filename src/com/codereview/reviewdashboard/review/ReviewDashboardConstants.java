package com.codereview.reviewdashboard.review;

public final class ReviewDashboardConstants {
	
	public static final String ALL_REVIEWS_URL = "/rest-service/reviews-v1/filter?author={author}&fromDate={fromDate}&toDate={toDate}&states=Closed";

	public static final String REVIEW_DETAIL_URL = "/rest-service/reviews-v1/{id}/reviewitems";
			
	public static final String REVIEW_COMMENTS_URL = "/rest-service/reviews-v1/{id}/comments?render=false"; 
	
	public static final String URL_KEY_AUTHOR = "author";
	
	public static final String URL_KEY_FROMDATE = "fromDate";
	
	public static final String URL_KEY_TODATE = "toDate";
	
	public static final String FILE = "File";
	
	public static final String URL_KEY_ID = "id";
	
	public static final String FILE_HEADERS = "Name, Team, Reviews raised, Number of files affected, Number of review comments received, Created Date, Closed Date";
}
