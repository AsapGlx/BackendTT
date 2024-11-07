package com.escom.health.service.impl;

import com.escom.health.model.Historial;
import com.escom.health.repository.HistorialRepository;
import com.escom.health.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    @Override
    public boolean addHistorial(Historial historial) throws IOException {
        try {
            Historial historial1 = new Historial(
                    historial.getIdHistorial(),
                    historial.getFechaInicio(),
                    historial.getCondicionActual(),
                    historial.getAlergias(),
                    historial.getEnfermedadesCronicas(),
                    historial.getTratamientosActuales(),
                    historial.getHistorialFamiliar()

            );

            historialRepository.save(historial1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Historial> getHistorial() {
        return historialRepository.findAll();

    }

    public Historial getHistorialById(int id) {
        return historialRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateHistorial(Historial historial , int id) throws IOException {
        try {
            Historial historialTest = historialRepository.findById(id).orElse(null);

            if (historialTest != null){

                historialTest.setIdHistorial(historial.getIdHistorial());
                historialTest.setFechaInicio(historial.getFechaInicio());
                historialTest.setCondicionActual(historial.getCondicionActual());
                historialTest.setAlergias(historial.getAlergias());
                historialTest.setEnfermedadesCronicas(historial.getEnfermedadesCronicas());
                historialTest.setTratamientosActuales(historial.getTratamientosActuales());
                historialTest.setHistorialFamiliar(historial.getHistorialFamiliar());

                historialRepository.save(historialTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteHistorial(int id) {
        try {
            Historial test = historialRepository.findById(id).orElse(null);
            if ( test != null) {
                historialRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}




