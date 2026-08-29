package com.mi_proyecto.App.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.security.core.Authentication;

import com.mi_proyecto.App.domain.DtosRecordatorioCrea;
import com.mi_proyecto.App.domain.DtosRecordatorioDetalle;
import com.mi_proyecto.App.domain.recordatorio.Recordatorio;
import com.mi_proyecto.App.domain.recordatorio.RecordatorioService;
import com.mi_proyecto.App.domain.usuario.Usuario;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/recordatorios")
public class RecordatorioController {

    @Autowired
    private RecordatorioService recordatorioService;

    @PostMapping
    @Transactional
    public ResponseEntity crearRecordatorio(
            @RequestBody @Valid DtosRecordatorioCrea datos,
            Authentication authentication,
            UriComponentsBuilder uriBuilder) {
        
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Recordatorio recordatorio = recordatorioService.crearRecordatorio(datos, usuario);
        
        var uri = uriBuilder.path("/recordatorios/{id}").buildAndExpand(recordatorio.getId()).toUri();
        return ResponseEntity.created(uri).body(new DtosRecordatorioDetalle(recordatorio));
    }

    @GetMapping
    public ResponseEntity<List<DtosRecordatorioDetalle>> listarRecordatorios(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        List<Recordatorio> recordatorios = recordatorioService.obtenerRecordatoriosPorUsuario(usuario.getId());
        List<DtosRecordatorioDetalle> dtos = recordatorios.stream()
                .map(DtosRecordatorioDetalle::new)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerRecordatorio(
            @PathVariable Long id,
            Authentication authentication) {
        
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Recordatorio recordatorio = recordatorioService.obtenerRecordatorioPorIdYUsuario(id, usuario.getId());
        
        if (recordatorio == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(new DtosRecordatorioDetalle(recordatorio));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarRecordatorio(
            @PathVariable Long id,
            @RequestBody @Valid DtosRecordatorioCrea datos,
            Authentication authentication) {
        
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Recordatorio recordatorioActualizado = recordatorioService.actualizarRecordatorio(
                id, datos, usuario.getId());
        
        if (recordatorioActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(new DtosRecordatorioDetalle(recordatorioActualizado));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRecordatorio(
            @PathVariable Long id,
            Authentication authentication) {
        
        Usuario usuario = (Usuario) authentication.getPrincipal();
        boolean eliminado = recordatorioService.eliminarRecordatorio(id, usuario.getId());
        
        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.noContent().build();
    }
}
