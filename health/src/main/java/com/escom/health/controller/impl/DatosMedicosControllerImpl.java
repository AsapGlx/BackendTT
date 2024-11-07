package com.escom.health.controller.impl;

import com.escom.health.controller.DatosMedicosController;
import com.escom.health.model.DatosMedicos;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.DatosMedicosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/datosMedicos")
public class DatosMedicosControllerImpl implements DatosMedicosController {

    @Autowired
    private final DatosMedicosServiceImpl datosMedicossService;

    public DatosMedicosControllerImpl(DatosMedicosServiceImpl datosMedicossService) {
        this.datosMedicossService = datosMedicossService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllDatosMedicoss() {
        List<DatosMedicos> datosMedicoss = datosMedicossService.getDatosMedicos();
        return new ResponseData("success", HttpStatus.OK.value(), datosMedicoss);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getDatosMedicosById(@PathVariable int id) {
        DatosMedicos datosMedicos = datosMedicossService.getDatosMedicosById(id);
        if (datosMedicos != null) {
            return new ResponseData("success", HttpStatus.OK.value(), datosMedicos);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "DatosMedicos no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createDatosMedicos(@RequestBody DatosMedicos datosMedicos)  {
        try{
            boolean result = datosMedicossService.addDatosMedicos(datosMedicos);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), datosMedicos);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar datosMedicos");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar datosMedicos");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateDatosMedicos(@RequestBody DatosMedicos datosMedicos, @PathVariable int id){
        try{
            boolean result = datosMedicossService.updateDatosMedicos(datosMedicos , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), datosMedicos);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar datosMedicos");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar datosMedicos");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteDatosMedicos(@PathVariable int id) {
        boolean result = datosMedicossService.deleteDatosMedicos(id);
        if (result) {
            return new ResponseData("success", 200, "DatosMedicos eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar datosMedicos");
        }
    }
}



