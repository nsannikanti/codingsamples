package org.example;

import java.util.Arrays;

public class SmallestIntervalFinder {

    public static int findSmallestInterval(double[] numbers) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Input array must contain at least two numbers");
        }

        // Sort the array in ascending order
        Arrays.sort(numbers);

        double smallestInterval = Double.POSITIVE_INFINITY;

        // Iterate through the sorted array and find the smallest interval
        for (int i = 1; i < numbers.length; i++) {
            double currentInterval = numbers[i] - numbers[i - 1];
            if (currentInterval < smallestInterval) {
                smallestInterval = currentInterval;
            }
        }

        // Convert the smallest interval to an integer (rounded down)
        return (int) smallestInterval;
    }

    public static void main(String[] args) {
        // Example usage:
        double[] numbers = {1, 6, 4, 8, 2};

        // Print the result
        System.out.println("Smallest Interval: " + findSmallestInterval(numbers));
    }
}

