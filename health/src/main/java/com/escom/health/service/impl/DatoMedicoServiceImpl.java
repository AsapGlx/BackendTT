package com.escom.health.service.impl;

import com.escom.health.model.DatoMedico;
import com.escom.health.repository.DatoMedicoRepository;
import com.escom.health.service.DatoMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DatoMedicoServiceImpl implements DatoMedicoService {

    @Autowired
    private DatoMedicoRepository datosMedicosRepository;

    @Override
    public boolean addDatoMedico(DatoMedico datoMedico) throws IOException {
        try {
            DatoMedico datoMedico1 = new DatoMedico(
                    datoMedico.getIdDatoMedico(),
                    datoMedico.getPresionArterial(),
                    datoMedico.getFrecuenciaCardiaca(),
                    datoMedico.getPeso(),
                    datoMedico.getAltura(),
                    datoMedico.getTemperaturaCorporal(),
                    datoMedico.getFechaMedicion(),
                    datoMedico.getMedicoResponsable()


            );

            datosMedicosRepository.save(datoMedico1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<DatoMedico> getDatoMedico() {
        return datosMedicosRepository.findAll();

    }

    public DatoMedico getDatoMedicoById(int id) {
        return datosMedicosRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateDatoMedico(DatoMedico datoMedico, int id) throws IOException {
        try {
            DatoMedico datoMedicoTest = datosMedicosRepository.findById(id).orElse(null);

            if (datoMedicoTest != null){

                datoMedicoTest.setIdDatoMedico(datoMedico.getIdDatoMedico());
                datoMedicoTest.setPresionArterial(datoMedico.getPresionArterial());
                datoMedicoTest.setFrecuenciaCardiaca(datoMedico.getFrecuenciaCardiaca());
                datoMedicoTest.setPeso(datoMedico.getPeso());
                datoMedicoTest.setAltura(datoMedico.getAltura());
                datoMedicoTest.setTemperaturaCorporal(datoMedico.getTemperaturaCorporal());
                datoMedicoTest.setFechaMedicion(datoMedico.getFechaMedicion());
                datoMedicoTest.setMedicoResponsable(datoMedico.getMedicoResponsable());


                datosMedicosRepository.save(datoMedicoTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteDatoMedico(int id) {
        try {
            DatoMedico test = datosMedicosRepository.findById(id).orElse(null);
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




