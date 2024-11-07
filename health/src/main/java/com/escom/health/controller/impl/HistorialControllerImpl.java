package com.escom.health.controller.impl;

import com.escom.health.controller.HistorialController;
import com.escom.health.model.Historial;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.HistorialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/historial")
public class HistorialControllerImpl implements HistorialController {

    @Autowired
    private final HistorialServiceImpl historialsService;

    public HistorialControllerImpl(HistorialServiceImpl historialsService) {
        this.historialsService = historialsService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllHistorials() {
        List<Historial> historials = historialsService.getHistorial();
        return new ResponseData("success", HttpStatus.OK.value(), historials);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getHistorialById(@PathVariable int id) {
        Historial historial = historialsService.getHistorialById(id);
        if (historial != null) {
            return new ResponseData("success", HttpStatus.OK.value(), historial);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Historial no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createHistorial(@RequestBody Historial historial)  {
        try{
            boolean result = historialsService.addHistorial(historial);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), historial);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar historial");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar historial");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateHistorial(@RequestBody Historial historial, @PathVariable int id){
        try{
            boolean result = historialsService.updateHistorial(historial , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), historial);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar historial");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar historial");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteHistorial(@PathVariable int id) {
        boolean result = historialsService.deleteHistorial(id);
        if (result) {
            return new ResponseData("success", 200, "Historial eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar historial");
        }
    }
}



