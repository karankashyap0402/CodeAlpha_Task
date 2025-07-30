package com.chatbot;

public class NLPProcessor {
    // public static String preprocess(String input) {
    // return input.trim().toLowerCase().replaceAll("[^a-z0-9 ]", "");
    // }
    public static String preprocess(String input) {
        return input.trim().toLowerCase().replaceAll("[^a-z0-9 ]", "");
    }

}