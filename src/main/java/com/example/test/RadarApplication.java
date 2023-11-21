package com.example.test;

import com.example.test.service.MessageReader;

import java.util.List;

public class RadarApplication {

    public static void main(String[] args) {
        MessageReader messageReader = new MessageReader();
        List<String> decodedMessages = messageReader.decodeMessages();

        for(String message : decodedMessages) {
            System.out.println(message);
        }
    }
}
