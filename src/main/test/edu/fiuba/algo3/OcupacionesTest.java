package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OcupacionesTest {

  /*  @Test
    public void Test01LaListaDeCasillasNoTieneEquipamientosNiPremios() {


       Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);


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
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);


        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,0,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,4,"camino"));

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
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,0,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,4,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,5,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,6,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,7,"camino"));


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
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,0,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,4,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,5,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,6,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,7,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,8,"camino"));

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
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,0,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,4,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,5,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,6,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,7,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,8,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,9,"camino"));


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
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,0,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new Casco(5),new NadaOcupacion(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,4,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,5,"camino"));


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
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,3,"camino"));



        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
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
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);


        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,5,"camino"));



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
    public void Test09LaListaDeCasillasTieneCuatroEquipamientosIncluidoLaLLave() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,4,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,5,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,6,"camino"));


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
       Tablero tablero = new Tablero(1,new Turno(30),unMapa);
       Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

       //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,2,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,3,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,4,"camino"));

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
       Tablero tablero = new Tablero(1,new Turno(30),unMapa);
       Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

       //Maximo de agregarCasilla 10 porque el mapa tiene ancho 10 como limite
       tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,2,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,4,"camino"));
       tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,5,"camino"));



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
    public void Test12LaListaDeCasillasTieneUnCascoYTresPremiosYGladiadorGuardaCuatroEquipamientos() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),0,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),0,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,5,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,8,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
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
    public void Test13LaListaDeCasillasTieneUnPremioYUnCascoYGladiadorGuardaUnEquipamiento() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new PremioEquipamiento(),0,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new Casco(5),0,3,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
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
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,0,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,4,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new Armadura(5),new NadaOcupacion(),0,5,"camino"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
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
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 0,0, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,0,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),0,2,"camino"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int longitudEsperada = 3;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }*/

}
