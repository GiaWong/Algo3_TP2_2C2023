package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Mapa;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Obstaculos.Bacanal;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BacanalTest {

    @Test
    public void Test01SiUnGladiadorAsisteAUnBacanalYToma1TradoPierdeCiertaEnergia() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        DadoMock dado = new DadoMock();
        Casilla[][] unMapa = mapa.obtenerMapa();

        List<Casilla> camino= new ArrayList<Casilla>();
        camino.add(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"CAMINO"));
        camino.add(new Casilla(new Bacanal(),new NadaOcupacion(),1,2,"CAMINO"));

        Tablero tablero = new Tablero(1, new Turno(30), unMapa,camino, dado);
        tablero.agregarCasillaAlMapa(new Casilla(new Bacanal(),new NadaOcupacion(),1,2,"CAMINO"));

        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar();

        int energiaEsperada =16;
        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());


    }

    @Test
    public void Test02SiUnGladiadorAsisteAUnBacanalDosVecesYToma1TragoEnCadaUnaPierdeCiertaEnergia() {

        Mapa mapa = new Mapa();
        DadoMock dado = new DadoMock();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        List<Casilla> camino = new ArrayList<Casilla>();
        camino.add(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"CAMINO"));
        camino.add(new Casilla(new Bacanal(),new Bacanal(),1,2,"CAMINO"));

        Tablero tablero = new Tablero(1, new Turno(30), unMapa,camino ,dado);
        tablero.agregarCasillaAlMapa(new Casilla(new Bacanal(),new Bacanal(),1,2,"CAMINO"));

        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar();

        int energiaEsperada =12;
        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());

    }



}
