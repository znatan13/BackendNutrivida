package com.nutrivida.backend.dto;

public record AuthResponse(String token, Long id, String nombre, String correo, String rol) {}
