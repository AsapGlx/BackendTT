package com.escom.health.model;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.SimpleTimeZone;

@Document(collection = "Historial")
public class Historial {

    @Id
    @Field("_id")
    @NonNull
    private int idHistorial;
    private Date fechaInicio;
    private String condicionActual;
    private String alergias;
    private String enfermedadesCronicas;
    private String tratamientosActuales;
    private String historialFamiliar;

    public Historial() {
    }

    public Historial(@NonNull int idHistorial, Date fechaInicio, String condicionActual, String alergias, String enfermedadesCronicas, String tratamientosActuales, String historialFamiliar) {
        this.idHistorial = idHistorial;
        this.fechaInicio = fechaInicio;
        this.condicionActual = condicionActual;
        this.alergias = alergias;
        this.enfermedadesCronicas = enfermedadesCronicas;
        this.tratamientosActuales = tratamientosActuales;
        this.historialFamiliar = historialFamiliar;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCondicionActual() {
        return condicionActual;
    }

    public void setCondicionActual(String condicionActual) {
        this.condicionActual = condicionActual;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getEnfermedadesCronicas() {
        return enfermedadesCronicas;
    }

    public void setEnfermedadesCronicas(String enfermedadesCronicas) {
        this.enfermedadesCronicas = enfermedadesCronicas;
    }

    public String getTratamientosActuales() {
        return tratamientosActuales;
    }

    public void setTratamientosActuales(String tratamientosActuales) {
        this.tratamientosActuales = tratamientosActuales;
    }

    public String getHistorialFamiliar() {
        return historialFamiliar;
    }

    public void setHistorialFamiliar(String historialFamiliar) {
        this.historialFamiliar = historialFamiliar;
    }
}
