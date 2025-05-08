package com.demo.Service;

import java.util.List;

import com.demo.entity.Feedback;
import com.demo.entity.Restaurant;

public interface FeedbackService
{
	Feedback createFeedback(Feedback feedback);	
	Feedback getFeedback(String feedbackID);
	List<Feedback> getAllFeedback();
	Feedback updateFeedback(String feedbackId,Feedback updatedFeedback);
	String deleteFeedback(String feedbackId);
}
