package com.escom.health.service;

import com.escom.health.model.Cita;

import java.io.IOException;
import java.util.List;

public interface CitaService {

    boolean addCita(Cita cita) throws IOException;

    List<Cita> getCita();

    boolean updateCita(Cita cita, int id) throws  IOException;

    boolean deleteCita(int id);
}
