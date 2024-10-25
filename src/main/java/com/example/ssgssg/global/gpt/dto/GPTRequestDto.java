package com.example.ssgssg.global.gpt.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GPTRequestDto {
    private String model;
    private List<Message> messages;

    public GPTRequestDto(String model, String system_prompt , String user_prompt) {
        this.model = model;
        this.messages =  new ArrayList<>();
        this.messages.add(new Message("system", system_prompt));
        this.messages.add(new Message("user", user_prompt));
    }
}