package com.escom.health.service.impl;

import com.escom.health.model.Paciente;
import com.escom.health.repository.PacienteRepository;
import com.escom.health.service.PacienteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public boolean addPaciente(Paciente paciente) throws IOException {
        try {
            Paciente paciente1 = new Paciente(
                    paciente.getId(),
                    paciente.getNombre(),
                    paciente.getEdad(),
                    paciente.getSexo(),
                    paciente.getDireccion(),
                    paciente.getTelefono(),
                    paciente.getCorreo(),
                    paciente.getFechaRegistro()
            );

            pacienteRepository.save(paciente1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Paciente> getPaciente() {
        return pacienteRepository.findAll();

    }

    public Paciente getPacienteById(int id) {
        return pacienteRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updatePaciente(Paciente paciente , int id) throws IOException {
        try {
            Paciente pacienteTest = pacienteRepository.findById(id).orElse(null);

             if (pacienteTest != null){

                 pacienteTest.setNombre(paciente.getNombre());
                 pacienteTest.setEdad(paciente.getEdad());
                 pacienteTest.setSexo(paciente.getSexo());
                 pacienteTest.setDireccion(paciente.getDireccion());
                 pacienteTest.setTelefono(paciente.getTelefono());
                 pacienteTest.setCorreo(paciente.getCorreo());
                 pacienteTest.setFechaRegistro(paciente.getFechaRegistro());

                 pacienteRepository.save(pacienteTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deletePaciente(int id) {
        try {
            Paciente test = pacienteRepository.findById(id).orElse(null);
            if ( test != null) {
                pacienteRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
