package com.codereview.reviewdashboard.report.data;

import java.util.ArrayList;
import java.util.List;

public class RawReportData {

	private String name;
	
	private String teamName;
	
	private List<ReviewSummary> reviewList = new ArrayList<ReviewSummary>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<ReviewSummary> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewSummary> reviewList) {
		this.reviewList = reviewList;
	}
	
	
}
