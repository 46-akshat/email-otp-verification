package com.email.emailverification.Controller;

import com.email.emailverification.requests.RegisterRequest;
import com.email.emailverification.response.RegisterResponse;
import com.email.emailverification.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
//@RequiredArgsConstructor
public class AuthController {
    private final UserService service;
    public AuthController(UserService service) {
        this.service = service;
    }
@PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse=service.register(registerRequest);
        return new ResponseEntity<>(registerResponse, HttpStatus.CREATED);
    }
@PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestParam String email,@RequestParam String otp){
        try{
            service.verify(email, otp);
            return new ResponseEntity<>("User verified successfully",HttpStatus.OK);
        } catch (RuntimeException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
