package com.escom.health.model;

/**
 * Esta clase representa una respuesta de datos. Contiene información sobre el estado,
 * el código y la respuesta de una solicitud.
 *
 * El proposito de esta clase es facilitar y generalizar el formato de respuesta JSON que tienen los endpoints o handlers.
 */
public class ResponseData {

    /**
     * Estado de la respuesta.
     */
    private String status;

    /**
     * Código de la respuesta.
     */
    private int code;

    /**
     * Objeto de respuesta.
     */
    private Object response;

    /**
     * Constructor vacío de la clase ResponseData.
     */
    public ResponseData() {}

    /**
     * Constructor de la clase ResponseData con parámetros.
     *
     * @param status   El estado de la respuesta.
     * @param code     El código de la respuesta.
     * @param response El objeto de respuesta.
     */
    public ResponseData(String status, int code, Object response) {
        this.status = status;
        this.code = code;
        this.response = response;
    }

    /**
     * Obtiene el estado de la respuesta.
     *
     * @return El estado de la respuesta.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Establece el estado de la respuesta.
     *
     * @param status El estado de la respuesta.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtiene el código de la respuesta.
     *
     * @return El código de la respuesta.
     */
    public int getCode() {
        return code;
    }

    /**
     * Establece el código de la respuesta.
     *
     * @param code El código de la respuesta.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Obtiene el objeto de respuesta.
     *
     * @return El objeto de respuesta.
     */
    public Object getResponse() {
        return response;
    }

    /**
     * Establece el objeto de respuesta.
     *
     * @param response El objeto de respuesta.
     */
    public void setResponse(Object response) {
        this.response = response;
    }
}

