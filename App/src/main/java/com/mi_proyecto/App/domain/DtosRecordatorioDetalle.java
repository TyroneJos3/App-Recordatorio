package com.mi_proyecto.App.domain;

import java.time.LocalDateTime;

import com.mi_proyecto.App.domain.recordatorio.Recordatorio;
import lombok.Getter;

@Getter
public class DtosRecordatorioDetalle {

    private Long id;
    private String nombre_Medicamento;
    private String dosis;
    private LocalDateTime fechaHoraRecordatorio;
    private Long usuarioId;


    public DtosRecordatorioDetalle(Recordatorio recordatorio) {
        this.id = recordatorio.getId();
        this.nombre_Medicamento = recordatorio.getNombre_Medicacmento();
        this.dosis = recordatorio.getDosis();
        this.fechaHoraRecordatorio = recordatorio.getFechaHoraRecordatorio();
        this.usuarioId = recordatorio.getUsuario().getId();
    }
    
}
