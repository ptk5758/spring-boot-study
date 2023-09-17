package com.ptk.ptk.user.service;

import com.google.common.hash.Hashing;
import com.ptk.ptk.user.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UserService {

    private String sha256Encode(String plainPassword) {
        return Hashing.sha256().hashString(plainPassword, StandardCharsets.UTF_8).toString();
    }

    public void signUp(UserDTO user) {
        System.out.println("Service -> " + sha256Encode(user.getPassword()));
    }

}
