package com.example.greetingapp.service;

import com.example.greetingapp.model.User;

public interface IGreetingService {
    String getGreetingMessage();
    String getGreetingMessage(User user);
}