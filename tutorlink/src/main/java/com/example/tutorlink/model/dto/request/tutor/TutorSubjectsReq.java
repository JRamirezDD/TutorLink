package com.example.tutorlink.model.dto.request.tutor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorSubjectsReq {
    private List<String> preMadeSubjects; // List of pre-defined subjects
    private List<String> customSubjects;  // List of custom subjects (max 3)
}

