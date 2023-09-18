package com.ptk.ptk.user.service;

import com.google.common.hash.Hashing;
import com.ptk.ptk.user.dto.UserDTO;
import com.ptk.ptk.user.entity.UserEntity;
import com.ptk.ptk.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private String sha256Encode(String plainPassword) {
        return Hashing.sha256().hashString(plainPassword, StandardCharsets.UTF_8).toString();
    }
    public void signIn(Long id) {
        UserEntity user = null;
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            System.out.println("Find By Id => "+optionalUser.get().toString());
        }
    }

    public void signUp(UserDTO user) {
        System.out.println("Service -> " + sha256Encode(user.getPassword()));
        System.out.println("Service -> " + user.toString());
    }

}
