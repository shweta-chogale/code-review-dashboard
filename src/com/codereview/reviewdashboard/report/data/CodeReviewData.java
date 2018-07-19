package com.codereview.reviewdashboard.report.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="code_review_data")
public class CodeReviewData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3010868870813166253L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int codeReviewDataId;
	
	@Column(name="author_name")
	private String authorName;
	
	@Column(name="team_name")
	private String teamName;
	
	@Column(name="review_ID")
	private String codeReviewId;
	
	@Column(name="number_of_files")
	private Integer numOfFilesReveiwed;
	
	@Column(name="number_of_review_comments")
	private Integer numOfReviewComments;
	
	@Column(name="review_created_date")
	private Date reviewCreatedDate;
	
	@Column(name="review_closed_date")
	private Date reviewClosedDate;

	public int getCodeReviewDataId() {
		return codeReviewDataId;
	}

	public void setCodeReviewDataId(int codeReviewDataId) {
		this.codeReviewDataId = codeReviewDataId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCodeReviewId() {
		return codeReviewId;
	}

	public void setCodeReviewId(String codeReviewId) {
		this.codeReviewId = codeReviewId;
	}

	public Integer getNumOfFilesReveiwed() {
		return numOfFilesReveiwed;
	}

	public void setNumOfFilesReveiwed(Integer numOfFilesReveiwed) {
		this.numOfFilesReveiwed = numOfFilesReveiwed;
	}

	public Integer getNumOfReviewComments() {
		return numOfReviewComments;
	}

	public void setNumOfReviewComments(Integer numOfReviewComments) {
		this.numOfReviewComments = numOfReviewComments;
	}

	public Date getReviewCreatedDate() {
		return reviewCreatedDate;
	}

	public void setReviewCreatedDate(Date reviewCreatedDate) {
		this.reviewCreatedDate = reviewCreatedDate;
	}

	public Date getReviewClosedDate() {
		return reviewClosedDate;
	}

	public void setReviewClosedDate(Date reviewClosedDate) {
		this.reviewClosedDate = reviewClosedDate;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	
	
	
}

