package com.escom.health.model;


import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "Informe")
public class Informe {

    @Id
    @Field("_id")
    @NonNull
    private int idInforme;
    private LocalDate fechaGeneracion;
    private String titulo;
    private String descripcion;
    private String investigadorResponsable;

    public Informe() {
    }

    public Informe(@NonNull int idInforme, LocalDate fechaGeneracion, String titulo, String descripcion, String investigadorResponsable) {
        this.idInforme = idInforme;
        this.fechaGeneracion = fechaGeneracion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.investigadorResponsable = investigadorResponsable;
    }

    public int getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(int idInforme) {
        this.idInforme = idInforme;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInvestigadorResponsable() {
        return investigadorResponsable;
    }

    public void setInvestigadorResponsable(String investigadorResponsable) {
        this.investigadorResponsable = investigadorResponsable;
    }
}
