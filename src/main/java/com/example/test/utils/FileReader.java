package com.example.test.utils;

import com.example.test.Model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
            List<Message> messages = objectMapper.readValue(
                    new File("src/main/resources/messages.json"),
                    new TypeReference<List<Message>>() {}
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Message> getMessages() {
        return messages;
    }
}
