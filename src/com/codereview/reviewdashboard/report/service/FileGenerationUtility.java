package com.codereview.reviewdashboard.report.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codereview.reviewdashboard.report.data.CodeReviewData;
import com.codereview.reviewdashboard.review.ReviewDashboardConstants;

@Service
public class FileGenerationUtility {
	
	@Value("${csv.filepath.win}")
	private String csvFilePathWin;
	
	@Value("${csv.filepath.unix}")
	private String csvFilePathUnix;

	//Creates csv file for the review data 
	void generateReviewDataFile(List<CodeReviewData> reviewDataList){
		
		try {
			PrintWriter writer = new PrintWriter(getCSVFilePath(), "UTF-8");
			writer.println(ReviewDashboardConstants.FILE_HEADERS);
			
			for(CodeReviewData codeReviewReportData : reviewDataList){
				
					writer.println(codeReviewReportData.getAuthorName() + ", " + codeReviewReportData.getTeamName() + ", " +
					codeReviewReportData.getCodeReviewId()+ ", " + codeReviewReportData.getNumOfFilesReveiwed() + ", " + 
					codeReviewReportData.getNumOfReviewComments() + ", " + codeReviewReportData.getReviewCreatedDate() + ", " + 
					codeReviewReportData.getReviewClosedDate());

			}
			
			writer.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
	}

	//Returns file path for csv file according to OS
	private String getCSVFilePath() {
		
		if(System.getProperty("os.name").indexOf("Win") != -1) {
			return csvFilePathWin;
		} else {
			return csvFilePathUnix;
		}
	}

}
