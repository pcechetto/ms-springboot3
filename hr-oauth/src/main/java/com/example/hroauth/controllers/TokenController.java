package com.example.hroauth.controllers;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hroauth.controllers.dto.LoginRequest;
import com.example.hroauth.controllers.dto.LoginResponse;
import com.example.hroauth.services.UserService;

@RestController
public class TokenController {

    @Autowired
    private JwtEncoder jwteEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var user = userService.findByEmail(loginRequest.username());

        if (!bCryptPasswordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw new UsernameNotFoundException("Invalid password");
        }

        var now = Instant.now();
        var expiresIn = 300L;

        var claims = JwtClaimsSet.builder()
            .issuer("mybackend")
            .subject(user.getEmail())
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiresIn))
            .build();

        var jwtValue = jwteEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
    }
}
