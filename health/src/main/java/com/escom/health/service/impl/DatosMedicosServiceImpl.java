package com.escom.health.service.impl;

import com.escom.health.model.DatosMedicos;
import com.escom.health.repository.DatosMedicosRepository;
import com.escom.health.service.DatosMedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DatosMedicosServiceImpl implements DatosMedicosService {

    @Autowired
    private DatosMedicosRepository datosMedicosRepository;

    @Override
    public boolean addDatosMedicos(DatosMedicos datosMedicos) throws IOException {
        try {
            DatosMedicos datosMedicos1 = new DatosMedicos(
                    datosMedicos.getIdDatosMedicos(),
                    datosMedicos.getPresionArterial(),
                    datosMedicos.getFrecuenciaCardiaca(),
                    datosMedicos.getPeso(),
                    datosMedicos.getAltura(),
                    datosMedicos.getTemperaturaCorporal(),
                    datosMedicos.getFechaMedicion(),
                    datosMedicos.getMedicoResponsable()


            );

            datosMedicosRepository.save(datosMedicos1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<DatosMedicos> getDatosMedicos() {
        return datosMedicosRepository.findAll();

    }

    public DatosMedicos getDatosMedicosById(int id) {
        return datosMedicosRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateDatosMedicos(DatosMedicos datosMedicos , int id) throws IOException {
        try {
            DatosMedicos datosMedicosTest = datosMedicosRepository.findById(id).orElse(null);

            if (datosMedicosTest != null){

                datosMedicosTest.setIdDatosMedicos(datosMedicos.getIdDatosMedicos());
                datosMedicosTest.setPresionArterial(datosMedicos.getPresionArterial());
                datosMedicosTest.setFrecuenciaCardiaca(datosMedicos.getFrecuenciaCardiaca());
                datosMedicosTest.setPeso(datosMedicos.getPeso());
                datosMedicosTest.setAltura(datosMedicos.getAltura());
                datosMedicosTest.setTemperaturaCorporal(datosMedicos.getTemperaturaCorporal());
                datosMedicosTest.setFechaMedicion(datosMedicos.getFechaMedicion());
                datosMedicosTest.setMedicoResponsable(datosMedicos.getMedicoResponsable());


                datosMedicosRepository.save(datosMedicosTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteDatosMedicos(int id) {
        try {
            DatosMedicos test = datosMedicosRepository.findById(id).orElse(null);
            if ( test != null) {
                datosMedicosRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}




