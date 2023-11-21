package com.example.test.service;

import com.example.test.Model.Message;
import com.example.test.utils.FileReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;


import java.awt.*;

public class MessageReader {
    private final List<Message> messages;

    public MessageReader() {
        messages = readMessagesFromFile();
    }

    public void decodeMessages() {
        for (Message message : messages) {
            if ("atreides".equalsIgnoreCase(message.getHouse())) {
                MessageDecodor decoder = new AtreidesMessageDecoder();
                decoder.decodeMessage(message);
            } else if ("harkonnen".equalsIgnoreCase(message.getHouse())) {
                MessageDecodor decoder = new HarkonnenMessageDecoder();
                decoder.decodeMessage(message);
            }
        }
    }

    private List<Message> readMessagesFromFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File("src/messages.json"), new TypeReference<List<Message>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
