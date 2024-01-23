package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicatesFilter {

    public static Double[] filterDuplicates(Double[] data) {
        List<Double> uniqueValues = Arrays.stream(data)
                .distinct()
                .collect(Collectors.toList());

        return uniqueValues.toArray(new Double[0]);
    }

    public static void main(String[] args) {
        // Example usage:
        Double[] inputData = {7.0, 6.0, 4.0, 33.0, 4.9, 6.0, 4.9};
        Double[] result = filterDuplicates(inputData);

        // Print the result
        Arrays.stream(result).forEach(value -> System.out.print(value + " "));
    }
}

