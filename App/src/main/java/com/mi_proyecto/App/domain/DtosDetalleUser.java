package com.mi_proyecto.App.domain;

import com.mi_proyecto.App.domain.usuario.Usuario;

public record DtosDetalleUser(Long id, String login) {
	public DtosDetalleUser(Usuario usuario) {
		this(usuario.getId(), usuario.getUsername());
	}
}
