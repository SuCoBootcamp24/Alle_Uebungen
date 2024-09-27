package de.supercode.quizzi.controller;

import de.supercode.quizzi.dtos.auth.AuthDTO;
import de.supercode.quizzi.entities.User;
import de.supercode.quizzi.services.AuthentificationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    AuthentificationService authentificationService;

    public AuthController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping("/signin")
    public void signin(@RequestBody AuthDTO dto, HttpServletRequest request, HttpServletResponse response){
        authentificationService.login(dto, request, response);
    }

    @PostMapping("/signup")
    public User signup(@RequestBody AuthDTO dto){
        return authentificationService.signUp(dto);
    }
}
