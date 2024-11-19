package com.escom.health.controller.impl;

import com.escom.health.controller.DatoMedicoController;
import com.escom.health.model.DatoMedico;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.DatoMedicoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/datosMedicos")
public class DatoMedicoControllerImpl implements DatoMedicoController {

    @Autowired
    private final DatoMedicoServiceImpl datoMedicoService;

    public DatoMedicoControllerImpl(DatoMedicoServiceImpl datoMedicoService) {
        this.datoMedicoService = datoMedicoService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllDatoMedico() {
        List<DatoMedico> datoMedico = datoMedicoService.getDatoMedico();
        return new ResponseData("success", HttpStatus.OK.value(), datoMedico);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getDatoMedicoById(@PathVariable int id) {
        DatoMedico datoMedico = datoMedicoService.getDatoMedicoById(id);
        if (datoMedico != null) {
            return new ResponseData("success", HttpStatus.OK.value(), datoMedico);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "DatoMedico no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createDatoMedico(@RequestBody DatoMedico datoMedico)  {
        try{
            boolean result = datoMedicoService.addDatoMedico(datoMedico);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), datoMedico);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar datoMedico");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar datoMedico");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateDatoMedico(@RequestBody DatoMedico datoMedico, @PathVariable int id){
        try{
            boolean result = datoMedicoService.updateDatoMedico(datoMedico, id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), datoMedico);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar datoMedico");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar datoMedico");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteDatoMedico(@PathVariable int id) {
        boolean result = datoMedicoService.deleteDatoMedico(id);
        if (result) {
            return new ResponseData("success", 200, "DatoMedico eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar datosMedicos");
        }
    }
}



