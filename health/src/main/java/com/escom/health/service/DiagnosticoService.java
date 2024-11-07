package com.escom.health.service;

import com.escom.health.model.Diagnostico;

import java.io.IOException;
import java.util.List;

public interface DiagnosticoService {

    boolean addDiagnostico(Diagnostico diagnostico) throws IOException;

    List<Diagnostico> getDiagnostico();

    boolean updateDiagnostico(Diagnostico diagnostico, int id) throws  IOException;

    boolean deleteDiagnostico(int id);
}
