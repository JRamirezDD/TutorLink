package com.example.tutorlink.model.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResp {
    private Long id;
    private String fullName;
    private String email;
    private String role;
}

