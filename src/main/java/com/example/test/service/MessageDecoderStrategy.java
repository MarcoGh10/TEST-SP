package com.example.test.service;

import com.example.test.Model.Message;

public class MessageDecoderStrategy {
    private MessageDecodor decoder;

    public void setDecoder(MessageDecodor decoder) {
        this.decoder = decoder;
    }

    public String decodeMessage(String message) {
        if (decoder == null) {
            throw new IllegalStateException("Decoder not set");
        }
        return decodeMessage(message);
    }
}
