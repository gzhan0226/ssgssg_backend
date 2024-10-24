package com.example.ssgssg.global.ocr;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Controller
public class OCRController {

    private final OCRService ocrService;

    @Value("${cloud.naver-ocr.secret-key}")
    private String secret;

    @Value("${cloud.naver-ocr.api-url}")
    private String apiUrl;

    @GetMapping("/ocr/test")
    public ResponseEntity<List<String>> testOCR() throws IOException {
        String fileName = "test.jpg";
        File file = ResourceUtils.getFile("classpath:static/"+fileName);

        List<String> result = ocrService.callApi("POST", file.getPath(), apiUrl, secret, "jpg");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/ocr/upload")
    public ResponseEntity<List<String>> uploadOCR(@RequestParam("file") MultipartFile file) throws IOException {
        File tempFile = File.createTempFile("temp", file.getOriginalFilename());
        file.transferTo(tempFile);
        List<String> result = ocrService.callApi("POST", tempFile.getPath(), apiUrl, secret, "jpg");

        tempFile.delete(); // 임시 파일 삭제
        return ResponseEntity.ok(result);
    }
}
