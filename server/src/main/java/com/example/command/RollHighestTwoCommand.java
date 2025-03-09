package com.example.command;

import com.example.service.impl.RandomNumberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RollHighestTwoCommand implements CommandHandler {

    private final RandomNumberServiceImpl randomNumberService;

    @Override
    public void execute(String[] args) {
        String result = randomNumberService.rollHighestTwo();
        System.out.println(result);
    }
}