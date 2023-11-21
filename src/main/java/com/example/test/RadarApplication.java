package com.example.test;

import com.example.test.Model.Message;
import com.example.test.service.MessageDecoderFactory;
import com.example.test.service.MessageDecoderStrategy;
import com.example.test.service.MessageDecodor;
import com.example.test.service.MessageReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class RadarApplication {

    public static void main(String[] args) throws IOException {
        List<Message> messages = new ObjectMapper().readValue(
                new URL("file:src/main/resources/messages.json"),
                new TypeReference<List<Message>>() {
                }
        );

        MessageDecoderStrategy decoderStrategy = new MessageDecoderStrategy();

        for (Message message : messages) {
            MessageDecodor decoder = MessageDecoderFactory.getMessageDecoder(message.getHouse());
            if (decoder != null) {
                decoderStrategy.setDecoder(decoder);
                String decodedMessage = decoderStrategy.decodeMessage(message.getMessage());
                System.out.println("Decoded message: " + decodedMessage);
            }
        }
    }
}
