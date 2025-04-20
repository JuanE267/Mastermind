package unlu.poo.mastermind.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unlu.poo.mastermind.juego.Clave;
import unlu.poo.mastermind.juego.ClaveSecreta;
import unlu.poo.mastermind.juego.FichaCodificadora;
import unlu.poo.mastermind.juego.FichaResultado;

import static org.junit.jupiter.api.Assertions.*;

class TestClaveSecreta {

    ClaveSecreta miClave;

    @BeforeEach
    void setUp() {
        miClave = new ClaveSecreta();
    }

    @Test
    void probarQueAlCrearInstanciaHayCombinacion() throws Exception {
        assertTrue(miClave.isCompleta());
    }

    @Test
    void probarEvaluaciondDeClave_Paso1() throws Exception {
        Clave claveAProbar = new Clave();
        claveAProbar.setColor(FichaCodificadora.ROJO, 1);
        claveAProbar.setColor(FichaCodificadora.AZUL, 2);
        claveAProbar.setColor(FichaCodificadora.ROJO, 3);
        claveAProbar.setColor(FichaCodificadora.ROJO, 4);
        claveAProbar.setColor(FichaCodificadora.VIOLETA, 5);
        miClave.setColor(FichaCodificadora.ROJO, 1);
        miClave.setColor(FichaCodificadora.BLANCO, 2);
        miClave.setColor(FichaCodificadora.ROJO, 3);
        miClave.setColor(FichaCodificadora.AZUL, 4);
        miClave.setColor(FichaCodificadora.VERDE, 5);
        FichaResultado[] miResultado = miClave.comparar(claveAProbar);

        assertEquals(FichaResultado.MALA, miResultado[0]);
        assertEquals(FichaResultado.MALA, miResultado[1]);
        assertEquals(FichaResultado.MALA, miResultado[2]);
        assertEquals(FichaResultado.BUENA, miResultado[3]);
        assertEquals(FichaResultado.REGULAR, miResultado[4]);
    }
}