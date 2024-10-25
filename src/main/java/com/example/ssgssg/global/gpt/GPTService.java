package com.example.ssgssg.global.gpt;

import com.example.ssgssg.global.gpt.dto.GPTRequestDto;
import com.example.ssgssg.global.gpt.dto.GPTResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GPTService {
    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api-url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;
    public String  callAPI(String test_prompt, String user_prompt) {
        GPTRequestDto request = new GPTRequestDto(model, test_prompt ,user_prompt);
        GPTResponseDto chatGPTResponse =  template.postForObject(apiURL, request, GPTResponseDto.class);
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }
}
