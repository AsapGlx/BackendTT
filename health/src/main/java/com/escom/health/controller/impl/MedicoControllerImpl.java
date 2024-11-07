package com.escom.health.controller.impl;

import com.escom.health.controller.MedicoController;
import com.escom.health.model.Medico;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.MedicoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/medico")
public class MedicoControllerImpl implements MedicoController {

    @Autowired
    private final MedicoServiceImpl medicosService;

    public MedicoControllerImpl(MedicoServiceImpl medicosService) {
        this.medicosService = medicosService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllMedicos() {
        List<Medico> medicos = medicosService.getMedico();
        return new ResponseData("success", HttpStatus.OK.value(), medicos);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getMedicoById(@PathVariable int id) {
        Medico medico = medicosService.getMedicoById(id);
        if (medico != null) {
            return new ResponseData("success", HttpStatus.OK.value(), medico);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Medico no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createMedico(@RequestBody Medico medico)  {
        try{
            boolean result = medicosService.addMedico(medico);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), medico);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar medico");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar medico");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateMedico(@RequestBody Medico medico, @PathVariable int id){
        try{
            boolean result = medicosService.updateMedico(medico , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), medico);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar medico");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar medico");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteMedico(@PathVariable int id) {
        boolean result = medicosService.deleteMedico(id);
        if (result) {
            return new ResponseData("success", 200, "Medico eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar medico");
        }
    }
}

