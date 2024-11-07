package com.escom.health.controller;

import com.escom.health.model.DatosMedicos;
import com.escom.health.model.ResponseData;

public interface DatosMedicosController {

    ResponseData getAllDatosMedicoss();

    ResponseData getDatosMedicosById(int id);

    ResponseData createDatosMedicos(DatosMedicos datosMedicos);

    ResponseData updateDatosMedicos(DatosMedicos datosMedicos, int id);

    ResponseData deleteDatosMedicos(int id);
}
