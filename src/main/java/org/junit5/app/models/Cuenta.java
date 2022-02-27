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

    public void debito(BigDecimal monto) {
        this.sueldo.subtract(monto);
    }

    public void credito(BigDecimal monto) {
        this.sueldo.add(monto);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cuenta)) return false;
        if (this.persona == null || this.sueldo == null) return  false;
        Cuenta c = (Cuenta) obj;
        return this.persona.equals(c.getPersona()) && this.sueldo.equals(c.getSueldo());
    }
}
