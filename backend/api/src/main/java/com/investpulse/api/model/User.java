package com.investpulse.api.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.investpulse.api.dto.UserRequestDTO;
import com.investpulse.api.dto.UserResponseDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Setter(AccessLevel.NONE)
    private String email;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    private String investmentAdvisor;

    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    public User(UserRequestDTO user) {
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.fullName = user.getFullName();
        this.phoneNumber = user.getPhoneNumber();
        this.password = user.getPassword();
        this.investmentAdvisor = user.getInvestmentAdvisor();
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public UserResponseDTO toUserResponseDTO() {
        return new UserResponseDTO(this);
    }
}
