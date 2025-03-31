package streams;

import java.io.*;
import java.util.*;

public class CountWords {
    public static void main(String[] args) {
        String filePath = "streams/input.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Sort by frequency and get top 5 words
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Total Words: " + wordCount.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println("Top 5 Most Frequent Words:");
        sortedWords.stream().limit(5).forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue())
        );
    }
}

