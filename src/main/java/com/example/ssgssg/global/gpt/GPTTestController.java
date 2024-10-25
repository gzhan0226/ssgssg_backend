package com.example.ssgssg.global.gpt;


import com.example.ssgssg.global.gpt.dto.GPTRequestDto;
import com.example.ssgssg.global.gpt.dto.GPTResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gpt")
public class GPTTestController {

    private final GPTService gptService;

    @GetMapping("/test")
    public String chat(@RequestBody String prompt){
        String system_prompt="only answer in korean";
        String user_prompt="where is seoul?";
       return gptService.callAPI(system_prompt, user_prompt);
    }
}