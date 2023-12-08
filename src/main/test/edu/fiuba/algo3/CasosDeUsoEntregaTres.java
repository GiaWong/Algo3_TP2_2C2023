package edu.fiuba.algo3;


import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.Dado;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Mapa;
import edu.fiuba.algo3.Modelo.Movimiento.Direccion;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoEntregaTres {
    @Test
    public void Test19SimulamosYVerificamosQueElJugadorGane() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Direccion direccion = new Direccion(1,1);
        Dado dado = new DadoMock();

        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),2,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),3,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),4,1,"LLEGDA"));

        Gladiador unGladiador = new Gladiador(20,new Novato(),1,1, direccion);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);

        int coordenadaX= 4;
        int coordenadaY= 1;
        assertEquals(coordenadaX, unGladiador.obtenerPosicionEnX());
        assertEquals(coordenadaY, unGladiador.obtenerPosicionEnY());
        //
    }

    public void Test20SimulamosYVerificamosQueElJugadorPierda() {
    //AUN LO ESTOY CODEANDOS
    }
}