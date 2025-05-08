package com.demo.dao;

import java.util.List;

import com.demo.entity.Feedback;

public interface FeedbackDao {
	Feedback createFeedback(Feedback feedback);
	Feedback getFeedback(String feedbackID);
	List<Feedback> getAllFeedback();
	Feedback updateFeedback(String feedbackId,Feedback updatedFeedback);
	String deleteFeedback(String feedbackId);
}
