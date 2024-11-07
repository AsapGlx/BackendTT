package com.escom.health.controller.impl;

import com.escom.health.controller.MedicamentoController;
import com.escom.health.model.Medicamento;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.MedicamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/medicamento")
public class MedicamentoControllerImpl implements MedicamentoController {

    @Autowired
    private final MedicamentoServiceImpl medicamentosService;

    public MedicamentoControllerImpl(MedicamentoServiceImpl medicamentosService) {
        this.medicamentosService = medicamentosService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllMedicamentos() {
        List<Medicamento> medicamentos = medicamentosService.getMedicamento();
        return new ResponseData("success", HttpStatus.OK.value(), medicamentos);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getMedicamentoById(@PathVariable int id) {
        Medicamento medicamento = medicamentosService.getMedicamentoById(id);
        if (medicamento != null) {
            return new ResponseData("success", HttpStatus.OK.value(), medicamento);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Medicamento no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createMedicamento(@RequestBody Medicamento medicamento)  {
        try{
            boolean result = medicamentosService.addMedicamento(medicamento);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), medicamento);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar medicamento");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar medicamento");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateMedicamento(@RequestBody Medicamento medicamento, @PathVariable int id){
        try{
            boolean result = medicamentosService.updateMedicamento(medicamento , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), medicamento);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar medicamento");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar medicamento");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteMedicamento(@PathVariable int id) {
        boolean result = medicamentosService.deleteMedicamento(id);
        if (result) {
            return new ResponseData("success", 200, "Medicamento eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar medicamento");
        }
    }
}



