package com.escom.health.controller.impl;

import com.escom.health.controller.FaqsController;
import com.escom.health.model.Faqs;
import com.escom.health.model.ResponseData;
import com.escom.health.service.impl.FaqsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/faqs")
public class FaqsControllerImpl implements FaqsController {

    @Autowired
    private final FaqsServiceImpl faqsService;

    public FaqsControllerImpl(FaqsServiceImpl faqsService) {
        this.faqsService = faqsService;
    }

    @Override
    @GetMapping("/all")
    public ResponseData getAllFaqs() {
        List<Faqs> faqs = faqsService.getFaqs();
        return new ResponseData("success", HttpStatus.OK.value(), faqs);
    }

    @Override
    @GetMapping("/all/{id}")
    public ResponseData getFaqsById(@PathVariable int id) {
        Faqs faqs = faqsService.getFaqsById(id);
        if (faqs != null) {
            return new ResponseData("success", HttpStatus.OK.value(), faqs);
        } else {
            return new ResponseData("error", HttpStatus.NOT_FOUND.value(), "Faqs no encontrado");
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseData createFaqs(@RequestBody Faqs faqs)  {
        try{
            boolean result = faqsService.addFaqs(faqs);
            if (result) {
                return new ResponseData("success", HttpStatus.CREATED.value(), faqs);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar faqs");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al agregar faqs");
        }
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseData updateFaqs(@RequestBody Faqs faqs, @PathVariable int id){
        try{
            boolean result = faqsService.updateFaqs(faqs , id);
            if (result) {
                return new ResponseData("success",  HttpStatus.OK.value(), faqs);
            } else {
                return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar faqs");
            }} catch (IOException e) {
            return new ResponseData("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar faqs");
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseData deleteFaqs(@PathVariable int id) {
        boolean result = faqsService.deleteFaqs(id);
        if (result) {
            return new ResponseData("success", 200, "Faqs eliminado exitosamente");
        } else {
            return new ResponseData("error", 500, "Error al eliminar faqs");
        }
    }
}


