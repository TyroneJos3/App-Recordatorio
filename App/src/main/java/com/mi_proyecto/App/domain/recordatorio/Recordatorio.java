package com.mi_proyecto.App.domain.recordatorio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.mi_proyecto.App.domain.usuario.Usuario;

//model

@Entity
@Table(name = "recordatorios")
public class Recordatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_Medicacmento;
    private String dosis;
    private LocalDateTime fechaHoraRecordatorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    
}
