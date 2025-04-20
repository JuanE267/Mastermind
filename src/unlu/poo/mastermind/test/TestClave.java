package unlu.poo.mastermind.test;


import org.junit.jupiter.api.*;
import unlu.poo.mastermind.juego.Clave;
import unlu.poo.mastermind.juego.FichaCodificadora;

import static org.junit.jupiter.api.Assertions.*;

public class TestClave {

    Clave miClave;

    @BeforeEach
    void setUp() throws Exception{
        FichaCodificadora[] miCombinacion = {
                FichaCodificadora.ROJO ,
                FichaCodificadora.BLANCO,
                FichaCodificadora.AZUL,
                FichaCodificadora.VERDE,
                FichaCodificadora.NARANJA};

        miClave = new Clave(miCombinacion);

    }

    @Test
    void probarQueLaPrimeraFichaEsRojo() throws Exception {
        assertEquals(FichaCodificadora.ROJO, miClave.getColor(1));
    }

    @Test
    void probarQueLaSegundaFichaEsBlanco() throws Exception {
        assertEquals(FichaCodificadora.BLANCO, miClave.getColor(2));
    }

    @Test
    void probarQueLaTerceraFichaEsAzul() throws Exception {
        assertEquals(FichaCodificadora.AZUL, miClave.getColor(3));
    }

    @Test
    void probarQuePasarPosicionMayorACincoDaError(){
        assertThrows(Exception.class, () -> miClave.getColor(6));
    }

    @Test
    void probarQueSiLaClaveTieneMasDeCincoElementosNoCargaLaClave() throws Exception {
        FichaCodificadora[] miCombinacion = {
                FichaCodificadora.ROJO ,
                FichaCodificadora.BLANCO,
                FichaCodificadora.AZUL,
                FichaCodificadora.VERDE,
                FichaCodificadora.NARANJA,
                FichaCodificadora.NARANJA
        };

        miClave = new Clave(miCombinacion);
        assertEquals(null, miClave.getColor(1));


    }

    @Test
    void probarQueSiLaClaveTieneCuatroElementosCargaLaClaveParcialmentePaso1() throws Exception {
        FichaCodificadora[] miCombinacion = {
                FichaCodificadora.ROJO ,
                FichaCodificadora.BLANCO,
                FichaCodificadora.AZUL,
                FichaCodificadora.VERDE
        };

        miClave = new Clave(miCombinacion);
        assertEquals(FichaCodificadora.ROJO, miClave.getColor(1));
    }


    @Test
    void probarQueSiLaClaveTieneCuatroElementosCargaLaClaveParcialmentePaso2() throws Exception {
        FichaCodificadora[] miCombinacion = {
                FichaCodificadora.ROJO ,
                FichaCodificadora.BLANCO,
                FichaCodificadora.AZUL,
                FichaCodificadora.VERDE
        };

        miClave = new Clave(miCombinacion);
        assertEquals(null, miClave.getColor(5));
    }

    @Test
    void CargarManualmenteUnColorEsPosible() throws Exception {

        miClave.setColor(FichaCodificadora.VERDE, 1);
        assertEquals(FichaCodificadora.VERDE, miClave.getColor(1));

    }

    @Test
    void CargarManualmenteFueraDeRangoDaErrorCero(){
        assertThrows(Exception.class, () -> miClave.setColor(FichaCodificadora.VERDE, 0));
    }

    @Test
    void CargarManualmenteFueraDeRangoDaErrorSeis(){
        assertThrows(Exception.class, () -> miClave.setColor(FichaCodificadora.VERDE, 6));
    }

    @Test
    void CargarMenosDeCincoElementosDevuelveClaveNoCompleta() {

        FichaCodificadora[] miCombinacion = {
                FichaCodificadora.ROJO ,
                FichaCodificadora.BLANCO,
                FichaCodificadora.AZUL,
                FichaCodificadora.VERDE
        };

        miClave = new Clave(miCombinacion);

        assertFalse(miClave.isCompleta());

    }

    @Test
    void CargarCincoElementosDevuelveClaveCompleta() {
        assertTrue(miClave.isCompleta());
    }

    @Test
    void CargarTresElementosDevuelveClaveNoCompleta() throws Exception {

        miClave = new Clave();
        miClave.setColor(FichaCodificadora.AMARILLO, 1);
        miClave.setColor(FichaCodificadora.AZUL, 3);
        miClave.setColor(FichaCodificadora.VERDE, 5);
        assertFalse(miClave.isCompleta());
    }
}

