package com.example.tutorlink.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    // Method to notify the student
    public void notifyStudent(Long studentId, String message) {

        System.out.println("Notifying student ID " + studentId + ": " + message);
    }

    // Method to notify the tutor
    public void notifyTutor(Long tutorId, String message) {

        System.out.println("Notifying tutor ID " + tutorId + ": " + message);
    }
}
