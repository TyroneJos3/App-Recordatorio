package com.mi_proyecto.App.domain;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DtosRecordatorioCrea {
    @NotBlank
    private String nombre_Medicacmento;
    @NotBlank
    private String dosis;
    @NotNull
    private LocalDateTime fechaHoraRecordatorio;

    public DtosRecordatorioCrea(String nombre_Medicamento, String dosis, LocalDateTime fechaHoraRecordatorio){
        this.nombre_Medicacmento = nombre_Medicamento;
        this.dosis = dosis;
        this.fechaHoraRecordatorio = fechaHoraRecordatorio;
    }
    
}
