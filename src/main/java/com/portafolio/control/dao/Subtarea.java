package com.portafolio.control.dao;

import java.util.Date;

public interface Subtarea {
    Long getID_SUBTAREA();
    String getNOMBRE_SUBTAREA();
    String getDESCRIPCION();
    Date getFECHA_CREACION();
    Date getFECHA_INICIO();
    Date getFECHA_TERMINO();
    Long getID_TAREA();
}
