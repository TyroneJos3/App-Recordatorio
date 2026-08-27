package com.mi_proyecto.App.domain.recordatorio;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class RecordatorioService {
    private final RecordatorioRepository recordatorioRepository;

    public RecordatorioService(RecordatorioRepository recordatorioRepository){
        this.recordatorioRepository = recordatorioRepository;
    }

    @Transactional
    public Recordatorio crearRecordatorio(Recordatorio recordatorio){
        return recordatorioRepository.save(recordatorio);
    }
    
}
