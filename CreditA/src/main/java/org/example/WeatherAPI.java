package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherAPI {

    public static int getTemperature(String name) {
        try {
            // Construct the API URL
            String apiUrl = "https://jsonmock.hackerrank.com/api/weather?name=" + name;

            // Create a URL object and open the connection
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Parse the JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray data = jsonResponse.getJSONArray("data");

            // Get the temperature from the first record
            JSONObject firstRecord = data.getJSONObject(0);
            String weather = firstRecord.getString("weather");

            // Extract the integer value from the weather string
            int temperature = Integer.parseInt(weather.split(" ")[0]);

            return temperature;
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Handle exceptions, return -1 as an error indicator
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String cityName = "Dallas";
        int temperature = getTemperature(cityName);

        // Print the result
        System.out.println("Temperature in " + cityName + ": " + temperature);
    }
}

