package com.mi_proyecto.App.domain;

public class TokenService {
    public String generarToken(Object usuario) {
        return "token-de-prueba-" + usuario.hashCode();
    }
}
