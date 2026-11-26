package com.nutrivida.backend.controller;

import com.nutrivida.backend.dto.*;
import com.nutrivida.backend.model.Rol;
import com.nutrivida.backend.model.Usuario;
import com.nutrivida.backend.repository.UsuarioRepository;
import com.nutrivida.backend.security.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroRequest request) {
        if (usuarioRepository.existsByCorreoIgnoreCase(request.correo()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", "El correo ya está registrado"));
        Usuario usuario = usuarioRepository.save(Usuario.builder().nombre(request.nombre().trim())
            .correo(request.correo().trim().toLowerCase()).contrasenia(passwordEncoder.encode(request.contrasenia())).rol(Rol.USER).build());
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository.findByCorreoIgnoreCase(request.correo()).orElse(null);
        if (usuario == null || !passwordEncoder.matches(request.contrasenia(), usuario.getContrasenia()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Correo o contraseña incorrectos"));
        return ResponseEntity.ok(respuesta(usuario));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> renovar(@RequestHeader(value = "Authorization", required = false) String header) {
        if (header == null || !header.startsWith("Bearer ")) return ResponseEntity.status(401).body(Map.of("message", "Token requerido"));
        String correo = jwtService.validarYObtenerCorreo(header.substring(7));
        if (correo == null) return ResponseEntity.status(401).body(Map.of("message", "Token inválido o vencido"));
        Usuario usuario = usuarioRepository.findByCorreoIgnoreCase(correo).orElse(null);
        if (usuario == null) return ResponseEntity.status(401).body(Map.of("message", "Usuario no encontrado"));
        return ResponseEntity.ok(respuesta(usuario));
    }

    private AuthResponse respuesta(Usuario usuario) {
        return new AuthResponse(jwtService.generar(usuario.getCorreo()), usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getRol().name());
    }
}
