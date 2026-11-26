package com.nutrivida.backend.config;

import com.nutrivida.backend.model.Rol;
import com.nutrivida.backend.model.Usuario;
import com.nutrivida.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AdminInitializer {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner crearAdministrador() {
        return args -> {
            if (!usuarioRepository.existsByCorreoIgnoreCase("admin@nutrivida.cl")) {
                usuarioRepository.save(Usuario.builder().nombre("Administrador").correo("admin@nutrivida.cl")
                    .contrasenia(passwordEncoder.encode("admin123")).rol(Rol.ADMIN).build());
            }
        };
    }
}
