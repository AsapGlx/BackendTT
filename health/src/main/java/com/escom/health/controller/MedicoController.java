package com.escom.health.controller;

import com.escom.health.model.Medico;
import com.escom.health.model.ResponseData;

public interface MedicoController {

    ResponseData getAllMedicos();

    ResponseData getMedicoById(int id);

    ResponseData createMedico(Medico medico);

    ResponseData updateMedico(Medico medico, int id);

    ResponseData deleteMedico(int id);
}
