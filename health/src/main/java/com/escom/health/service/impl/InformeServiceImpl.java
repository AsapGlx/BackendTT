package com.escom.health.service.impl;

import com.escom.health.model.Informe;
import com.escom.health.repository.InformeRepository;
import com.escom.health.service.InformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class InformeServiceImpl implements InformeService {

    @Autowired
    private InformeRepository informeRepository;

    @Override
    public boolean addInforme(Informe informe) throws IOException {
        try {
            Informe informe1 = new Informe(
                    informe.getIdInforme(),
                    informe.getFechaGeneracion(),
                    informe.getTitulo(),
                    informe.getDescripcion(),
                    informe.getInvestigadorResponsable()

            );

            informeRepository.save(informe1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Informe> getInforme() {
        return informeRepository.findAll();

    }

    public Informe getInformeById(int id) {
        return informeRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateInforme(Informe informe , int id) throws IOException {
        try {
            Informe informeTest = informeRepository.findById(id).orElse(null);

            if (informeTest != null){

                informeTest.setIdInforme(informe.getIdInforme());
                informeTest.setFechaGeneracion(informe.getFechaGeneracion());
                informeTest.setTitulo(informe.getTitulo());
                informeTest.setDescripcion(informe.getDescripcion());
                informeTest.setInvestigadorResponsable(informe.getInvestigadorResponsable());


                informeRepository.save(informeTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteInforme(int id) {
        try {
            Informe test = informeRepository.findById(id).orElse(null);
            if ( test != null) {
                informeRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}




