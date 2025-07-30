package com.chatbot;

import java.io.*;
import java.util.*;

public class FAQData {
    private Map<String, String> faqMap = new HashMap<>();

    public FAQData(String path) {
        loadFAQs(path);
    }

    private void loadFAQs(String path) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("faq.txt");
         BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    faqMap.put(parts[0].toLowerCase(), parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Could not load FAQ file: " + e.getMessage());
        }
    }

    public String getAnswer(String question) {
        return faqMap.getOrDefault(question.toLowerCase(), "Sorry, I don't know that yet.");
    }
}
