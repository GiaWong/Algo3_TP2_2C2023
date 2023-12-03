package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Movimiento.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoEntregaTres {
    @Test/*
    public void Test19SimulamosYVerificamosQueElJugadorGane() {
//ESTE TESTA YA ESTA, SOLO QUE VALIDARGANADOR() NO ESTA FUNCIONANDO
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Direccion direccion = new Direccion(1,1);
        Dado dado = new DadoMock();

        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),2,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),3,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),4,1,"CAMINO"));


        Gladiador unGladiador = new Gladiador(20,new Novato(),1,1, direccion);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);

        boolean JugadorEsGanador= true;
        assertEquals(JugadorEsGanador, tablero.validarGanador(unGladiador));

    }

    public void Test20SimulamosYVerificamosQueElJugadorPierda() {
    //AUN LO ESTOY CODEANDOS
    }
}*/