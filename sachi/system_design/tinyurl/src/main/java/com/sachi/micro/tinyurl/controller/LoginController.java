package com.sachi.micro.tinyurl.controller;

import com.sachi.micro.tinyurl.config.JWTTokenUtil;
import com.sachi.micro.tinyurl.exception.UnauthorizedException;
import com.sachi.micro.tinyurl.model.LoginModel;
import com.sachi.micro.tinyurl.service.TinyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JWTTokenUtil jwtTokenUtil;
    private final TinyUserDetailsService userDetailsService;

    public LoginController(AuthenticationManager authenticationManager, JWTTokenUtil jwtTokenUtil,
                           TinyUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<LoginModel> signUp(@Valid @RequestBody LoginModel loginModel) throws Exception {
        authenticate(loginModel.getUserName(), loginModel.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(LoginModel.builder().token(token).build());
    }

    private void authenticate(String userName, String password) throws UnauthorizedException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (DisabledException | BadCredentialsException e) {
            log.error("Invalid login attempt {}", userName);
            throw new UnauthorizedException("User Disabled");
        }
    }
}
