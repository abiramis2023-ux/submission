package com.example;

import java.util.ArrayList;
import java.util.List;

public class FeedbackService {

    private List<Feedback> feedbackList = new ArrayList<>();

    public boolean submitFeedback(String username, String message) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (message == null || message.length() < 5) {
            throw new IllegalArgumentException("Message must be at least 5 characters");
        }

        Feedback feedback = new Feedback(username, message);
        feedbackList.add(feedback);

        return true;
    }

    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }
}