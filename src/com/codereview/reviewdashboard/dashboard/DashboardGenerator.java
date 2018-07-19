package com.codereview.reviewdashboard.dashboard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codereview.reviewdashboard.review.service.ReviewDashboardService;

/** Dashboard generator class for entry point 
 * To be used for any initialization process **/
@Component
public class DashboardGenerator {
	
	
	@Autowired
	ReviewDashboardService reviewDashboardService;
	
	//Triggers code review dashboard data generation
	public void generateReviewDashboard(){
		
		reviewDashboardService.generateReviewDashboardData();
		
	}
	

	
}
