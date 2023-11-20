package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Equipamientos.Armadura;
import edu.fiuba.algo3.Modelo.Equipamientos.Casco;
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


        tablero.avanzar(new Dado());

        int posicionEsperada = 1;

        assertEquals(posicionEsperada, gladiador.obtenerPosicion());
    }
    @Test
    public void test02UnGladiadorCombateConUnaFieraSalVajeSinEquipamiento(){

        Tablero tablero = new Tablero(1,new Turno(30));
        Gladiador gladiador = new Gladiador(20, new Novato(), 0);
        tablero.agregarJugador(gladiador);
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));

        tablero.avanzar(new Dado());

        int energiaEsperada = 0;

        assertEquals(energiaEsperada, gladiador.obtenerEnergia());

    }

    @Test
    void test03UnGladiadorCombateConUnaFieraConUnCascoYArmadura(){
        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new Armadura(5)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        Dado dado = new Dado();
        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);

        int energiaEsperada = 10;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }
}
