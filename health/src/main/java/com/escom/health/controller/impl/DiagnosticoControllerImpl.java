package com.escom.health.controller.impl;

import com.escom.health.controller.DiagnosticoController;
import com.escom.health.model.Diagnostico;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.DiagnosticoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/diagnostico")
public class DiagnosticoControllerImpl implements DiagnosticoController {

    @Autowired
    private final DiagnosticoServiceImpl diagnosticosService;

    public DiagnosticoControllerImpl(DiagnosticoServiceImpl diagnosticosService) {
        this.diagnosticosService = diagnosticosService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllDiagnosticos() {
        List<Diagnostico> diagnosticos = diagnosticosService.getDiagnostico();
        return new ResponseData("success", HttpStatus.OK.value(), diagnosticos);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getDiagnosticoById(@PathVariable int id) {
        Diagnostico diagnostico = diagnosticosService.getDiagnosticoById(id);
        if (diagnostico != null) {
            return new ResponseData("success", HttpStatus.OK.value(), diagnostico);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Diagnostico no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createDiagnostico(@RequestBody Diagnostico diagnostico)  {
        try{
            boolean result = diagnosticosService.addDiagnostico(diagnostico);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), diagnostico);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar diagnostico");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar diagnostico");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateDiagnostico(@RequestBody Diagnostico diagnostico, @PathVariable int id){
        try{
            boolean result = diagnosticosService.updateDiagnostico(diagnostico , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), diagnostico);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar diagnostico");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar diagnostico");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteDiagnostico(@PathVariable int id) {
        boolean result = diagnosticosService.deleteDiagnostico(id);
        if (result) {
            return new ResponseData("success", 200, "Diagnostico eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar diagnostico");
        }
    }
}




