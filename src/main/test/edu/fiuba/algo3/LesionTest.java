package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Obstaculos.Lesion;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Movimiento.Direccion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LesionTest {
    @Test
    public void Test01UnJugadorLesionadoNoPuedeJugarElSiguienteTurno() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new Lesion(), 3, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 4, 1, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int posicionEnXEsperada = 3;
        int posicionEnYEsperada = 1 ;
        assertEquals(posicionEnXEsperada, unGladiador.obetenerPosicionEnX());
        assertEquals(posicionEnYEsperada,unGladiador.obetenerPosicionEnY());
    }
}
