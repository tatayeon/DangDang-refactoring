package com.example.DangDang.service;


import com.example.DangDang.DTO.LoginDTO;
import com.example.DangDang.DTO.UserRegisterDTO;
import com.example.DangDang.domain.User;
import com.example.DangDang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User login(LoginDTO requestDTO) {
        Optional<User> loginUser = userRepository.findByUserName(requestDTO.getUsername());

        if(loginUser.isPresent() && loginUser.get().getPassword().equals(requestDTO.getPassword())) {
            return loginUser.get();
        }
        return null;
    }

    // Custom exception for user already exists
    public class UserAlreadyExistsException extends RuntimeException {
        public UserAlreadyExistsException(String message) {
            super(message);
        }
    }

    // Registration service
    @Transactional
    public String register(UserRegisterDTO requestDTO) {
        Optional<User> existingUser = userRepository.findByNickName(requestDTO.getNickName());

        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("이미 존재하는 회원입니다.");
        }

        User user = new User(requestDTO.getUserName(), requestDTO.getPassword(), requestDTO.getNickName());
        userRepository.save(user);

        return user.getNickName();
    }

}
