package com.example.test.service;

import com.example.test.Model.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageReader {
    private final List<Message> messages;

    public MessageReader() {
        messages = readMessagesFromFile();
    }

    private List<Message> readMessagesFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File("src/main/resources/messages.json"), new TypeReference<List<Message>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> decodeMessages() {
        List<String> decodedMessages = new ArrayList<>();
        decodedMessages.add("Mesaj decodat 1");
        decodedMessages.add("Mesaj decodat 2");
        return decodedMessages;
    }
}
