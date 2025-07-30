package com.chatbot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Chatbot chatbot = new Chatbot();

    @Override
    public void start(Stage primaryStage) {
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);
        TextField inputField = new TextField();
        Button sendButton = new Button("Send");

        sendButton.setOnAction(e -> {
            String userInput = inputField.getText();
            chatArea.appendText("You: " + userInput + "\n");
            String response = chatbot.getResponse(userInput);
            chatArea.appendText("Bot: " + response + "\n");
            inputField.clear();
        });

        VBox layout = new VBox(10, chatArea, inputField, sendButton);
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Chatbot");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
