package com.ptk.ptk.user.controller;

import com.ptk.ptk.user.dto.UserDTO;
import com.ptk.ptk.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Map<String, String> getUser() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("message", "Hello!");
        return result;
    }

    @PostMapping
    public Map<String, String> signId(@RequestBody UserDTO user, HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        UserDTO userDTO = userService.signIn(user);
        if (userDTO != null) {
            // System.out.println(userDTO.toString());
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", userDTO.getId());
            result.put("message", "success");

        } else {
            // System.out.println("사용자 없음");
            result.put("message", "fail");
        }
        return result;
    }

    @GetMapping(value = "/test")
    public Map<String, String> userTest(HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        HttpSession session = request.getSession();
        result.put("sessionId", (String) session.getAttribute("sessionId"));
        return result;
    }

}
