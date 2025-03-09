package com.example.config;

import com.example.command.CommandHandler;
import com.example.command.HelpCommand;
import com.example.command.RollDiceCommand;
import com.example.command.RollHighestTwoCommand;
import com.example.model.Command;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CommandConfig {

    @Bean
    public Map<Command, CommandHandler> commandHandlers(List<CommandHandler> handlers) {
        Map<Command, CommandHandler> commandMap = new EnumMap<>(Command.class);
        for (CommandHandler handler : handlers) {
            if (handler instanceof HelpCommand) {
                commandMap.put(Command.HELP, handler);
            } else if (handler instanceof RollDiceCommand) {
                commandMap.put(Command.ROLL_DICE, handler);
            } else if (handler instanceof RollHighestTwoCommand) {
                commandMap.put(Command.ROLL_HIGHEST_TWO, handler);
            }
        }
        return commandMap;
    }
}