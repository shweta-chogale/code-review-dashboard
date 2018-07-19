package com.codereview.reviewdashboard.review.data;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class VersionedLineCommentData {

	private Map<Object,Object> metrics;
	
	private String message;
	
	private boolean draft;
	
	private boolean deleted;
	
	private boolean defectRaised;
	
	private boolean defectApproved;
	
	private String readStatus;
	
	private UserInfo user;
	
	private Date createDate;
	
	private Object permaId;
	
	private List<Object> replies;
	
	private String messageAsHtml;
	
	private Map<String, String> permId;
	
	private Map<Object,Object> parentCommentId;
	
	private String fromLineRange;
	
	private String toLineRange;
	
	private Map<String, String> reviewItemId;

	public Map<Object, Object> getMetrics() {
		return metrics;
	}

	public void setMetrics(Map<Object, Object> metrics) {
		this.metrics = metrics;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isDraft() {
		return draft;
	}

	public void setDraft(boolean draft) {
		this.draft = draft;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isDefectRaised() {
		return defectRaised;
	}

	public void setDefectRaised(boolean defectRaised) {
		this.defectRaised = defectRaised;
	}

	public boolean isDefectApproved() {
		return defectApproved;
	}

	public void setDefectApproved(boolean defectApproved) {
		this.defectApproved = defectApproved;
	}

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Object getPermaId() {
		return permaId;
	}

	public void setPermaId(Object permaId) {
		this.permaId = permaId;
	}

	public List<Object> getReplies() {
		return replies;
	}

	public void setReplies(List<Object> replies) {
		this.replies = replies;
	}

	public String getMessageAsHtml() {
		return messageAsHtml;
	}

	public void setMessageAsHtml(String messageAsHtml) {
		this.messageAsHtml = messageAsHtml;
	}

	public Map<String, String> getPermId() {
		return permId;
	}

	public void setPermId(Map<String, String> permId) {
		this.permId = permId;
	}

	public Map<Object, Object> getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(Map<Object, Object> parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public String getFromLineRange() {
		return fromLineRange;
	}

	public void setFromLineRange(String fromLineRange) {
		this.fromLineRange = fromLineRange;
	}

	public String getToLineRange() {
		return toLineRange;
	}

	public void setToLineRange(String toLineRange) {
		this.toLineRange = toLineRange;
	}

	public Map<String, String> getReviewItemId() {
		return reviewItemId;
	}

	public void setReviewItemId(Map<String, String> reviewItemId) {
		this.reviewItemId = reviewItemId;
	}
	
	
}
