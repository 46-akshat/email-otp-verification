package com.email.emailverification.response;

public class RegisterResponse {
    private String username;
    private String email;

    public RegisterResponse() {}

    public RegisterResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ✅ Manual Builder
    public static class Builder {
        private String username;
        private String email;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterResponse build() {
            return new RegisterResponse(username, email);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
