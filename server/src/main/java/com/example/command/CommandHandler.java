package com.example.command;

import com.example.exception.InvalidInputException;

public interface CommandHandler {
    void execute(String[] args) throws InvalidInputException;
}