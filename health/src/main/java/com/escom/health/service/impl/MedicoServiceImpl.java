package com.escom.health.service.impl;

import com.escom.health.model.Medico;
import com.escom.health.repository.MedicoRepository;
import com.escom.health.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class MedicoServiceImpl implements MedicoService {
    
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public boolean addMedico(Medico medico) throws IOException {
        try {
            Medico medico1 = new Medico(
                    medico.getIdMedico(),
                    medico.getNombre(),
                    medico.getEspecialidad(),
                    medico.getCorreoElectronico(),
                    medico.getTelefono(),
                    medico.getHorarioAtencion()

            );

            medicoRepository.save(medico1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Medico> getMedico() {
        return medicoRepository.findAll();

    }

    public Medico getMedicoById(int id) {
        return medicoRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateMedico(Medico medico , int id) throws IOException {
        try {
            Medico medicoTest = medicoRepository.findById(id).orElse(null);

            if (medicoTest != null){

                medicoTest.setIdMedico(medico.getIdMedico());
                medicoTest.setNombre(medico.getNombre());
                medicoTest.setEspecialidad(medico.getEspecialidad());
                medicoTest.setCorreoElectronico(medico.getCorreoElectronico());
                medicoTest.setTelefono(medico.getTelefono());
                medicoTest.setHorarioAtencion(medico.getHorarioAtencion());



                medicoRepository.save(medicoTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteMedico(int id) {
        try {
            Medico test = medicoRepository.findById(id).orElse(null);
            if ( test != null) {
                medicoRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


