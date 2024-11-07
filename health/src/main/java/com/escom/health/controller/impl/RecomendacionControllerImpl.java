package com.escom.health.controller.impl;

import com.escom.health.controller.RecomendacionController;
import com.escom.health.model.Recomendacion;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.RecomendacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/recomendacion")
public class RecomendacionControllerImpl implements RecomendacionController {

    @Autowired
    private final RecomendacionServiceImpl recomendacionsService;

    public RecomendacionControllerImpl(RecomendacionServiceImpl recomendacionsService) {
        this.recomendacionsService = recomendacionsService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllRecomendacions() {
        List<Recomendacion> recomendacions = recomendacionsService.getRecomendacion();
        return new ResponseData("success", HttpStatus.OK.value(), recomendacions);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getRecomendacionById(@PathVariable int id) {
        Recomendacion recomendacion = recomendacionsService.getRecomendacionById(id);
        if (recomendacion != null) {
            return new ResponseData("success", HttpStatus.OK.value(), recomendacion);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Recomendacion no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createRecomendacion(@RequestBody Recomendacion recomendacion)  {
        try{
            boolean result = recomendacionsService.addRecomendacion(recomendacion);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), recomendacion);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar recomendacion");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar recomendacion");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateRecomendacion(@RequestBody Recomendacion recomendacion, @PathVariable int id){
        try{
            boolean result = recomendacionsService.updateRecomendacion(recomendacion , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), recomendacion);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar recomendacion");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar recomendacion");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteRecomendacion(@PathVariable int id) {
        boolean result = recomendacionsService.deleteRecomendacion(id);
        if (result) {
            return new ResponseData("success", 200, "Recomendacion eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar recomendacion");
        }
    }
}



