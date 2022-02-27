package org.junit5.app.models;

import org.junit.jupiter.api.Test;
import org.junit5.app.exceptions.DineroInsuficienteException;

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

    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("A", new BigDecimal("123123.2323"));
        assertEquals(123123.2323, cuenta.getSueldo().doubleValue());
        assertFalse(cuenta.getSueldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSueldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("ANDRU", new BigDecimal("123123.2323"));
        Cuenta cuenta2 = new Cuenta("ANDRU", new BigDecimal("123123.2323"));
        assertEquals(cuenta, cuenta2);

    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("ANDRU", new BigDecimal("123123.2323"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSueldo());
        assertEquals("123023.2323", cuenta.getSueldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("ANDRU", new BigDecimal("123123.2323"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSueldo());
        assertEquals("123223.2323", cuenta.getSueldo().toPlainString());
    }

    @Test
    void testDineroInsuficiente(){
        Cuenta cuenta = new Cuenta("Ad", new BigDecimal("1222"));
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });
        String mensajeActual = exception.getMessage();
        String mensajeEsperado = "Dinero Insuficiente";
        assertEquals(mensajeEsperado, mensajeActual);
    }

}