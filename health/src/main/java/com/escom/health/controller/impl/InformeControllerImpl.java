package com.escom.health.controller.impl;

import com.escom.health.controller.InformeController;
import com.escom.health.model.Informe;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.InformeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/informe")
public class InformeControllerImpl implements InformeController {

    @Autowired
    private final InformeServiceImpl informesService;

    public InformeControllerImpl(InformeServiceImpl informesService) {
        this.informesService = informesService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllInformes() {
        List<Informe> informes = informesService.getInforme();
        return new ResponseData("success", HttpStatus.OK.value(), informes);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getInformeById(@PathVariable int id) {
        Informe informe = informesService.getInformeById(id);
        if (informe != null) {
            return new ResponseData("success", HttpStatus.OK.value(), informe);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Informe no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createInforme(@RequestBody Informe informe)  {
        try{
            boolean result = informesService.addInforme(informe);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), informe);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar informe");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar informe");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateInforme(@RequestBody Informe informe, @PathVariable int id){
        try{
            boolean result = informesService.updateInforme(informe , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), informe);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar informe");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar informe");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteInforme(@PathVariable int id) {
        boolean result = informesService.deleteInforme(id);
        if (result) {
            return new ResponseData("success", 200, "Informe eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar informe");
        }
    }
}



