package com.itscheap.shopping_list_backend.service;

// Import Java libraries for HTTP and JSON
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

// Service annotation makes this class available for dependency injection
@Service
public class HuggingFaceClient {

    // Set your Hugging Face API URL and token here (move token to application.properties for security)
    private static final String API_URL = "https://api-inference.huggingface.co/models/juliensimon/recipe-ner";
    private static final String API_TOKEN = "YOUR_HF_API_TOKEN"; // Replace with your token!

    /**
     * Extracts ingredients and quantities from a recipe using Hugging Face API.
     * @param recipeText The recipe string input by the user.
     * @return Raw JSON response from the API.
     * @throws IOException if the HTTP request fails.
     */
    public String extractIngredients(String recipeText) throws IOException {
        // Setup HTTP connection
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Set request method and headers for Hugging Face API
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Format input as required JSON
        String jsonInput = "{\"inputs\": \"" + recipeText.replace("\"", "\\\"") + "\"}";

        // Send data
        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes(StandardCharsets.UTF_8));
        }

        // Get the response
        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
        }

        // Return JSON string (to be parsed later)
        return response.toString();
    }
}
