package com.example.model;

public enum Command {
    HELP("help"),
    ROLL_DICE("roll-dice"),
    ROLL_HIGHEST_TWO("roll-highest-two");

    private final String commandName;

    Command(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public static Command fromString(String commandName) {
        for (Command command : Command.values()) {
            if (command.commandName.equalsIgnoreCase(commandName)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Unknown command: " + commandName);
    }
}