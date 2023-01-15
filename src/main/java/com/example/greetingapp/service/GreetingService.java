package com.example.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService{

    public String getGreetingMessage(){
        return "Hello World!";
    }
}