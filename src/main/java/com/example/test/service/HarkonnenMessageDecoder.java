package com.example.test.service;

import com.example.test.Model.Message;
import lombok.Data;

@Data
public class HarkonnenMessageDecoder implements MessageDecodor{

    @Override
    public void decodeMessage(Message message) {
        String decodedMessage = message.getMessage().replace("Jbppf", "Messi").replace("Oguuk", "Messi");
        System.out.println("Decoded message from Harkonnen: " + decodedMessage);
    }
}
