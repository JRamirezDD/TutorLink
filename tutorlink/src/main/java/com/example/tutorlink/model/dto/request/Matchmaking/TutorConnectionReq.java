package com.example.tutorlink.model.dto.request.Matchmaking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorConnectionReq {
    private String tutorToken;
    private Long tutorId;
}
