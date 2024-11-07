package com.escom.health.model;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Faqs")
public class Faqs {

    @Id
    @Field("_id")
    @NonNull
    private int idFaqs;
    private String pregunta;
    private String respuesta;

    public Faqs() {
    }

    public Faqs(@NonNull int idFaqs, String pregunta, String respuesta) {
        this.idFaqs = idFaqs;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public int getIdFaqs() {
        return idFaqs;
    }

    public void setIdFaqs(int idFaqs) {
        this.idFaqs = idFaqs;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
