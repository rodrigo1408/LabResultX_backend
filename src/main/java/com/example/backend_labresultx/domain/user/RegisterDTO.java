package com.example.backend_labresultx.domain.user;

import com.example.backend_labresultx.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
