package com.escom.health.controller;

import com.escom.health.model.Diagnostico;
import com.escom.health.model.ResponseData;

public interface DiagnosticoController {

    ResponseData getAllDiagnosticos();

    ResponseData getDiagnosticoById(int id);

    ResponseData createDiagnostico(Diagnostico diagnostico);

    ResponseData updateDiagnostico(Diagnostico diagnostico, int id);

    ResponseData deleteDiagnostico(int id);
}
