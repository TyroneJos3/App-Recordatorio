package com.mi_proyecto.App.domain.recordatorio;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import com.mi_proyecto.App.domain.DtosRecordatorioCrea;
import com.mi_proyecto.App.domain.usuario.Usuario;
import java.util.List;

@Service
public class RecordatorioService {
    
    @Autowired
    private RecordatorioRepository recordatorioRepository;

    @Transactional
    public Recordatorio crearRecordatorio(DtosRecordatorioCrea datos, Usuario usuario) {
        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setNombre_Medicacmento(datos.getNombre_Medicacmento());
        recordatorio.setDosis(datos.getDosis());
        recordatorio.setFechaHoraRecordatorio(datos.getFechaHoraRecordatorio());
        recordatorio.setUsuario(usuario);
        
        return recordatorioRepository.save(recordatorio);
    }

    public List<Recordatorio> obtenerRecordatoriosPorUsuario(Long usuarioId) {
        return recordatorioRepository.findByUsuarioId(usuarioId);
    }

    public Recordatorio obtenerRecordatorioPorIdYUsuario(Long id, Long usuarioId) {
        return recordatorioRepository.findById(id)
                .filter(r -> r.getUsuario().getId().equals(usuarioId))
                .orElse(null);
    }

    @Transactional
    public Recordatorio actualizarRecordatorio(Long id, DtosRecordatorioCrea datos, Long usuarioId) {
        Recordatorio recordatorio = obtenerRecordatorioPorIdYUsuario(id, usuarioId);
        if (recordatorio == null) {
            return null;
        }
        
        recordatorio.setNombre_Medicacmento(datos.getNombre_Medicacmento());
        recordatorio.setDosis(datos.getDosis());
        recordatorio.setFechaHoraRecordatorio(datos.getFechaHoraRecordatorio());
        
        return recordatorioRepository.save(recordatorio);
    }

    @Transactional
    public boolean eliminarRecordatorio(Long id, Long usuarioId) {
        Recordatorio recordatorio = obtenerRecordatorioPorIdYUsuario(id, usuarioId);
        if (recordatorio == null) {
            return false;
        }
        
        recordatorioRepository.deleteById(id);
        return true;
    }
}
