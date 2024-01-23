package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        int errorCount = 0;

        Map<String, Float> priceMap = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            priceMap.put(products.get(i), productPrices.get(i));
        }

        for (int j = 0; j < productSold.size(); j++) {
            if (priceMap.containsKey(productSold.get(j))) {
                float expectedPrice = priceMap.get(productSold.get(j));
                float actualPrice = soldPrice.get(j);

                if (actualPrice != expectedPrice) {
                    errorCount++;
                }
            }
        }

        return errorCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int productsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> products = IntStream.range(0, productsCount)
                .mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        int productPricesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Float> productPrices = IntStream.range(0, productPricesCount)
                .mapToObj(i -> {
                    try {
                        return Float.parseFloat(bufferedReader.readLine().trim());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        int productSoldCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> productSold = IntStream.range(0, productSoldCount)
                .mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        int soldPriceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Float> soldPrice = IntStream.range(0, soldPriceCount)
                .mapToObj(i -> {
                    try {
                        return Float.parseFloat(bufferedReader.readLine().trim());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        int result = Result.priceCheck(products, productPrices, productSold, soldPrice);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
