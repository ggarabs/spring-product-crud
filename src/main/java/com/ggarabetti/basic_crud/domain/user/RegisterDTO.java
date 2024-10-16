package com.ggarabetti.basic_crud.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
