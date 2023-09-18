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
    public UserDTO signIn(UserDTO userDTO) {
        UserDTO user = null;
        Optional<UserEntity> optionalUser = userRepository.findById(userDTO.getId());
        // DB에서 아이디가 있는경우
        if (optionalUser.isPresent()) {
            // System.out.println("Find By Id => "+optionalUser.get().toString());
            UserEntity entity = optionalUser.get();
            // DB의 비밀번호와 입력한 비밀번호가 같은경우
            if (entity.getPassword().equals(userDTO.getPassword()))
                user = UserDTO.toUserDTO(entity);
        }
        return user;
    }

    public void signUp(UserDTO user) {
        System.out.println("Service -> " + sha256Encode(user.getPassword()));
        System.out.println("Service -> " + user.toString());
    }

}
