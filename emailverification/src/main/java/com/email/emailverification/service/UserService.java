package com.email.emailverification.service;

import com.email.emailverification.model.Users;
import com.email.emailverification.repository.UsersRepository;
import com.email.emailverification.requests.RegisterRequest;
import com.email.emailverification.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service

public class UserService {
    private final UsersRepository repo;
    private final EmailService emailService;
    public UserService(UsersRepository repo, EmailService emailService){
        this.repo=repo;
        this.emailService = emailService;
    }

    public UsersRepository getRepo() {
        return repo;
    }

    public RegisterResponse register(RegisterRequest registerRequest){
      Users existing=repo.findByEmail(registerRequest.getEmail());
      if(existing!=null && existing.isVerified()){
          throw new RuntimeException("User already registered");
      }
      Users user= Users.builder()
              .username(registerRequest.getUsername())
              .email(registerRequest.getEmail())
              .password(registerRequest.getPassword())
              .build();
        String otp=generateotp();
        user.setOtp(otp);
      Users saved=repo.save(user);
      sendVerificationEmail(saved.getEmail(), otp);
      RegisterResponse response=RegisterResponse.builder()
              .username(user.getUsername())
              .email(user.getEmail())
              .build();

      return response;
  }
private String generateotp(){
        Random random=new Random();
        int otpvalue=100000+ random.nextInt(900000);
        return String.valueOf(otpvalue);
}
public void verify(String email,String otp){
        Users user=repo.findByEmail(email);
        if(user==null){
            throw new RuntimeException("User not found");
        } else if(user.isVerified()){
            throw  new RuntimeException("User already verified");
        } else if(otp.equals(user.getOtp())){
            user.setVerified(true);
            repo.save(user);
        } else{
            throw new RuntimeException("Internal Server Error");
        }
}
private void sendVerificationEmail(String email,String otp){
     String subject="Email verification";
     String body="your verification otp is:"+otp;
     emailService.sendEmail(email,subject,body);
    }
}
