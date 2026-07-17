package com.historial.client;


import com.historial.dto.CitaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "citas", url = "http://localhost:8090/api/citas")
public interface CitasClient {
    @GetMapping("/buscarDoctorCi/{ci}")
    List<CitaResponse> buscarCitaFechaDoctor(@PathVariable Integer ci);
}
