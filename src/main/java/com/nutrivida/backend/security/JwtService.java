
package com.nutrivida.backend.security;

import tools.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Map;

@Service
public class JwtService {
    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.expiration}")
    private long expiration;

    public String generar(String correo) {
        try {
            long ahora = Instant.now().getEpochSecond();
            String header = codificar(mapper.writeValueAsBytes(Map.of("alg", "HS256", "typ", "JWT")));
            String payload = codificar(mapper.writeValueAsBytes(Map.of("sub", correo, "iat", ahora, "exp", ahora + expiration / 1000)));
            String contenido = header + "." + payload;
            return contenido + "." + firma(contenido);
        } catch (Exception e) {
            throw new IllegalStateException("No se pudo generar el token", e);
        }
    }

    public String validarYObtenerCorreo(String token) {
        try {
            String[] partes = token.split("\\.");
            if (partes.length != 3) return null;

            String contenido = partes[0] + "." + partes[1];

            if (!firma(contenido).equals(partes[2])) return null;

            var claims = mapper.readTree(Base64.getUrlDecoder().decode(partes[1]));

            if (claims.path("exp").asLong() <= Instant.now().getEpochSecond()) return null;

            return claims.path("sub").asString(null);
        } catch (Exception e) {
            return null;
        }
    }

    private String firma(String contenido) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(Base64.getDecoder().decode(secret), "HmacSHA256"));
        return Base64.getUrlEncoder().withoutPadding().encodeToString(mac.doFinal(contenido.getBytes(StandardCharsets.UTF_8)));
    }

    private String codificar(byte[] datos) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(datos);
    }
}
