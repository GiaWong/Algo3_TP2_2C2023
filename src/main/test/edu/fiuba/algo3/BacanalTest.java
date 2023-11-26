package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Obstaculos.Bacanal;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BacanalTest {

    @Test
    public void Test01SiUnGladiadorAsisteAUnBacanalYToma1TradoPierdeCiertaEnergia() {

        Tablero tablero = new Tablero(1, new Turno(30));

        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new Bacanal()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 16;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }
    @Test
    public void Test02SiUnGladiadorAsisteAUnBacanalDosVecesYToma1TragoEnCadaUnaPierdeCiertaEnergia() {

        Tablero tablero = new Tablero(1, new Turno(30));

        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new Bacanal()));
        tablero.agregarCasilla(new Casilla(new Bacanal()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 12;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

}
