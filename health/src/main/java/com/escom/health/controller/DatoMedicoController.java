package com.escom.health.controller;

import com.escom.health.model.DatoMedico;
import com.escom.health.model.ResponseData;

public interface DatoMedicoController {

    ResponseData getAllDatoMedico();

    ResponseData getDatoMedicoById(int id);

    ResponseData createDatoMedico(DatoMedico datoMedico);

    ResponseData updateDatoMedico(DatoMedico datoMedico, int id);

    ResponseData deleteDatoMedico(int id);
}
