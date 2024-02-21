package com.example.securityworkshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dummyV2")
public class DummyV2 {

    @PostMapping("/post")
    public ResponseEntity<String> create() {
        return ResponseEntity.ok("Created by admin");
    }

    @GetMapping("/get")
    public ResponseEntity<String> read() {
        return ResponseEntity.ok("Read by admin");
    }

    @PutMapping("/put")
    public ResponseEntity<String> update() {
        return ResponseEntity.ok("Updated by admin");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("Deleted by admin");
    }

}
