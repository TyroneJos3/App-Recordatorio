package com.mi_proyecto.App.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.mi_proyecto.App.domain.DtosAutenticacion;
import com.mi_proyecto.App.domain.DtosTokenJWT;
import com.mi_proyecto.App.domain.TokenService;
import com.mi_proyecto.App.domain.usuario.Usuario;


@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSeccion(@RequestBody @Valid DtosAutenticacion datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                datos.login(), datos.contrasena()
        );
        var autenticacion = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok(new DtosTokenJWT(tokenJWT));
    }
}