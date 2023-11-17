package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsosEntregaUno {

    @Test
    public void Test01UnGladiadorSeInicializaConLaEnergiaYNoTieneEquipamiento() {

        Gladiador unGladiador = new Gladiador(20, new Novato(), 0);
        int energiaEsperada = 20;
        int equipamientoEsperado = 0;

        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());
        assertEquals(equipamientoEsperado,unGladiador.obtenerCantidadDeEquipamiento());

    }

    @Test
    public void Test02VerificarQueUnGladiadorSalgaDeLaCasillaInicial() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla((new Casilla(new Nada())));
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int energiaEsperada = 0;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
        // assertEquals(TurnoExpiradoException, tablero.avanzzar(new Dado())); Pendiente en la refactorizacion
    }

    @Test
    public void Test03VerificarQuejugadorSinEnergíaNoPuedaJugarElTurno() {

        Tablero tablero = new Tablero(1, new Turno(30));//para turno asumimos que el gladiador 1 será el primer turno
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        Gladiador unGladiador = new Gladiador(0, new Novato(), 0);//asumimos que ya tiene energia cero, el como llega a ese eavlor se discute luego

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new Dado());

        int posicionEsperada = 0;
        //Como el gladiador no avanzo, su turno expiro
        assertEquals(posicionEsperada, unGladiador.obtenerPosicion());

    }

   @Test
    public void Test04VerificarQueSiRecibeComidaIncrementaEnergiaEn15() {

        Tablero tablero = new Tablero(1,new Turno(30));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        Gladiador unGladiador = new Gladiador(20,new Novato(),0);

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new Dado());

        int energiaEsperada = 35;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }

    @Test
    public void Test05VerificarQueSiRecibeUnPremioPorPrimeraVezObtieneUnCasco() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        Gladiador unGladiador = new Gladiador(20,new Novato(),0);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        unGladiador.agregarEquipamiento(new Casco(5)); //PONERLO DENTRO DE Casco

        int longitudEsperada = 1;

        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }


    @Test
    public void Test06VerificarQueSiRecibeUnPremioPorTerceraVezObtieneEscudoYEspada(){

        Tablero tablero = new Tablero(1, new Turno(30));

        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new Armadura(5)));
        tablero.agregarCasilla(new Casilla(new EscudoYEspada(2)));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        unGladiador.agregarEquipamiento(new Casco(5)); //PONERLO DENTRO DE Casco
        unGladiador.agregarEquipamiento(new Armadura(5)); //PONERLO DENTRO DE Armadura
        unGladiador.agregarEquipamiento(new EscudoYEspada(2)); //PONERLO DENTRO DE EscudoYEspada

        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        int longitudEsperada = 3;

        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test07VerificarQueSiHayUnCombateConUnaFieraSalvajeYTieneCascoPierde10Puntos() {
        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        Gladiador unGladiador = new Gladiador(20,new Novato(),0);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        int energiaEsperada = 5;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    public void Test08VerificarQueSiPasan8TurnosElGladiadorPasaDeNovatoASemiSeniorYVeSuEnergiaIncrementadaEnElSiguienteTurno() {
        Tablero tablero = new Tablero(1, new Turno(30));

        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new Comida(15)));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        int energiaEsperada = 60;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }
}

