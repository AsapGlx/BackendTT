package com.escom.health.controller;

import com.escom.health.model.Informe;
import com.escom.health.model.ResponseData;

public interface InformeController {

    ResponseData getAllInformes();

    ResponseData getInformeById(int id);

    ResponseData createInforme(Informe informe);

    ResponseData updateInforme(Informe informe, int id);

    ResponseData deleteInforme(int id);
}
