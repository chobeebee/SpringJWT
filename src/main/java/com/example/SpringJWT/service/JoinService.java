package com.example.SpringJWT.service;

import com.example.SpringJWT.dto.JoinDTO;
import com.example.SpringJWT.entity.UserEntity;
import com.example.SpringJWT.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    //생성자 주입
    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        //초기화
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    //회원 가입 진행
    public void joinProcess(JoinDTO joinDTO) {

        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();
        
        //회원이 이미 존재하는 지 검증
        Boolean isExist = userRepository.existsByUsername(username);
        
        //존재하면 강제 종료
        if (isExist) {

            return;
        }

        //문제 없다면 회원 가입 진행
        UserEntity data = new UserEntity(); //DTO를 Entity로 옮겨주기 위해

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");
        
        //DB 저장
        userRepository.save(data);
    }
}
