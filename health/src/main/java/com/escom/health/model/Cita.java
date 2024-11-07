package com.escom.health.model;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "Cita")
public class Cita {

    @Id
    @Field("_id")
    @NonNull
    private int idCita;
    private Date fechaCita;
    private String horaCita;
    private String medicoAsignado;
    private String motivoCita;
    private Boolean estadoCita;

    public Cita() {
    }

    public Cita(@NonNull int idCita, Date fechaCita, String horaCita, String medicoAsignado, String motivoCita, Boolean estadoCita) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.medicoAsignado = medicoAsignado;
        this.motivoCita = motivoCita;
        this.estadoCita = estadoCita;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(String medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Boolean getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(Boolean estadoCita) {
        this.estadoCita = estadoCita;
    }
}
