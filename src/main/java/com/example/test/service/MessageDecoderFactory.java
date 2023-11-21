package com.example.test.service;

public class MessageDecoderFactory {
    public static MessageDecodor getMessageDecoder(String house) {
        if ("atreides".equals(house)) {
            return new AtreidesMessageDecoder();
        } else if ("harkonnen".equals(house)) {
            return new HarkonnenMessageDecoder();
        }
        return null;
    }
}
