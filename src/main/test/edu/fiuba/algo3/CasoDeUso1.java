package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1 {

    @Test
    public void UnGladiadorSeInicializaConLaEnergiaYNoTieneEquipamiento() {
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0);
        //act
        int energiaEsperada = 20;
        int equipamientoEsperado = 0;

        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());
        assertEquals(equipamientoEsperado,unGladiador.obtenerEquipamiento());

    }

    @Test
    public void VerificarQueUnGladiadorSalgaDeLaCasillaInicial() {
        Tablero tablero = new Tablero(1, new Casilla(new FieraSalvaje()),new Turno(30));
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());//ahi adntro hará todas las modificaciones de las energias

        int energiaEsperada = 0;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
        // assertEquals(TurnoExpiradoException, tablero.avanzzar(new Dado())); Pendiente en la refactorizacion


    }

    @Test
    public void VerificarQuejugadorSinEnergíaNoPuedaJugarElTurno() {

        Tablero tablero = new Tablero(1, new Casilla(new FieraSalvaje()), new Turno(30));//para turno asumimos que el gladiador 1 será el primer turno
        Gladiador unGladiador = new Gladiador(0, new Novato(), 0);//asumimos que ya tiene energia cero, el como llega a ese eavlor se discute luego

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new Dado());

        int posicionEsperada = 0;
        //Como el gladiador no avanzo, su turno expiro
        assertEquals(posicionEsperada, unGladiador.obtenerPosicion());

    }

|    @Test
    public void VerificarQueSiRecibeComidaIncrementaEnergiaEn15() {

        Tablero tablero = new Tablero(1,new Casilla(new Comida(15)),new Turno(30));
        Gladiador unGladiador = new Gladiador(20,new Novato(),0);

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new Dado());

        int energiaEsperada = 35;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }
}

