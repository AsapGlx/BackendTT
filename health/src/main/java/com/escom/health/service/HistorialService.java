package com.escom.health.service;

import com.escom.health.model.Historial;

import java.io.IOException;
import java.util.List;

public interface HistorialService {

    boolean addHistorial(Historial historial) throws IOException;

    List<Historial> getHistorial();

    boolean updateHistorial(Historial historial, int id) throws  IOException;

    boolean deleteHistorial(int id);
}
