package com.plea11.ahms.controllers;

import com.plea11.ahms.Utils.JwtUtil;
import com.plea11.ahms.common.model.AuthenticationResponse;
import com.plea11.ahms.restmodels.LogInRM;
import com.plea11.ahms.service.LogInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author bhukyabhanuprakash
 */

@RestController
@RequestMapping("/hotel/v1")
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private LogInService loginService; // Using your LoginService instead of direct implementation

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LogInRM authRequest) throws Exception {
        log.info("createAuthenticationToken method in login resource called");
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getIdentifier(),
                        authRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String jwtToken = jwtUtil.generateToken(authentication);

        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }

}
