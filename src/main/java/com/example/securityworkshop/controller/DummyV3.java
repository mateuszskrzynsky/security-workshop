package com.example.securityworkshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dummyV3")
public class DummyV3 {

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @PostMapping("/post")
    public ResponseEntity<String> create() {
        return ResponseEntity.ok("Created by admin or guest");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @GetMapping("/get")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Get by admin or guest");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @PutMapping("/put")
    public ResponseEntity<String> update() {
        return ResponseEntity.ok("Updated by admin or guest");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'GUEST')")
    @PatchMapping("/patch")
    public ResponseEntity<String> patch() {
        return ResponseEntity.ok("Patched by admin or guest");
    }
}
