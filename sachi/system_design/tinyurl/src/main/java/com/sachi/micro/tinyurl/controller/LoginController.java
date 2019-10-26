package com.sachi.micro.tinyurl.controller;

import com.sachi.micro.tinyurl.model.LoginModel;
import com.sachi.micro.tinyurl.service.TinyUserDetailsService;
import com.sachi.micro.tinyurl.config.JWTTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JWTTokenUtil jwtTokenUtil, TinyUserDetailsService userDetailsService) {
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

    private void authenticate(String userName, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (DisabledException e) {
            log.error("User Disabled {}", userName);
            throw new Exception("User Disabled");
        } catch (BadCredentialsException e) {
            log.error("Bad username {}", userName);
            throw new Exception("Invalid Credentials");
        }
    }

}
