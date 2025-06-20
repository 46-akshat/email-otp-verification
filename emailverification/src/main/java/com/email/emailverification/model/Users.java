package com.email.emailverification.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
public class Users {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long userid;

   private String username;
   private String email;
   private String password;
   private String otp;
   private boolean verified;

   public Users() {
      // No-arg constructor
   }

   public Users(String username, String email, String password, String otp, boolean verified) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.otp = otp;
      this.verified = verified;
   }

   // Getters
   public long getUserid() { return userid; }
   public String getUsername() { return username; }
   public String getEmail() { return email; }
   public String getPassword() { return password; }
   public String getOtp() { return otp; }
   public boolean isVerified() { return verified; }

   // Setters
   public void setUserid(long userid) { this.userid = userid; }
   public void setUsername(String username) { this.username = username; }
   public void setEmail(String email) { this.email = email; }
   public void setPassword(String password) { this.password = password; }
   public void setOtp(String otp) { this.otp = otp; }
   public void setVerified(boolean verified) { this.verified = verified; }

   // ✅ Manual Builder class
   public static class Builder {
      private String username;
      private String email;
      private String password;
      private String otp;
      private boolean verified;

      public Builder username(String username) {
         this.username = username;
         return this;
      }

      public Builder email(String email) {
         this.email = email;
         return this;
      }

      public Builder password(String password) {
         this.password = password;
         return this;
      }

      public Builder otp(String otp) {
         this.otp = otp;
         return this;
      }

      public Builder verified(boolean verified) {
         this.verified = verified;
         return this;
      }

      public Users build() {
         return new Users(username, email, password, otp, verified);
      }
   }

   // Builder method
   public static Builder builder() {
      return new Builder();
   }
}
