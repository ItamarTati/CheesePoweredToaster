package com.example.service.impl;

import com.example.command.CommandHandler;
import com.example.exception.InvalidInputException;
import com.example.model.Command;
import com.example.service.DiceService;
import com.example.service.ParseCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {

    private final Map<Command, CommandHandler> commandHandlers;
    private final ParseCommandService parseCommandService;

    @Override
    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter Command:");
                String input = scanner.nextLine().trim();
                String[] commandArgs = parseCommandService.getArgs(input);

                try {
                    Command command = Command.fromString(commandArgs[0]);
                    CommandHandler handler = commandHandlers.get(command);
                    if (handler != null) {
                        handler.execute(commandArgs);
                    } else {
                        System.out.println("Unknown command. Type 'help' for available commands.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid command: " + commandArgs[0]);
                    System.out.println("Type 'help' for available commands.");
                } catch (InvalidInputException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Please enter a valid command. Type 'help' for assistance.");
                }
            }
        }
    }
}