package com.tutorlink.student_domain.auth.controller;

import com.tutorlink.student_domain.auth.service.UserAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authorization")
public class AuthorizationController {

    private final UserAuthorizationService authorizationService;
}
