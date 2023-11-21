package com.example.test;

import com.example.test.service.MessageReader;
import org.springframework.boot.SpringApplication;

public class RadarApplication {
    public static void main(String[] args) {
        SpringApplication.run(RadarApplication.class, args);

        MessageReader messageReader = new MessageReader();
        messageReader.decodeMessages();
    }
}
