package com.escom.health.controller;

import com.escom.health.model.Investigador;
import com.escom.health.model.ResponseData;

public interface InvestigadorController {

    ResponseData getAllInvestigadors();

    ResponseData getInvestigadorById(int id);

    ResponseData createInvestigador(Investigador investigador);

    ResponseData updateInvestigador(Investigador investigador, int id);

    ResponseData deleteInvestigador(int id);
}
