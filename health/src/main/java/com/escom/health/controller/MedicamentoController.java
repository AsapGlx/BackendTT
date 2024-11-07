package com.escom.health.controller;

import com.escom.health.model.Medicamento;
import com.escom.health.model.ResponseData;

public interface MedicamentoController {

    ResponseData getAllMedicamentos();

    ResponseData getMedicamentoById(int id);

    ResponseData createMedicamento(Medicamento medicamento);

    ResponseData updateMedicamento(Medicamento medicamento, int id);

    ResponseData deleteMedicamento(int id);
}
