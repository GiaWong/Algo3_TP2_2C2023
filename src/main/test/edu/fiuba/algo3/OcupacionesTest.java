package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Movimiento.Direccion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OcupacionesTest {

   @Test
    public void Test01LaListaDeCasillasNoTieneEquipamientosNiPremios() {


       Mapa mapa = new Mapa();
       mapa.mapaTest();
       Casilla[][] unMapa = mapa.obtenerMapa();

       Tablero tablero = new Tablero(1, new Turno(30),unMapa);
       Direccion direccion = new Direccion(1, 1);
       Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"camino"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 0;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

   @Test
    public void Test02LaListaDeCasillasTieneUnPremioYGladiadorObtieneUnCasco() {

       Mapa mapa = new Mapa();
       mapa.mapaTest();
       Casilla[][] unMapa = mapa.obtenerMapa();

       Tablero tablero = new Tablero(1, new Turno(30),unMapa);
       Direccion direccion = new Direccion(1, 1);
       Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),5,1,"camino"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 1;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test03LaListaDeCasillasTieneDosPremiosYGladiadorObtieneUnCascoYUnaArmadura() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);


        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),5,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),6,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),7,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),8,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test04LaListaDeCasillasTieneTresPremiosYGladiadorObtieneUnCascoUnaArmaduraUnEscudoEspada() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);


        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),5,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),6,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),7,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),8,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),9,1,"camino"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 3;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test05LaListaDeCasillasTieneCuatroPremiosYGladiadorObtieneLaLLave() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),5,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),6,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),7,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),8,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),9,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),10,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int longitudEsperada = 4;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());


    }
    @Test
    public void Test06LaListaDeCasillasTieneUnCascoYGladiadorLoGuardaEnElEquipamiento() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new Casco(5),new NadaOcupacion(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),5,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),6,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 1;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test07LaListaDeCasillasTieneDosEquipamientos() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());

    }
    @Test
    public void Test08LaListaDeCasillasTieneTresEquipamientos() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),3,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 3;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());

    }
    @Test
    public void Test09LaListaDeCasillasTieneCuatroEquipamientosIncluidoLaLLave() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),4,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),5,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 4;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
   @Test
    public void Test10LaListaDeCasillasTieneUnCascoYUnPremioYGladiadorGuardaDosEquipamientos() {

       Mapa mapa = new Mapa();
       mapa.mapaTest();
       Casilla[][] unMapa = mapa.obtenerMapa();

       Tablero tablero = new Tablero(1, new Turno(30),unMapa);
       Direccion direccion = new Direccion(1, 1);
       Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

       //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),3,1,"camino"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
   @Test
    public void Test11LaListaDeCasillasTieneUnCascoYDosPremiosYGladiadorGuardaTresEquipamientos() {


       Mapa mapa = new Mapa();
       mapa.mapaTest();
       Casilla[][] unMapa = mapa.obtenerMapa();

       Tablero tablero = new Tablero(1, new Turno(30),unMapa);
       Direccion direccion = new Direccion(1, 1);
       Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

       //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
       tablero.agregarCasillaAlMapa(new Casilla(new Casco(3),new NadaOcupacion(),1,1,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,1,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),3,1,"camino"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 3;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test12LaListaDeCasillasTieneUnCascoYTresPremiosYGladiadorGuardaCuatroEquipamientos() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new Casco(4),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),4,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 4;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test13LaListaDeCasillasTieneUnPremioYUnCascoYGladiadorGuardaUnEquipamiento() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new Casco(5),2,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 1;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test14LaListaDeCasillasTieneDosPremiosYUnaArmaduraYGladiadorGuardaDosEquipamientos() {


        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new Armadura(5),new NadaOcupacion(),3,1,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test15LaListaDeCasillasTieneTresPremiosYUnaArmaduraYGladiadorGuardaTresEquipamientos() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),3,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new Armadura(5),new NadaOcupacion(),4,1,"camino"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 3;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

}
