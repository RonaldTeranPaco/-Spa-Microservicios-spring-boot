package com.historial.service;

import com.historial.client.CitasClient;
import com.historial.dto.CitaResponse;
import com.historial.dto.DoctorRequest;

import com.historial.dto.DoctorResponse;
import com.historial.http.response.CitasFechasDoctor;
import com.historial.service.interfaces.DoctorService;
import com.historial.service.mapper.MapperDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.historial.persistence.repository.DoctorRepository;
import com.historial.persistence.entidades.DoctorEntidad;


@Service
public class DoctorServiceImp implements DoctorService {

    @Autowired
    private DoctorRepository repository;
    @Autowired
    private MapperDoctor mapperDoctor;
    @Autowired
    private CitasClient citasClient;

    @Override
    public List<DoctorResponse> getDoctores() {
        List<DoctorResponse> doctorResponse = mapperDoctor.convertirListaDTO(repository.findAll());
        return doctorResponse;
    }

    @Override
    public DoctorResponse saveDoctor(DoctorRequest doctor) {
        DoctorEntidad doctorEntidad = mapperDoctor.convertirDAO(doctor);
        repository.save(doctorEntidad);
        DoctorResponse doctorResponse = mapperDoctor.convertirDTO(doctorEntidad);
        return doctorResponse;
    }

    @Override
    public DoctorResponse findById(Integer id) {
        DoctorResponse responseDTO = mapperDoctor.convertirDTO(repository.findById(id).orElse(null));
        return responseDTO;
    }


    public DoctorEntidad findByIdEntidad(Integer id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CitasFechasDoctor citasFechasDoctor(Integer ci) {
        List<CitaResponse> citas = citasClient.buscarCitaFechaDoctor(ci);
        CitasFechasDoctor res = new CitasFechasDoctor();
        res.setCitas(citas);
        return res;
    }
}