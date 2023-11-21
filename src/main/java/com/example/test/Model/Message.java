package com.example.test.Model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private LocalDateTime date;
    private String message;
    private String house;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }




}
