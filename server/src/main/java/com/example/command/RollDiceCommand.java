package com.example.command;

import com.example.exception.InvalidInputException;
import com.example.service.impl.RandomNumberServiceImpl;
import com.example.util.InputValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RollDiceCommand implements CommandHandler {

    private final RandomNumberServiceImpl randomNumberService;

    @Override
    public void execute(String[] args) throws InvalidInputException {
        if (args.length < 2) {
            throw new InvalidInputException("Please specify dice size (e.g., 'roll-dice 6')");
        }

        int size = InputValidator.parsePositiveInt(args[1], "Dice size must be a positive number");
        int count = args.length > 2 ? InputValidator.parsePositiveInt(args[2], "Dice count must be positive") : 1;

        String result = randomNumberService.rollDice(size, count);
        System.out.println(result);
    }
}