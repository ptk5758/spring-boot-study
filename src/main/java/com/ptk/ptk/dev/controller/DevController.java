package com.ptk.ptk.dev.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/dev")
public class DevController {

    @GetMapping
    public Map<String, String> getDev(HttpServletRequest request) {
        HttpSession session = request.getSession(true); // true 세션이 없으면 만들어서 반환
        session.setAttribute("sessionId", "dev");
        System.out.println(session.getAttribute("sessionId").toString());

        Map map = new HashMap();
        map.put("msg", "Good");
        map.put("sessionId", "ptk5758");
        return map;
    }

    @PostMapping
    public ResponseEntity requestCookie(HttpServletRequest request) {
        HttpSession session = request.getSession(true); // true 세션이 없으면 만들어서 반환
        System.out.println(session.getAttribute("sessionId").toString());

        return new ResponseEntity(HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity requestCookie(HttpServletResponse response) {
//        ResponseCookie cookie = ResponseCookie.from("sessionId", "dev")
//                .path("/dev")
//                .httpOnly(false)
//                .secure(false)
//                .sameSite("Lax")
//                .build();
//        response.addHeader("Set-Cookie", cookie.toString());
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
