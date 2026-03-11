package com.example.stockexchange.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data // for both getter and setter
public class User {

    @Builder.Default
    private String userId = UUID.randomUUID().toString();

    @NotNull(message = "Username is required")
    private String userName;

    @Email(message = "Invalid email address")
    private String email;

    private String phoneNumber;
}
