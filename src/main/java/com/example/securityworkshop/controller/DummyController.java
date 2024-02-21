package com.example.securityworkshop.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DummyController {

    @GetMapping
    public ResponseEntity<String>helloWorld(){
        return ResponseEntity.ok("Hello form my api!");
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @PreAuthorize("ROLE_ADMIN")
    @Secured("ROLE_ADMIN")
    @GetMapping("/forAdmin")
    public ResponseEntity<String>helloForAdmin(){
        return ResponseEntity.ok("Hello Admin!");
    }
    @RolesAllowed("USER")
    @GetMapping("/forUser")
    public ResponseEntity<String>helloForUser(){
        return ResponseEntity.ok("Hello User!");
    }

    @GetMapping("/forAll")
    public ResponseEntity<String>helloAll(){
        return ResponseEntity.ok("Hello everyone!");
    }

}
