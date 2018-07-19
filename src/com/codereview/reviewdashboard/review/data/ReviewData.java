package com.codereview.reviewdashboard.review.data;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewData {
	
	private String projectKey;
	
	private String name;
	
	private String description;
	
	private Author author;
	
	private Moderator moderator;
	
	private Creator creator;
	
	private Map<String, String> permaId;
	
	private List<String> permaIdHistory;
	
	private String state;
	
	private String type;
	
	private boolean allowReviewersToJoin;
	
	private Integer metricsVersion;
	
	private Date createDate;
	
	private Date closeDate;
	
	private Date dueDate;

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Map<String, String> getPermaId() {
		return permaId;
	}

	public void setPermaId(Map<String, String> permaId) {
		this.permaId = permaId;
	}

	public List<String> getPermaIdHistory() {
		return permaIdHistory;
	}

	public void setPermaIdHistory(List<String> permaIdHistory) {
		this.permaIdHistory = permaIdHistory;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAllowReviewersToJoin() {
		return allowReviewersToJoin;
	}

	public void setAllowReviewersToJoin(boolean allowReviewersToJoin) {
		this.allowReviewersToJoin = allowReviewersToJoin;
	}

	public Integer getMetricsVersion() {
		return metricsVersion;
	}

	public void setMetricsVersion(Integer metricsVersion) {
		this.metricsVersion = metricsVersion;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Moderator getModerator() {
		return moderator;
	}

	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}
	
	

}
