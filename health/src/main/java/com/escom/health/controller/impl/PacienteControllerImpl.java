package com.escom.health.controller.impl;

import com.escom.health.controller.PacienteController;
import com.escom.health.model.Paciente;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.PacienteServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/paciente")
public class PacienteControllerImpl implements PacienteController {

    @Autowired
    private final PacienteServiceImpl pacientesService;

    public PacienteControllerImpl(PacienteServiceImpl pacientesService) {
        this.pacientesService = pacientesService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllPacientes() {
        List<Paciente> pacientes = pacientesService.getPaciente();
        return new ResponseData("success", HttpStatus.OK.value(), pacientes);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getPacienteById(@PathVariable int id) {
        Paciente paciente = pacientesService.getPacienteById(id);
        if (paciente != null) {
            return new ResponseData("success", HttpStatus.OK.value(), paciente);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Paciente no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createPaciente(@RequestBody Paciente paciente)  {
        try{
        boolean result = pacientesService.addPaciente(paciente);
        if (result) {
            return new ResponseData("success", HttpStatus.CREATED.value(), paciente);
        } else {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar paciente");
        }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar paciente");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updatePaciente(@RequestBody Paciente paciente, @PathVariable int id){
        try{
        boolean result = pacientesService.updatePaciente(paciente , id);
        if (result) {
            return new ResponseData("success",  HttpStatus.OK.value(), paciente);
        } else {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar paciente");
        }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar paciente");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deletePaciente(@PathVariable int id) {
        boolean result = pacientesService.deletePaciente(id);
        if (result) {
            return new ResponseData("success", 200, "Paciente eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar paciente");
        }
    }
}
