package com.escom.health.controller;

import com.escom.health.model.Historial;
import com.escom.health.model.ResponseData;

public interface HistorialController {

    ResponseData getAllHistorials();

    ResponseData getHistorialById(int id);

    ResponseData createHistorial(Historial historial);

    ResponseData updateHistorial(Historial historial, int id);

    ResponseData deleteHistorial(int id);
}
