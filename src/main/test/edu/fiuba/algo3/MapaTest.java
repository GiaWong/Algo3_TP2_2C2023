package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapaTest {

    @Test
    public void test01UnGladiadorSeMueveUnaCasillasDeCamino(){

        Mapa mapa = new Mapa();
        mapa.mapaReal();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa,mapa.obtenereCamino() ,dado);
        Posicion posicion = new Posicion(1, 7);
        Gladiador unGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar();


        int posicionEnxEsperada = 2;
        int posicionEnyEsperada = 7 ;
        assertEquals(posicionEnxEsperada, unGladiador.obtenerPosicionEnX());
        assertEquals(posicionEnyEsperada,unGladiador.obtenerPosicionEnY());


    }

}
