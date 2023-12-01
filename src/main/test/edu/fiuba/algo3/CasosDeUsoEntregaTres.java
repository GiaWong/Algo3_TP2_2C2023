package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
public class CasosDeUsoEntregaTres {
    @Test
    public void Test19SimulamosYVerificamosQueElJugadorGane() {


        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(5),unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion()));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0,0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        boolean JugadorEsGanador= true;
        assertEquals(JugadorEsGanador, tablero.validarGanador(unGladiador));

    }

    public void Test20SimulamosYVerificamosQueElJugadorPierda() {
    //AUN LO ESTOY CODEANDOS
    }
}*/