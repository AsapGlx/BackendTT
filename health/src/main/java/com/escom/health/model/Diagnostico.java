package com.escom.health.model;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "Diagnostico")
public class Diagnostico {

    @Id
    @Field("_id")
    @NonNull
    private int idDiagnostico;
    private String descripcion;
    private LocalDate fechaDiagnostico;
    private String medicoResponsable;
    private String resultado;

    public Diagnostico() {
    }

    public Diagnostico(@NonNull int idDiagnostico, String descripcion, LocalDate fechaDiagnostico, String medicoResponsable, String resultado) {
        this.idDiagnostico = idDiagnostico;
        this.descripcion = descripcion;
        this.fechaDiagnostico = fechaDiagnostico;
        this.medicoResponsable = medicoResponsable;
        this.resultado = resultado;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(LocalDate fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getMedicoResponsable() {
        return medicoResponsable;
    }

    public void setMedicoResponsable(String medicoResponsable) {
        this.medicoResponsable = medicoResponsable;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
