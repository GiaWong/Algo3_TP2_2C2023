package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GladiadorTest {


    @Test
    public void test01UnGladiadorAvanzaUnaPosicionDespuesDeArrojarLosDados(){

        Tablero tablero = new Tablero(1,new Turno(30));
        Gladiador gladiador = new Gladiador(20, new Novato(), 0);
        tablero.agregarJugador(gladiador);

        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        tablero.avanzar(new DadoMock());

        int posicionEsperada = 1;

        assertEquals(posicionEsperada, gladiador.obtenerPosicion());
    }
    @Test
    public void test02UnGladiadorCombateConUnaFieraSalVajeSinEquipamiento(){

        Tablero tablero = new Tablero(1,new Turno(30));
        Gladiador gladiador = new Gladiador(20, new Novato(), 0);
        tablero.agregarJugador(gladiador);
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 0;

        assertEquals(energiaEsperada, gladiador.obtenerEnergia());

    }

    @Test
    void test03UnGladiadorCombateConUnaFieraConUnCascoYArmadura(){

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        Dado dado = new DadoMock();
        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);

        int energiaEsperada = 10;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    public void Test04SiUnGladiadorRecibeUnPremioPorSegundaVezObtieneUnaArmadura() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test05SiUnGladiadorRecibeUnPremioPorCuartaVezObtieneUnaLlave() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla (new LLave()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int longitudEsperada = 4;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

}
