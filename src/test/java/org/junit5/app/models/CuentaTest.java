package org.junit5.app.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("Carlos", new BigDecimal("100044.431"));
        String esperado = "Carlos";
        String real = cuenta.getPersona();
        assertTrue(real.equals(esperado));
        assertEquals(esperado, real);
    }

}