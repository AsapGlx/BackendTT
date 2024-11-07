package com.escom.health.controller;

import com.escom.health.model.Recomendacion;
import com.escom.health.model.ResponseData;

public interface RecomendacionController {

    ResponseData getAllRecomendacions();

    ResponseData getRecomendacionById(int id);

    ResponseData createRecomendacion(Recomendacion recomendacion);

    ResponseData updateRecomendacion(Recomendacion recomendacion, int id);

    ResponseData deleteRecomendacion(int id);
}
