package com.emma_ea.springjwt.service;

import com.emma_ea.springjwt.model.AuthRequest;
import com.emma_ea.springjwt.model.AuthResponse;
import com.emma_ea.springjwt.model.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private AuthenticationManager manager;

    public ResponseEntity<HttpResponse<AuthResponse>> login(AuthRequest authRequest) {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(), authRequest.getPassword()
            ));
            var response = new HttpResponse<>(
                    HttpStatus.OK.name(),
                    "Authentication Success",
                    new AuthResponse("some-token")
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadCredentialsException bce) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
