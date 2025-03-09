package com.example;

import com.example.service.impl.ParseCommandServiceImpl;
import com.example.service.impl.RandomNumberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.MessageFormat;
import java.util.Scanner;

@SpringBootApplication
@AllArgsConstructor

public class SpringBootConsoleApplication
        implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class);
    }

    private final RandomNumberServiceImpl randomNumberService;
    private final ParseCommandServiceImpl parseCommandService;

    @Override
    public void run(String... args) {

        System.out.println("Enter Command:");
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String[] commandArgs = parseCommandService.getArgs(command);

        if (commandArgs[0].equals("roll-dice")) {

            System.out.println(MessageFormat.format("---- Rolling 1d{0} ----", commandArgs[1]));
            int rollValue = randomNumberService.getRandomNumber(Integer.parseInt(commandArgs[1]));
            System.out.println(rollValue);

        } else {
            System.out.println("No matching command found, try using the command 'help'");
        }
    }
}