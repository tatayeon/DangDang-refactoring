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

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    @Transactional
    public User login(String username, String password) {
        Optional<User> loginUser = userRepository.findByUserName(username);
        System.out.println("username : " + username + ", password : " + password);

        if (loginUser.isPresent()) {
            if (loginUser.get().getPassword().equals(password)) {
                return loginUser.get();
            } else {
                throw new IllegalArgumentException("Incorrect password");
            }
        } else {
            throw new UserNotFoundException("User not found with username: " + username);
        }
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
