package com.codereview.reviewdashboard.review.data;

public class Participant {

	private UserInfo user;
	
	private boolean completed;

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
}
