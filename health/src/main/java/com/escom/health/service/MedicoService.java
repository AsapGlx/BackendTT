package com.escom.health.service;

import com.escom.health.model.Medico;

import java.io.IOException;
import java.util.List;

public interface MedicoService {

    boolean addMedico(Medico medico) throws IOException;

    List<Medico> getMedico();

    boolean updateMedico(Medico medico, int id) throws  IOException;

    boolean deleteMedico(int id);
}
