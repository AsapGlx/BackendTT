package com.escom.health.model;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Investigador")
public class Investigador {

    @Id
    @Field("_id")
    @NonNull
    private int idInvestigador;
    private String nombre;
    private String institucion;
    private String areaEspecializacion;
    @Field("correoElectronicoElectronico")
    private String correoElectronico;
    private Integer telefono;

    public Investigador() {
    }

    public Investigador(@NonNull int idInvestigador, String nombre, String institucion, String areaEspecializacion, String correoElectronico, Integer telefono) {
        this.idInvestigador = idInvestigador;
        this.nombre = nombre;
        this.institucion = institucion;
        this.areaEspecializacion = areaEspecializacion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    public int getIdInvestigador() {
        return idInvestigador;
    }

    public void setIdInvestigador(int idInvestigador) {
        this.idInvestigador = idInvestigador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getAreaEspecializacion() {
        return areaEspecializacion;
    }

    public void setAreaEspecializacion(String areaEspecializacion) {
        this.areaEspecializacion = areaEspecializacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}
