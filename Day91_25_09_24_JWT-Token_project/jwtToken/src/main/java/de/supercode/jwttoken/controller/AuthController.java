package de.supercode.jwttoken.controller;


import de.supercode.jwttoken.services.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication){
        String token = tokenService.generateToken(authentication);
        System.out.println("Token erstellt für " + authentication.getName());
        System.out.println("Token: " + token);
        return token;
    }
}
