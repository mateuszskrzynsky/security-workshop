package com.example.securityworkshop.controller;

import org.springframework.http.ResponseEntity;
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

    @GetMapping("/forAdmin")
    public ResponseEntity<String>helloForAdmin(){
        return ResponseEntity.ok("Hello Admin!");
    }

    @GetMapping("/forUser")
    public ResponseEntity<String>helloForUser(){
        return ResponseEntity.ok("Hello User!");
    }

    @GetMapping("/forAll")
    public ResponseEntity<String>helloAll(){
        return ResponseEntity.ok("Hello everyone!");
    }

    /*Admin
    * TWF0ZXVzejpwYXNz

    * User
    * TW9uaWthOnBhc3M=
    * */
}
