package com.escom.health.service.impl;

import com.escom.health.model.Medicamento;
import com.escom.health.repository.MedicamentoRepository;
import com.escom.health.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    public boolean addMedicamento(Medicamento medicamento) throws IOException {
        try {
            Medicamento medicamento1 = new Medicamento(
                    medicamento.getIdMedicamento(),
                    medicamento.getNombre(),
                    medicamento.getDosis(),
                    medicamento.getFrecuencia(),
                    medicamento.getDuracionTratamiento(),
                    medicamento.getEfectoSecundario(),
                    medicamento.getRecomendacion()

            );

            medicamentoRepository.save(medicamento1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Medicamento> getMedicamento() {
        return medicamentoRepository.findAll();

    }

    public Medicamento getMedicamentoById(int id) {
        return medicamentoRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateMedicamento(Medicamento medicamento , int id) throws IOException {
        try {
            Medicamento medicamentoTest = medicamentoRepository.findById(id).orElse(null);

            if (medicamentoTest != null){

                medicamentoTest.setIdMedicamento(medicamento.getIdMedicamento());
                medicamentoTest.setNombre(medicamento.getNombre());
                medicamentoTest.setDosis(medicamento.getDosis());
                medicamentoTest.setFrecuencia(medicamento.getFrecuencia());
                medicamentoTest.setDuracionTratamiento(medicamento.getDuracionTratamiento());
                medicamentoTest.setEfectoSecundario(medicamento.getEfectoSecundario());
                medicamentoTest.setRecomendacion(medicamento.getRecomendacion());

                medicamentoRepository.save(medicamentoTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteMedicamento(int id) {
        try {
            Medicamento test = medicamentoRepository.findById(id).orElse(null);
            if ( test != null) {
                medicamentoRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}




