package com.emma_ea.springjwt.service;

import com.emma_ea.springjwt.model.AuthRequest;
import com.emma_ea.springjwt.model.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public AuthResponse login(AuthRequest authRequest) {
        return new AuthResponse("some-token");
    }

}
