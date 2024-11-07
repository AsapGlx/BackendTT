package com.escom.health.service;

import com.escom.health.model.Paciente;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PacienteService {
    boolean addPaciente(Paciente paciente) throws IOException;

    List<Paciente>getPaciente();

    boolean updatePaciente(Paciente paciente, int id) throws  IOException;

    boolean deletePaciente(int id);
}
