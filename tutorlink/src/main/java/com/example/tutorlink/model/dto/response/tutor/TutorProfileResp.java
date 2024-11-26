package com.example.tutorlink.model.dto.response.tutor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TutorProfileResp {
    private Long id;
    private String fullName;
    private List<String> subjects;
    private Map<String, Double> hourlyRates;
}

