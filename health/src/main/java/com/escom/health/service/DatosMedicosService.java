package com.escom.health.service;

import com.escom.health.model.DatosMedicos;

import java.io.IOException;
import java.util.List;

public interface DatosMedicosService {

    boolean addDatosMedicos(DatosMedicos datosMedicos) throws IOException;

    List<DatosMedicos> getDatosMedicos();

    boolean updateDatosMedicos(DatosMedicos datosMedicos, int id) throws  IOException;

    boolean deleteDatosMedicos(int id);
}
