package com.example.tutorlink.model.dto.request.tutor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTutorProfileReq {
    private String fullName;
    private List<String> subjects; // List of subjects the tutor teaches
    private Map<String, Double> hourlyRates; // Subject-specific hourly rates
}


