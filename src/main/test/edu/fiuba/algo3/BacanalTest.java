package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Mapa;
import edu.fiuba.algo3.Modelo.Obstaculos.Bacanal;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import edu.fiuba.algo3.Movimiento.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BacanalTest {

    @Test
    public void Test01SiUnGladiadorAsisteAUnBacanalYToma1TradoPierdeCiertaEnergia() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new Bacanal(),new NadaOcupacion(),1,2,"CAMINO"));

        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());

        int energiaEsperada =16;
        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());


    }

    @Test
    public void Test02SiUnGladiadorAsisteAUnBacanalDosVecesYToma1TragoEnCadaUnaPierdeCiertaEnergia() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new Bacanal(),new Bacanal(),1,2,"CAMINO"));

        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());

        int energiaEsperada =12;
        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());

    }



}
