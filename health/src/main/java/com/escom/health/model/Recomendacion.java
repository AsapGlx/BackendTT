package com.escom.health.model;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "Recomendacion")
public class Recomendacion {

    @Id
    @Field("_id")
    @NonNull
    private int idRecomendacion;

    private LocalDate fechaRecomendacion;
    private String medicoResponsable;
    private Boolean estadoCumplimiento;

    public Recomendacion() {
    }

    public Recomendacion(@NonNull int idRecomendacion, LocalDate fechaRecomendacion, String medicoResponsable, Boolean estadoCumplimiento) {
        this.idRecomendacion = idRecomendacion;
        this.fechaRecomendacion = fechaRecomendacion;
        this.medicoResponsable = medicoResponsable;
        this.estadoCumplimiento = estadoCumplimiento;
    }

    public int getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(int idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public LocalDate getFechaRecomendacion() {
        return fechaRecomendacion;
    }

    public void setFechaRecomendacion(LocalDate fechaRecomendacion) {
        this.fechaRecomendacion = fechaRecomendacion;
    }

    public String getMedicoResponsable() {
        return medicoResponsable;
    }

    public void setMedicoResponsable(String medicoResponsable) {
        this.medicoResponsable = medicoResponsable;
    }

    public Boolean getEstadoCumplimiento() {
        return estadoCumplimiento;
    }

    public void setEstadoCumplimiento(Boolean estadoCumplimiento) {
        this.estadoCumplimiento = estadoCumplimiento;
    }
}
