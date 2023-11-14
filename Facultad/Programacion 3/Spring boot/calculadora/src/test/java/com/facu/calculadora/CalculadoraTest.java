package com.facu.calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora c = new Calculadora();
    @Test
    void suma() {
        int esperado = 5;
        int resultado = c.suma(2,3);
        assertEquals(esperado, resultado);
        System.out.println("Suma");
    }

    @Test
    void resta() {
        int esperado = 4;
        int resultado = c.resta(8,4);
        assertEquals(esperado, resultado);
        System.out.println("Resta");
    }

    @Test
    void dividir() {
        assertEquals(4, c.dividir(12,3));
    }

    @Test
    void dividir1() {
        try {
            assertEquals(0, c.dividir(12, 0));
        }catch (Exception e){
            System.out.println("Ocurrio un error " + e.getMessage());
        }
        System.out.println("Division por 0");
    }

    @Test
    void multiplicar() {
        assertEquals(12,c.multiplicar(4,3));
        System.out.println("Multiplicar");
    }
}