package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.FeedbackService;
import com.demo.dao.FeedbackDao;
import com.demo.daoImpl.FeedbackDaoImpl;
import com.demo.entity.Feedback;

public class FeedbackServiceImpl implements FeedbackService
{
	FeedbackDao feedbackDao=new FeedbackDaoImpl();	
	@Override
	public Feedback createFeedback(Feedback feedback) {
		return feedbackDao.createFeedback(feedback);
	}
	@Override
	public Feedback getFeedback(String feedbackId) {
		return feedbackDao.getFeedback(feedbackId);
	}
	@Override
	public List<Feedback> getAllFeedback() {
		return feedbackDao.getAllFeedback();
	}
	@Override
	public Feedback updateFeedback(String feedbackId, Feedback updatedFeedback) {
		return feedbackDao.updateFeedback(feedbackId, updatedFeedback);
	}
	@Override
	public String deleteFeedback(String feedbackId) {
		return feedbackDao.deleteFeedback(feedbackId);
	}
}
