package com.example.tutorlink.model.dto.request.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationReq {
    private String username;
    private String password;
    private String email;
    private String fullName;
}


