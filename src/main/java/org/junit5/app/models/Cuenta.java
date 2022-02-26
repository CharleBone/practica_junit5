package org.junit5.app.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cuenta implements Serializable {


    private static final long serialVersionUID = 6085676124460926119L;

    private String persona;
    private BigDecimal sueldo;

    public Cuenta(String persona, BigDecimal sueldo) {
        this.persona = persona;
        this.sueldo = sueldo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }
}
