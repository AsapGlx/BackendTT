package com.escom.health.controller;

import com.escom.health.model.Paciente;
import com.escom.health.model.ResponseData;
import org.bson.types.ObjectId;

public interface PacienteController {

    ResponseData getAllPacientes();

    ResponseData getPacienteById(int id);

    ResponseData createPaciente(Paciente paciente);

    ResponseData updatePaciente(Paciente paciente, int id);

    ResponseData deletePaciente(int id);

}
