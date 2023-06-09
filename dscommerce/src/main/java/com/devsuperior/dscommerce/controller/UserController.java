package com.devsuperior.dscommerce.controller;

import com.devsuperior.dscommerce.dto.UserDTO;
import com.devsuperior.dscommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_OPERATOR')")
    @GetMapping("me")
    public ResponseEntity<UserDTO> findMyUser() {
        return ResponseEntity.ok(service.getMyUser());
    }
}
