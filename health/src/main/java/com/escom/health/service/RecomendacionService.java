package com.escom.health.service;

import com.escom.health.model.Recomendacion;

import java.io.IOException;
import java.util.List;

public interface RecomendacionService {

    boolean addRecomendacion(Recomendacion recomendacion) throws IOException;

    List<Recomendacion> getRecomendacion();

    boolean updateRecomendacion(Recomendacion recomendacion, int id) throws  IOException;

    boolean deleteRecomendacion(int id);
}
