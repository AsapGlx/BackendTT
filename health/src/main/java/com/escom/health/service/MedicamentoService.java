package com.escom.health.service;

import com.escom.health.model.Medicamento;

import java.io.IOException;
import java.util.List;

public interface MedicamentoService {

    boolean addMedicamento(Medicamento medicamento) throws IOException;

    List<Medicamento> getMedicamento();

    boolean updateMedicamento(Medicamento medicamento, int id) throws  IOException;

    boolean deleteMedicamento(int id);
}
