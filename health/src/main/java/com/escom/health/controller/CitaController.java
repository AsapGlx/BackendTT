package com.escom.health.controller;

import com.escom.health.model.Cita;
import com.escom.health.model.ResponseData;

public interface CitaController {

    ResponseData getAllCitas();

    ResponseData getCitaById(int id);

    ResponseData createCita(Cita cita);

    ResponseData updateCita(Cita cita, int id);

    ResponseData deleteCita(int id);

}
