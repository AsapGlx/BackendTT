package com.escom.health.model;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Medicamento")
public class Medicamento {

    @Id
    @Field("_id")
    @NonNull
    private int idMedicamento;
    private String nombre;
    private String dosis;
    private String frecuencia;
    private Integer duracionTratamiento;
    private String efectoSecundario;
    private String recomendacion;

    public Medicamento() {
    }

    public Medicamento(@NonNull int idMedicamento, String nombre, String dosis, String frecuencia, Integer duracionTratamiento, String efectoSecundario, String recomendacion) {
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracionTratamiento = duracionTratamiento;
        this.efectoSecundario = efectoSecundario;
        this.recomendacion = recomendacion;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Integer getDuracionTratamiento() {
        return duracionTratamiento;
    }

    public void setDuracionTratamiento(Integer duracionTratamiento) {
        this.duracionTratamiento = duracionTratamiento;
    }

    public String getEfectoSecundario() {
        return efectoSecundario;
    }

    public void setEfectoSecundario(String efectoSecundario) {
        this.efectoSecundario = efectoSecundario;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
}
