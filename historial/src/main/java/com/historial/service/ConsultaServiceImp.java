package com.historial.service;

import com.historial.dto.ConsultaRequest;
import com.historial.dto.ConsultaResponse;
import com.historial.persistence.entidades.ConsultaMedica;
import com.historial.persistence.entidades.DoctorEntidad;
import com.historial.persistence.entidades.HistorialClinico;
import com.historial.persistence.repository.ConsultaMedicaRepository;
import com.historial.persistence.repository.DoctorRepository;
import com.historial.persistence.repository.HistorialClinicoRepository;
import com.historial.service.interfaces.ConsultaMedicaService;
import com.historial.service.mapper.MapperConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ConsultaServiceImp implements ConsultaMedicaService {

    @Autowired
    private ConsultaMedicaRepository consultaMedicaRepository;
    @Autowired
    private HistorialClinicoRepository historialClinicoRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MapperConsulta mapperConsulta;

    @Override
    public ConsultaResponse crear(ConsultaRequest request) {
        HistorialClinico historial = historialClinicoRepository.findById(request.getIdHistorial())
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));

        DoctorEntidad doctor = doctorRepository.findById(request.getIdDoctor())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        ConsultaMedica c = new ConsultaMedica();
        c.setHistorial(historial);
        c.setDoctor(doctor);
        c.setFechaHora(LocalDateTime.now());
        c.setDiagnostico(request.getDiagnostico());
        c.setTratamiento(request.getTratamiento());
        c.setNotas(request.getNotas());
        c.setFactoresExternos(request.getFactoresExternos());
        c.setEstadoGeneral(request.getEstadoGeneral());
        c.setDuracionLesionCutanea(request.getDuracionLesionCutanea());
        c.setTipoLesion(request.getTipoLesion());
        c.setColoracionPielyLesion(request.getColoracionPielLesion());
        c.setPalpacionLesion(request.getPalpacionLesion());
        c.setDisposicionLesion(request.getDisposicionLesion());
        c.setDistribucionLesion(request.getDistribucionLesion());

        c = consultaMedicaRepository.save(c);

        return mapperConsulta.response(c);
    }

    @Override
    public List<ConsultaResponse> listarPorHistorial(UUID idHistorial) {
        List<ConsultaMedica> consultaMedicas = consultaMedicaRepository.findByhistorial_IdHistorial(idHistorial);

        System.out.println(consultaMedicas.get(0).getDoctor().getNombre());
        return mapperConsulta.response(consultaMedicas);
    }

    @Override
    public ConsultaResponse obtener(Integer idConsulta) {
        return null;
    }

    @Override
    public void eliminar(Integer idConsulta) {

    }
}
