package com.example.service.impl;

import com.example.exception.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class RandomNumberServiceImpl {

    public String rollDice(int size, int count) throws InvalidInputException {
        if (size <= 0 || count <= 0) {
            throw new InvalidInputException("Dice size and count must be positive numbers");
        }

        int[] rolls = new int[count];
        for (int i = 0; i < count; i++) {
            rolls[i] = getRandomNumber(size);
        }

        String result = Arrays.stream(rolls).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        int total = Arrays.stream(rolls).sum();

        return formatRollResult(size, count, result, total);
    }

    public String rollHighestTwo() {
        final int DICE_COUNT = 5;
        final int DICE_SIZE = 6;
        final int HIGHEST_TO_KEEP = 2;

        int[] rolls = new int[DICE_COUNT];
        for (int i = 0; i < DICE_COUNT; i++) {
            rolls[i] = getRandomNumber(DICE_SIZE);
        }

        String allRolls = Arrays.stream(rolls).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        int[] sortedRolls = Arrays.stream(rolls)
                .boxed()
                .sorted((a, b) -> b.compareTo(a))
                .mapToInt(Integer::intValue)
                .toArray();

        int total = Arrays.stream(sortedRolls).limit(HIGHEST_TO_KEEP).sum();
        String highest = Arrays.stream(sortedRolls)
                .limit(HIGHEST_TO_KEEP)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        return formatHighestTwoResult(DICE_SIZE, DICE_COUNT, allRolls, highest, total);
    }

    private int getRandomNumber(int size) {
        return (int) (Math.random() * size) + 1;
    }

    private String formatRollResult(int size, int count, String rolls, int total) {
        return String.format(
                "---- Rolling %dd%d ----\nResults: %s\nTotal: %d\n",
                count, size, rolls, total
        );
    }

    private String formatHighestTwoResult(int size, int count, String allRolls, String highest, int total) {
        return String.format(
                "---- Rolling %dd%d, keeping highest 2 ----\nAll rolls: %s\nHighest 2: %s\nTotal: %d\n",
                count, size, allRolls, highest, total
        );
    }
}