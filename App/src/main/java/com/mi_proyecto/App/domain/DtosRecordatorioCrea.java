package com.mi_proyecto.App.domain;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DtosRecordatorioCrea {
    @NotBlank
    private String nombre_Medicacmento;
    @NotBlank
    private String dosis;
    @NotNull
    private LocalDateTime fechaHoraRecordatorio;
    
}
