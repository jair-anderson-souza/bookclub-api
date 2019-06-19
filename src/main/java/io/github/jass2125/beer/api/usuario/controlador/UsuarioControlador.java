//package io.github.jass2125.beer.api.usuario.controlador;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import io.github.jass2125.beer.api.infraestrutura.seguranca.usuario.CredenciaisConta;
//import io.github.jass2125.beer.api.usuario.servico.UsuarioService;
//
//@RestController
//@RequestMapping("/usuario")
//public class UsuarioControlador {
//
//    @Autowired
//    private UsuarioService usuarioServico;
//
////    @PostMapping("login")
////    public ResponseEntity login(@RequestBody final CredenciaisConta credenciaisConta) {
////        try {
////            final String token = usuarioServico.login(credenciaisConta.getEmail(), credenciaisConta.getSenha());
////
////            final HttpHeaders headers = new HttpHeaders();
////            headers.add("Authorization", "Bearer " + token);
////
////            return ResponseEntity.ok().headers(headers).build();
////        } catch (AuthenticationException ex) {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
////        }
////    }
//    @PostMapping("login")
//    public ResponseEntity login(@RequestBody final CredenciaisConta credenciaisConta) {
//        try {
//            final String token = usuarioServico.login(credenciaisConta.getEmail(), credenciaisConta.getSenha());
//
//            final HttpHeaders headers = new HttpHeaders();
//            headers.add("Authorization", "Bearer " + token);
//
//            return ResponseEntity.ok().headers(headers).build();
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
//}
