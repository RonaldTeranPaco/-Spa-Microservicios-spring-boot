package com.historial.http.response;

import com.historial.dto.CitaResponse;

import java.util.List;

public class CitasFechasDoctor {
    List<CitaResponse> citas;

    public CitasFechasDoctor() {
    }

    public List<CitaResponse> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaResponse> citas) {
        this.citas = citas;
    }
}
