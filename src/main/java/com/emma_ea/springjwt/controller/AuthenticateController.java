package com.emma_ea.springjwt.controller;

import com.emma_ea.springjwt.model.AuthRequest;
import com.emma_ea.springjwt.model.AuthResponse;
import com.emma_ea.springjwt.model.HttpResponse;
import com.emma_ea.springjwt.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticateController {

    private final AuthService service;

    public AuthenticateController(AuthService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HttpResponse<AuthResponse>> login(@RequestBody AuthRequest request) {
        return service.login(request);
    }

}
