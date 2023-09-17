package com.ptk.ptk.user.controller;

import com.ptk.ptk.user.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public Map<String, String> getUser() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("message", "Hello!");
        return result;
    }

    @PostMapping
    public Map<String, String> postUser(@RequestBody UserDTO user) {
        Map<String, String> result = new HashMap<String, String>();
        System.out.println(user.toString());
        return result;
    }
}
