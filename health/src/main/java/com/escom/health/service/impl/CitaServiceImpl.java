package com.escom.health.service.impl;

import com.escom.health.model.Cita;
import com.escom.health.repository.CitaRepository;
import com.escom.health.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public boolean addCita(Cita cita) throws IOException {
        try {
            Cita cita1 = new Cita(
                    cita.getIdCita(),
                    cita.getFechaCita(),
                    cita.getHoraCita(),
                    cita.getMedicoAsignado(),
                    cita.getMotivoCita(),
                    cita.getEstadoCita()
            );

            citaRepository.save(cita1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Cita> getCita() {
        return citaRepository.findAll();

    }

    public Cita getCitaById(int id) {
        return citaRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateCita(Cita cita , int id) throws IOException {
        try {
            Cita citaTest = citaRepository.findById(id).orElse(null);

            if (citaTest != null){

                citaTest.setIdCita(cita.getIdCita());
                citaTest.setFechaCita(cita.getFechaCita());
                citaTest.setHoraCita(cita.getHoraCita());
                citaTest.setMedicoAsignado(cita.getMedicoAsignado());
                citaTest.setMotivoCita(cita.getMotivoCita());
                citaTest.setEstadoCita(cita.getEstadoCita());


                citaRepository.save(citaTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteCita(int id) {
        try {
            Cita test = citaRepository.findById(id).orElse(null);
            if ( test != null) {
                citaRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

