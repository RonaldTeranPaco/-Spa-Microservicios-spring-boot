package com.service.citas.http.response;


import com.service.citas.dto.CitaResponse;
import com.service.citas.dto.PacienteResponse;

import java.time.LocalDateTime;
import java.util.List;

public class PacienteByCitaResponse {
    private List<CitaResponse> citas;
    private PacienteResponse paciente;

    public PacienteByCitaResponse() {
    }

    public List<CitaResponse> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaResponse> citas) {
        this.citas = citas;
    }

    public PacienteResponse getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteResponse paciente) {
        this.paciente = paciente;
    }

}
