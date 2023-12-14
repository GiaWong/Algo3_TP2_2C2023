package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OcupacionesTest {

   @Test
    public void Test01LaListaDeCasillasNoTieneEquipamientosNiPremios() {


       Mapa mapa = new Mapa();
       mapa.mapaTest();
       Casilla[][] unMapa = mapa.obtenerMapa();
       DadoMock dado = new DadoMock();
       List<Casilla> camino = new ArrayList<>();


       Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino, dado);
       Posicion posicion = new Posicion(0, 1);
       Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,1,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"llegada"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar();
        tablero.avanzar();


        int longitudEsperada = 0;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

   @Test
    public void Test02LaListaDeCasillasTieneUnPremioYGladiadorObtieneUnCasco() {

       Mapa mapa = new Mapa();
       mapa.mapaTest();
       Casilla[][] unMapa = mapa.obtenerMapa();
       DadoMock dado = new DadoMock();
       List<Casilla> camino = new ArrayList<>();

       Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino ,dado);
       Posicion posicion = new Posicion(0, 1);
       Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);


        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,4,"llegada"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar();


        int longitudEsperada = 1;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test03LaListaDeCasillasTieneDosPremiosYGladiadorObtieneUnCascoYUnaArmadura() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();


        Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino ,dado);
        Posicion posicion = new Posicion(0, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);


        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,2,"llegada"));



        tablero.agregarJugador(unGladiador);
        tablero.avanzar();


        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test04LaListaDeCasillasTieneTresPremiosYGladiadorObtieneUnCascoUnaArmaduraUnEscudoEspada() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();

        camino.add(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,1,"camino"));
        camino.add(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),1,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));

        Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino ,dado);
        Posicion posicion = new Posicion(0, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);


        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,2,"llegada"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar();
        tablero.avanzar();


        int longitudEsperada = 3;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test05LaListaDeCasillasTieneCuatroPremiosYGladiadorObtieneLaLLave() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();


        Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino ,dado);
        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,2,"llegada"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar();
        tablero.avanzar();


        int longitudEsperada = 4;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());


    }
    @Test
    public void Test06LaListaDeCasillasTieneUnCascoYGladiadorLoGuardaEnElEquipamiento() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();
        camino.add(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new Casco(5),1,1,"camino"));

        Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino ,dado);
        Posicion posicion = new Posicion(0, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new Casco(5),1,1,"camino"));



        tablero.agregarJugador(unGladiador);
        tablero.avanzar();



        int longitudEsperada = 1;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test07LaListaDeCasillasTieneDosEquipamientos() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();
        camino.add(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));


        Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino , dado);
        Posicion posicion = new Posicion(0, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));



        tablero.agregarJugador(unGladiador);
        tablero.avanzar();
        tablero.avanzar();


        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());

    }
    @Test
    public void Test08LaListaDeCasillasTieneTresEquipamientos() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();
        camino.add(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),3,1,"camino"));



        Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino , dado);
        Posicion posicion = new Posicion(0, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),3,1,"camino"));



        tablero.agregarJugador(unGladiador);
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();


        int longitudEsperada = 3;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());

    }
    @Test
    public void Test09LaListaDeCasillasTieneCuatroEquipamientosIncluidoLaLLave() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();
        camino.add(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),3,1,"camino"));
        camino.add(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),4,1,"camino"));


        Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino , dado);
        Posicion posicion = new Posicion(0, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),4,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();


        int longitudEsperada = 4;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

}
