package com.mi_proyecto.App.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mi_proyecto.App.domain.usuario.UserRepository;
import com.mi_proyecto.App.domain.DtosRegistroUser;
import com.mi_proyecto.App.domain.DtosDetalleUser;
import com.mi_proyecto.App.domain.usuario.Usuario;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DtosRegistroUser datos, UriComponentsBuilder uriBuilder ) {
        var user = new Usuario(null, datos.login(), datos.contrasena());
        userRepository.save(user);
        
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DtosDetalleUser(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}


