package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.Dado;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Obstaculos.Bacanal;
import edu.fiuba.algo3.Modelo.Obstaculos.Lesion;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LesionTest {
    @Test
    public void Test01UnJugadorLesionadoNoPuedeJugarElSiguienteTurno() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        List<Casilla> camino= new ArrayList<Casilla>();
        camino.add(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"CAMINO"));
        camino.add(new Casilla(new NadaOcupacion(),new Lesion(),2,1,"CAMINO"));


        Tablero tablero = new Tablero(1, new Turno(30), unMapa,camino ,dado);
        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new Lesion(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 4, 1, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar();
        tablero.avanzar();

        int posicionEnXEsperada = 2;
        int posicionEnYEsperada = 1 ;
        assertEquals(posicionEnXEsperada, unGladiador.obtenerPosicionEnX());
        assertEquals(posicionEnYEsperada,unGladiador.obtenerPosicionEnY());
    }
}
