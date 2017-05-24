package com.cc.onlinetest.service.impl;

import com.cc.onlinetest.dao.QuestionDao;
import com.cc.onlinetest.dao.SubjectDao;
import com.cc.onlinetest.domain.Choice;
import com.cc.onlinetest.domain.Judge;
import com.cc.onlinetest.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{

	private QuestionDao questionDao;
	private SubjectDao subjectDao;
	
	/**
	 * @param subjectDao the subjectDao to set
	 */
	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	/**
	 * @param questionDao the questionDao to set
	 */
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public boolean addChoice(Choice choice) {
		// TODO Auto-generated method stub
		boolean b = questionDao.addChoice(choice);
		//同时需要对subject的choiceNum进行修改
		subjectDao.setChoiceNum(choice.getSubject());
		//同时需要对总分进行修改
		subjectDao.setAllScore(choice.getSubject());
		return b;
	}

	@Override
	public boolean addJudge(Judge judge) {
		// TODO Auto-generated method stub
		boolean b = questionDao.addJudge(judge);
		//同时需要对subject的judgeNum进行修改
		subjectDao.setJudgeNum(judge.getSubject());
		//同时需要对总分进行修改
		subjectDao.setAllScore(judge.getSubject());
		return b;
	}

	

	
	
}