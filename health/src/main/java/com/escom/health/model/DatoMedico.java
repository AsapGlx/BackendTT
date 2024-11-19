package com.escom.health.model;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "DatoMedico")
public class DatoMedico {

    @Id
    @Field("_id")
    @NonNull
    private int idDatoMedico;
    private String presionArterial;
    private Integer frecuenciaCardiaca;
    private Double peso;
    private Double altura;
    private Double temperaturaCorporal;
    private LocalDate fechaMedicion;
    private String medicoResponsable;

    public DatoMedico() {
    }

    public DatoMedico(@NonNull int idDatoMedico, String presionArterial, Integer frecuenciaCardiaca, Double peso, Double altura, Double temperaturaCorporal, LocalDate fechaMedicion, String medicoResponsable) {
        this.idDatoMedico = idDatoMedico;
        this.presionArterial = presionArterial;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.peso = peso;
        this.altura = altura;
        this.temperaturaCorporal = temperaturaCorporal;
        this.fechaMedicion = fechaMedicion;
        this.medicoResponsable = medicoResponsable;
    }

    public int getIdDatoMedico() {
        return idDatoMedico;
    }

    public void setIdDatoMedico(int idDatoMedico) {
        this.idDatoMedico = idDatoMedico;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public Integer getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(Integer frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public void setTemperaturaCorporal(Double temperaturaCorporal) {
        this.temperaturaCorporal = temperaturaCorporal;
    }

    public LocalDate getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(LocalDate fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public String getMedicoResponsable() {
        return medicoResponsable;
    }

    public void setMedicoResponsable(String medicoResponsable) {
        this.medicoResponsable = medicoResponsable;
    }
}
