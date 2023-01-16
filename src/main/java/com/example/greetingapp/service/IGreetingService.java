package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.User;

import java.util.List;

public interface IGreetingService {
    String getGreetingMessage();
    String getGreetingMessage(User user);
    Greeting addGreetingMessage(User user);
    Greeting getGreetingMsgById(long id);
    List<Greeting> getAllGreetingMsg();
    Greeting updateGreetingMsg(long id, User user);
}