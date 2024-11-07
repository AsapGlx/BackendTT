package com.escom.health.service.impl;

import com.escom.health.model.Recomendacion;
import com.escom.health.repository.RecomendacionRepository;
import com.escom.health.service.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RecomendacionServiceImpl implements RecomendacionService {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    @Override
    public boolean addRecomendacion(Recomendacion recomendacion) throws IOException {
        try {
            Recomendacion recomendacion1 = new Recomendacion(
                    recomendacion.getIdRecomendacion(),
                    recomendacion.getFechaRecomendacion(),
                    recomendacion.getMedicoResponsable(),
                    recomendacion.getEstadoCumplimiento()


            );

            recomendacionRepository.save(recomendacion1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Recomendacion> getRecomendacion() {
        return recomendacionRepository.findAll();

    }

    public Recomendacion getRecomendacionById(int id) {
        return recomendacionRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateRecomendacion(Recomendacion recomendacion , int id) throws IOException {
        try {
            Recomendacion recomendacionTest = recomendacionRepository.findById(id).orElse(null);

            if (recomendacionTest != null){

                recomendacionTest.setIdRecomendacion(recomendacion.getIdRecomendacion());
                recomendacionTest.setFechaRecomendacion(recomendacion.getFechaRecomendacion());
                recomendacionTest.setMedicoResponsable(recomendacion.getMedicoResponsable());
                recomendacionTest.setEstadoCumplimiento(recomendacion.getEstadoCumplimiento());

                recomendacionRepository.save(recomendacionTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteRecomendacion(int id) {
        try {
            Recomendacion test = recomendacionRepository.findById(id).orElse(null);
            if ( test != null) {
                recomendacionRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}



