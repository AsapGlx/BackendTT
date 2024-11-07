package com.escom.health.controller.impl;

import com.escom.health.controller.CitaController;
import com.escom.health.model.Cita;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.CitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/cita")
public class CitaControllerImpl implements CitaController {

    @Autowired
    private final CitaServiceImpl citasService;

    public CitaControllerImpl(CitaServiceImpl citasService) {
        this.citasService = citasService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllCitas() {
        List<Cita> citas = citasService.getCita();
        return new ResponseData("success", HttpStatus.OK.value(), citas);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getCitaById(@PathVariable int id) {
        Cita cita = citasService.getCitaById(id);
        if (cita != null) {
            return new ResponseData("success", HttpStatus.OK.value(), cita);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Cita no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createCita(@RequestBody Cita cita)  {
        try{
            boolean result = citasService.addCita(cita);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), cita);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar cita");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar cita");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateCita(@RequestBody Cita cita, @PathVariable int id){
        try{
            boolean result = citasService.updateCita(cita , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), cita);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar cita");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar cita");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteCita(@PathVariable int id) {
        boolean result = citasService.deleteCita(id);
        if (result) {
            return new ResponseData("success", 200, "Cita eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar cita");
        }
    }
}
