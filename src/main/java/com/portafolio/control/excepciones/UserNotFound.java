package com.portafolio.control.excepciones;

public class UserNotFound extends Exception{
    private String requestID;
    private String mensaje;
    private String errorCode;

    public UserNotFound(String message, String mensaje) {
        super(message);
        this.mensaje = mensaje;
    }

    public UserNotFound(String message, String requestID, String mensaje, String errorCode) {
        super(message);
        this.requestID = requestID;
        this.mensaje = mensaje;
        this.errorCode = errorCode;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
