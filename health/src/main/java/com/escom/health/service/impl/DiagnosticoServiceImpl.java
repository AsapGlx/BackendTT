package com.escom.health.service.impl;

import com.escom.health.model.Diagnostico;
import com.escom.health.repository.DiagnosticoRepository;
import com.escom.health.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    public boolean addDiagnostico(Diagnostico diagnostico) throws IOException {
        try {
            Diagnostico diagnostico1 = new Diagnostico(
                    diagnostico.getIdDiagnostico(),
                    diagnostico.getDescripcion(),
                    diagnostico.getFechaDiagnostico(),
                    diagnostico.getMedicoResponsable(),
                    diagnostico.getResultado()

            );

            diagnosticoRepository.save(diagnostico1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Diagnostico> getDiagnostico() {
        return diagnosticoRepository.findAll();

    }

    public Diagnostico getDiagnosticoById(int id) {
        return diagnosticoRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateDiagnostico(Diagnostico diagnostico , int id) throws IOException {
        try {
            Diagnostico diagnosticoTest = diagnosticoRepository.findById(id).orElse(null);

            if (diagnosticoTest != null){

                diagnosticoTest.setIdDiagnostico(diagnostico.getIdDiagnostico());
                diagnosticoTest.setDescripcion(diagnostico.getDescripcion());
                diagnosticoTest.setFechaDiagnostico(diagnostico.getFechaDiagnostico());
                diagnosticoTest.setMedicoResponsable(diagnostico.getMedicoResponsable());
                diagnosticoTest.setResultado(diagnostico.getResultado());

                diagnosticoRepository.save(diagnosticoTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteDiagnostico(int id) {
        try {
            Diagnostico test = diagnosticoRepository.findById(id).orElse(null);
            if ( test != null) {
                diagnosticoRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}




