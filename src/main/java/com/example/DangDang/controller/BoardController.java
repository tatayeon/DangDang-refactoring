package com.example.DangDang.controller;

import com.example.DangDang.DTO.LoginDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/check")
    public String check() {
        return "check/check.html";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes, HttpSession session, RedirectAttributes redirectAttributes) throws IOException {
        // 파일을 저장할 기본 경로 설정
        Path root = Paths.get("/Users/imtaeyeon/aiTraining/shop/src/main/resources/static/uploads");

        // 경로가 존재하지 않으면 디렉토리를 생성
        if (!Files.exists(root)) {
            Files.createDirectories(root);  // 상위 디렉토리도 함께 생성
        }

        LoginDTO logIn = (LoginDTO) session.getAttribute("logIn");
        String originalFilename = file.getOriginalFilename();
        String newFilename = originalFilename;
        Path resolve = root.resolve(newFilename); // 파일 전체 경로 설정
        redirectAttributes.addFlashAttribute("fileName", newFilename); // 파일 이름을 Flash Attribute에 저장

        // 실제 파일 저장 (같은 이름의 파일이 있으면 덮어씀)
        Files.copy(file.getInputStream(), resolve, StandardCopyOption.REPLACE_EXISTING);

        // 두 번째 저장할 경로 설정 (필요에 따라 조정)
        Path resolve2 = Paths.get("/Users/imtaeyeon/uploads");

        // 경로가 존재하지 않으면 디렉토리를 생성
        if (!Files.exists(resolve2)) {
            Files.createDirectories(resolve2);  // uploads 디렉토리도 생성
        }

        Path resolve2File = resolve2.resolve(newFilename);
        Files.copy(file.getInputStream(), resolve2File, StandardCopyOption.REPLACE_EXISTING);

        return "redirect:/board/sendUpload";
    }

    @GetMapping("/sendUpload")
    public String sendFile(Model model, HttpSession session) {
        String fileName = (String) model.asMap().get("fileName");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> values = new LinkedMultiValueMap<>();
        values.add("fileName", fileName);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(values, headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8000/hello/test";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        session.setAttribute("re", response.getBody());
        session.setAttribute("fileName", fileName);

        String list = (String) session.getAttribute("list");
        model.addAttribute("list", list);

        return "redirect:/";
    }


}
