package com.example.tutorlink.model.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserProfileReq {
    private String fullName;
    private String email;
    private String role;
}

