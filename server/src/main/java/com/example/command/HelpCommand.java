package com.example.command;

import org.springframework.stereotype.Component;

@Component
public class HelpCommand implements CommandHandler {
    @Override
    public void execute(String[] args) {
        System.out.println("Available commands:");
        System.out.println("  roll-dice <size> [count] - Roll dice of specified size (optional count, default 1)");
        System.out.println("    Example: 'roll-dice 6' or 'roll-dice 6 3'");
        System.out.println("  roll-highest-two - Roll 5 six-sided dice and sum the highest 2 values");
        System.out.println("  help - Show this help message");
    }
}