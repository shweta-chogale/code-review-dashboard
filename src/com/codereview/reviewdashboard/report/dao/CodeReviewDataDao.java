package com.codereview.reviewdashboard.report.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.codereview.reviewdashboard.report.data.CodeReviewData;

@Transactional
@Repository
public class CodeReviewDataDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	//saves reveiw data to db
	public void saveAllCodeReviews(List<CodeReviewData> codeReviewList){	
		
		for(CodeReviewData codeReviewData : codeReviewList){
			
			entityManager.persist(codeReviewData);
		}
				
	}
}
