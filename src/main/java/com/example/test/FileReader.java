package com.example.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileReader {
    private static final String FILE_PATH = "src/main/resources/messages.json";
    private static FileReader instance;
    private List<Message> messages;

    private FileReader() {
        loadMessagesFromFile();
    }

    public static FileReader getInstance() {
        if (instance == null) {
            instance = new FileReader();
        }
        return instance;
    }

    private void loadMessagesFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            messages = objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Message>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Message> getMessages() {
        return messages;
    }
}
