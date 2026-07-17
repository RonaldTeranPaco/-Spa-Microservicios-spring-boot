package com.service.citas.client;


import com.service.citas.dto.PacienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "historial", url = "http://localhost:8092/api/pacientes")
public interface HistorialClient {
    @GetMapping("/buscar-ci/{ci}")
    PacienteResponse finPacienteByCi(@PathVariable Integer ci);
}
