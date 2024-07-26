package com.investpulse.api.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Setter(AccessLevel.NONE)
    private String email;

    @Column(nullable = false)
    private int cpf;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private int phoneNumber;

    @Column(nullable = false)
    private String password;

    private String investmentAdvisor;

    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;
}
