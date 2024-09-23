package com.investpulse.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investpulse.api.dto.UserRequestDTO;
import com.investpulse.api.dto.UserResponseDTO;
import com.investpulse.api.dto.UserPatchUpdateDTO;
import com.investpulse.api.dto.UserPutUpdateDTO;
import com.investpulse.api.service.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

        private UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @GetMapping
        private ResponseEntity<List<UserResponseDTO>> getAllUsers() {
                return ResponseEntity.ok(userService.getAllUsers());
        }

        @GetMapping("/{email}")
        private ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable @Email String email) {
                return ResponseEntity.ok(userService.getUserByEmail(email));
        }

        @PostMapping
        private ResponseEntity<UserResponseDTO> postCreateUser(@RequestBody @Valid UserRequestDTO user) {
                return ResponseEntity.status(HttpStatus.CREATED).body(userService.postCreateUser(user));
        }

        @PutMapping("/{email}")
        private ResponseEntity<UserResponseDTO> putUpdateUser(@PathVariable @Email String email,
                        @RequestBody @Valid UserPutUpdateDTO user) {
                return ResponseEntity.ok(userService.putUpdateUser(email, user));
        }

        @PatchMapping("/{email}")
        private ResponseEntity<UserResponseDTO> patchUpdateUser(@PathVariable @Email String email,
                        @RequestBody @Valid UserPatchUpdateDTO user) {
                return ResponseEntity.ok(userService.patchUpdateUser(email, user));
        }

        @DeleteMapping("/{email}")
        private ResponseEntity<Object> deleteUserByEmail(@PathVariable @Email String email) {
                userService.deleteUserByEmail(email);
                return ResponseEntity.noContent().build();
        }

}
