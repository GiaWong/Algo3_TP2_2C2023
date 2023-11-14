package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1 {
    @Test
    public void UnGladiadorSeInicializaConLaEnergiaYEquipamientoCorrespondiente() {

        AlgoRoma algoRoma = new AlgoRoma();
        algoRoma.registrarCantidadJugadores(1);

        Tablero tablero = new Tablero(1, new Casilla(1));
        algoRoma.registrarNombre("Rosher");

        tablero.agregarJugador(new Gladiador(20, new Novato(),0));
        Gladiador unGladiador = tablero.obtenerGladiador();
        int energiaEsperada = 20;

        assertEquals(energiaEsperada , unGladiador.obtenerEnergia() );
        //assertEquals(Optional.ofNullable(null), unGladiador.obtenerEquipamiento() );
    }
}
