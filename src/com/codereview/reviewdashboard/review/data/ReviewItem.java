package com.codereview.reviewdashboard.review.data;

import java.util.List;
import java.util.Map;

public class ReviewItem {
	
	private Map<String, String> permId;
	
	private List<Participant> participants;
	
	private String repositoryName;
	
	private String fromPath;
	
	private String fromRevision;
	
	private String fromContentUrl;
	
	private String toPath;
	
	private String toRevision;
	
	private String toContentUrl;
	
	private String fileType;
	
	private String commitType;
	
	private String authorName;
	
	private boolean showAsDiff;
	
	private long commitDate;

	public Map<String, String> getPermId() {
		return permId;
	}

	public void setPermId(Map<String, String> permId) {
		this.permId = permId;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}

	public String getFromPath() {
		return fromPath;
	}

	public void setFromPath(String fromPath) {
		this.fromPath = fromPath;
	}

	public String getFromRevision() {
		return fromRevision;
	}

	public void setFromRevision(String fromRevision) {
		this.fromRevision = fromRevision;
	}

	public String getFromContentUrl() {
		return fromContentUrl;
	}

	public void setFromContentUrl(String fromContentUrl) {
		this.fromContentUrl = fromContentUrl;
	}

	public String getToPath() {
		return toPath;
	}

	public void setToPath(String toPath) {
		this.toPath = toPath;
	}

	public String getToRevision() {
		return toRevision;
	}

	public void setToRevision(String toRevision) {
		this.toRevision = toRevision;
	}

	public String getToContentUrl() {
		return toContentUrl;
	}

	public void setToContentUrl(String toContentUrl) {
		this.toContentUrl = toContentUrl;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getCommitType() {
		return commitType;
	}

	public void setCommitType(String commitType) {
		this.commitType = commitType;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public boolean isShowAsDiff() {
		return showAsDiff;
	}

	public void setShowAsDiff(boolean showAsDiff) {
		this.showAsDiff = showAsDiff;
	}

	public long getCommitDate() {
		return commitDate;
	}

	public void setCommitDate(long commitDate) {
		this.commitDate = commitDate;
	}
	
	

}
