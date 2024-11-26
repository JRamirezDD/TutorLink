package com.example.tutorlink.model.dto.request.Matchmaking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchRequestReq {
    private String studentToken;
    private Long tutorId;
}

