package com.escom.health.service;

import com.escom.health.model.Informe;

import java.io.IOException;
import java.util.List;

public interface InformeService {

    boolean addInforme(Informe informe) throws IOException;

    List<Informe> getInforme();

    boolean updateInforme(Informe informe, int id) throws  IOException;

    boolean deleteInforme(int id);
}
