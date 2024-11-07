package com.escom.health.controller.impl;

import com.escom.health.controller.InvestigadorController;
import com.escom.health.model.Investigador;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.InvestigadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/investigador")
public class InvestigadorControllerImpl implements InvestigadorController {

    @Autowired
    private final InvestigadorServiceImpl investigadorsService;

    public InvestigadorControllerImpl(InvestigadorServiceImpl investigadorsService) {
        this.investigadorsService = investigadorsService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllInvestigadors() {
        List<Investigador> investigadors = investigadorsService.getInvestigador();
        return new ResponseData("success", HttpStatus.OK.value(), investigadors);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getInvestigadorById(@PathVariable int id) {
        Investigador investigador = investigadorsService.getInvestigadorById(id);
        if (investigador != null) {
            return new ResponseData("success", HttpStatus.OK.value(), investigador);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Investigador no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createInvestigador(@RequestBody Investigador investigador)  {
        try{
            boolean result = investigadorsService.addInvestigador(investigador);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), investigador);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar investigador");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar investigador");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateInvestigador(@RequestBody Investigador investigador, @PathVariable int id){
        try{
            boolean result = investigadorsService.updateInvestigador(investigador , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), investigador);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar investigador");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar investigador");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteInvestigador(@PathVariable int id) {
        boolean result = investigadorsService.deleteInvestigador(id);
        if (result) {
            return new ResponseData("success", 200, "Investigador eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar investigador");
        }
    }
}


