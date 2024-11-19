package com.escom.health.service;

import com.escom.health.model.DatoMedico;

import java.io.IOException;
import java.util.List;

public interface DatoMedicoService {

    boolean addDatoMedico(DatoMedico datoMedico) throws IOException;

    List<DatoMedico> getDatoMedico();

    boolean updateDatoMedico(DatoMedico datoMedico, int id) throws  IOException;

    boolean deleteDatoMedico(int id);
}
