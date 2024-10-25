package com.example.ssgssg.global.ocr;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Controller
@RequestMapping("/ocr/test")
public class OCRTestController {

    private final OCRService ocrService;

    //static 파일 테스트
    @GetMapping("/static")
    public ResponseEntity<List<String>> testOCR() throws IOException {
        String fileName = "test.jpg";
        File file = ResourceUtils.getFile("classpath:static/"+fileName);

        List<String> result = ocrService.callApi("POST", file.getPath(), "jpg");
        return ResponseEntity.ok(result);
    }

    //Upload 테스트
    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadOCR(@RequestParam("file") MultipartFile file) throws IOException {

        List<String> result = ocrService.uploadFileToOCR(file);

        return ResponseEntity.ok(result);
    }
}
