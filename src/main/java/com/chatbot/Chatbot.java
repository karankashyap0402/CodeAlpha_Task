package com.chatbot;

public class Chatbot {
    private FAQData faqData;

    public Chatbot() {
        faqData = new FAQData("faq.txt");
    }

    public String getResponse(String input) {
        String processed = NLPProcessor.preprocess(input);
        return faqData.getAnswer(processed);
    }
}