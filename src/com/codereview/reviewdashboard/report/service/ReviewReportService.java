package com.codereview.reviewdashboard.report.service;

import java.util.List;

import com.codereview.reviewdashboard.report.data.CodeReviewData;
import com.codereview.reviewdashboard.report.data.RawReportData;
import com.codereview.reviewdashboard.review.data.Reviews;

public interface ReviewReportService {

	List<RawReportData> getRawReviewReport(List<Reviews> openReviews);

	void generateCsvFile(List<CodeReviewData> reviewDataList);
}
