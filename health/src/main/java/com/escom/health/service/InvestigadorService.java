package com.escom.health.service;

import com.escom.health.model.Investigador;

import java.io.IOException;
import java.util.List;

public interface InvestigadorService {

    boolean addInvestigador(Investigador investigador) throws IOException;

    List<Investigador> getInvestigador();

    boolean updateInvestigador(Investigador investigador, int id) throws  IOException;

    boolean deleteInvestigador(int id);
}
