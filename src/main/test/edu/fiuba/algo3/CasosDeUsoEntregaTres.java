package edu.fiuba.algo3;


import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.Dado;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Mapa;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Tablero;
import edu.fiuba.algo3.Modelo.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsoEntregaTres {
    @Test
    public void Test19SimulamosYVerificamosQueElJugadorGane() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(2, 7);
        Dado dado = new DadoMock();
        List<Casilla> camino = new ArrayList<Casilla>();
        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino ,dado);



        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,7,"Camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(),2,6,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,5,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),2,4,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),2,3,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,2,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),5,1,"LLegada"));

        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();


        int coordenadaX= 5;
        int coordenadaY= 1;
        assertEquals(coordenadaX, unGladiador.obtenerPosicionEnX());
        assertEquals(coordenadaY, unGladiador.obtenerPosicionEnY());

    }

    @Test
    public void Test20UnGladiadorLLegaALaMetaSinLaLLaveYEsteRetrocedeHastaLaMitadDeLasCasillas() {


        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(1, 7);
        Dado dado = new DadoMock();
        List<Casilla> camino = new ArrayList<Casilla>();

        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino ,dado);

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,6,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,5,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,4,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,3,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,2,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),5,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),6,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),7,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),8,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),9,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),10,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),11,1,"LLegada"));


        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        tablero.agregarJugador(unGladiador);

        for(int i=0; i < 16; i ++){

            tablero.avanzar();
        }


        int posicionEsperadaEnX = 3;
        int posicionEsperadaEnY = 1;
        assertEquals(posicionEsperadaEnX, unGladiador.obtenerPosicionEnX());
        assertEquals(posicionEsperadaEnY, unGladiador.obtenerPosicionEnY());

    }

    public void Test20SimulamosYVerificamosQueElJugadorPierda() {
    //AUN LO ESTOY CODEANDOS
    }



}