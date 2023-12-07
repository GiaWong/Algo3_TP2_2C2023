package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Movimiento.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapaTest {

    @Test
    public void test01UnGladiadorSeMueveDosCasillasDeCamino(){

        Mapa mapa = new Mapa();
        mapa.mapaReal();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 7);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,7, direccion);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());


        int posicionEnxEsperada = 2;
        int posicionEnyEsperada = 7 ;
        assertEquals(posicionEnxEsperada, unGladiador.obetenerPosicionEnX());
        assertEquals(posicionEnyEsperada,unGladiador.obetenerPosicionEnY());


    }


    /*
    @Test
    public void Test19SimulamosYVerificamosQueElJugadorGane() {

        Mapa mapa = new Mapa();
        mapa.mapaReal();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(5),unCamino);
        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int posicionEsperada = 5;
        assertEquals(posicionEsperada, unGladiador.obtenerPosicionEnCamino());

    }
    */
}
