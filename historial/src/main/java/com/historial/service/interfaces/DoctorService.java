package com.historial.service.interfaces;


import com.historial.dto.DoctorRequest;

import com.historial.dto.DoctorResponse;
import com.historial.http.response.CitasFechasDoctor;


import java.util.List;

public interface DoctorService {

    List<DoctorResponse> getDoctores();

    DoctorResponse saveDoctor(DoctorRequest doctor);

    DoctorResponse findById(Integer id);

    void delete(Integer id);

    CitasFechasDoctor citasFechasDoctor(Integer ci);
}
