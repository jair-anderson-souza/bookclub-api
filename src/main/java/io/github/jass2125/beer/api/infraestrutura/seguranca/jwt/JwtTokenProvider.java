//package io.github.jass2125.beer.api.infraestrutura.seguranca.jwt;
//
//import io.github.jass2125.beer.api.infraestrutura.seguranca.usuario.MyUserDetails;
//import io.github.jass2125.beer.api.usuario.Usuario;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import java.util.Base64;
//import java.util.Date;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
// * Created on 5 de jun de 2018
// * @project bids-api
// *
// * Classe que provê e valida e resolve tokens
// *
// */
//@Component
//public class JwtTokenProvider {
//
//    private final String CLAIM_TENANT = "tenant";
//    private final String CLAIM_EMAIL = "email";
//    private final String CLAIM_NIVEL = "nivel";
//    private final String CLAIM_ID = "id";
//
//    private String secretKey = "$2a$10$k9ZZDdZHO/ufWY.JjXEr3OI9b590m3UqGaQbXHDZ.Kb5On5Y4iwxC";
//
//    private final long validadeEmMilisegundos = 360000099; // 1h
//
//    @Autowired
//    private MyUserDetails myUserDetails;
//
//    public JwtTokenProvider() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//    public String createToken(Usuario usuario) {
//
//        Claims claims = Jwts.claims().setSubject(usuario.getNome());
//        claims.put(CLAIM_EMAIL, usuario.getEmail());
//        claims.put(CLAIM_ID, usuario.getId());
//
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + validadeEmMilisegundos);
//
//        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity).signWith(SignatureAlgorithm.HS256, secretKey).compact();
//    }
//
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = myUserDetails.loadUserByUsername(getEmail(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    public String getUsername(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public String getEmail(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get(CLAIM_EMAIL, String.class);
//    }
//
//    public String getNivel(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get(CLAIM_NIVEL, String.class);
//    }
//
//    public String getTenantFromToken(String token) {
//        try {
//            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get(CLAIM_TENANT,
//                    String.class);
//        } catch (Exception e) {
//            System.out.println("Error retrieving tenant from token.");
//            return "";
//        }
//    }
//
//    public String resolveToken(HttpServletRequest req) {
//        String bearerToken = req.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7, bearerToken.length());
//        }
//        return null;
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            throw new RuntimeException("Expired or invalid JWT token");
//        }
//    }
//}
