package com.example.ssgssg.global.gpt;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gpt/test")
public class GPTTestController {

    private final GPTService gptService;

    @GetMapping("/static")
    public String chat(){
        String system_prompt="only answer in korean";
        String user_prompt="where is seoul?";
       return gptService.callAPI(system_prompt, user_prompt);
    }
}