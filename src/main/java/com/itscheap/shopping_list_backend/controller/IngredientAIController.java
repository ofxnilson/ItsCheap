// Controller for handling ingredient extraction
package com.itscheap.shopping_list_backend.controller;

import com.itscheap.shopping_list_backend.service.HuggingFaceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Annotation to mark this as a REST controller
@RestController
@RequestMapping("/api/ingredients")
public class IngredientAIController {

    // Inject HuggingFaceClient as a dependency
    @Autowired
    private HuggingFaceClient huggingFaceClient;

    /**
     * POST endpoint to extract ingredients from user-input recipe.
     * @param request Object with a 'recipe' field (JSON).
     * @return JSON result from Hugging Face API.
     */
    @PostMapping("/extract")
    public ResponseEntity<String> extractIngredients(@RequestBody RecipeRequest request) {
        try {
            // Call Hugging Face and return the response
            String result = huggingFaceClient.extractIngredients(request.getRecipe());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // If there's an error, return HTTP 500
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    // Helper class for incoming JSON payload
    public static class RecipeRequest {
        private String recipe;

        public String getRecipe() { return recipe; }
        public void setRecipe(String recipe) { this.recipe = recipe; }
    }
}
