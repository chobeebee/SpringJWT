package com.example.SpringJWT.controller;

import com.example.SpringJWT.dto.JoinDTO;
import com.example.SpringJWT.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody //API서버 응답 처리
public class JoinController {
    private final JoinService joinService;
    
    //생성자 주입
    public JoinController(JoinService joinService) {

        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO) {

        System.out.println(joinDTO.getUsername());
        joinService.joinProcess(joinDTO);

        return "ok";
    }
}
