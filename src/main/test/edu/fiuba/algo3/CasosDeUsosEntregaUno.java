package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.Dado;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Premios.Comida;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsosEntregaUno {

    @Test
    public void Test01UnGladiadorSeInicializaConLaEnergiaYNoTieneEquipamiento() {
         Mapa mapa = new Mapa();
         mapa.mapaTest();
         Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(1, 1);

        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);

        int energiaEsperada = 20;
        int equipamientoEsperado = 0;

        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());
        assertEquals(equipamientoEsperado,unGladiador.obtenerCantidadDeEquipamiento());

    }

    @Test
    public void Test02VerificarQueUnGladiadorSalgaDeLaCasillaInicial() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();

        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), posicion);
        Tablero tablero = new Tablero(1, new Turno(30),unMapa,camino,dado);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,2,"CAMINO"));

        tablero.agregarJugador(unGladiador);
        tablero.avanzar();

        int posicionEnYEsperada = 2;
        assertEquals(posicionEnYEsperada, unGladiador.obtenerPosicionEnY());

    }

    @Test
    public void Test03VerificarQuejugadorSinEnergiaNoPuedaJugarElTurno() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();

        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador(0, new Novato(), posicion);

        Tablero tablero = new Tablero(1, new Turno(30),unMapa, camino,dado);

        tablero.agregarJugador(unGladiador);

        tablero.avanzar();

        int posicionEsperadaEnX = 1;
        int posicionEsperadaEnY = 1;
        assertEquals(posicionEsperadaEnX, unGladiador.obtenerPosicionEnX());
        assertEquals(posicionEsperadaEnY, unGladiador.obtenerPosicionEnY());


    }

   @Test
    public void Test04VerificarQueSiRecibeComidaIncrementaEnergiaEn15() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();

        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        List<Casilla> camino = new ArrayList<>();

        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);

        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino,dado);

        tablero.agregarCasillaAlMapa(new Casilla(new Comida(15),new NadaOcupacion(),1,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new Comida(15),new NadaOcupacion(),1,2,"CAMINO"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar();


        int energiaEsperada = 35;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }

    @Test
    public void Test05VerificarQueSiRecibeUnPremioPorPrimeraVezObtieneUnCasco() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();


        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino,dado);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,1,"CAMINO"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar();

        int longitudEsperada = 1;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }



    @Test
    public void Test06VerificarQueSiRecibeUnPremioPorTerceraVezObtieneEscudoYEspada(){

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();

        Posicion posicion = new Posicion(1, 1);
        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino, dado);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,4,"camino"));

        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        tablero.agregarJugador(unGladiador);


        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();


        int longitudEsperada = 3;

        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());

    }

    @Test
    public void Test07VerificarQueSiHayUnCombateConUnaFieraSalvajeYTieneCascoPierde15Puntos() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();

        Posicion posicion = new Posicion(1, 1);
        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino ,dado);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new FieraSalvaje(20),new PremioEquipamiento(),1,2,"CAMINO"));


        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar();


        int energiaEsperada = 5;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());


    }

    @Test
    public void Test08VerificarQueSiPasan8TurnosElGladiadorPasaDeNovatoASemiSeniorYVeSuEnergiaIncrementadaEnElSiguienteTurno() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(1, 1);
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();
        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino , dado);

        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        tablero.agregarJugador(unGladiador);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"CAMINO"));

         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),5,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),6,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),7,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),8,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),9,1,"CAMINO"));

        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();



        int energiaEsperada1 = 20;
        assertEquals(energiaEsperada1, unGladiador.obtenerEnergia());

        tablero.avanzar();

        //Tuvo otro turno, se sube el rango del seniority y aumenta a 25
        int energiaEsperada = 25;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    //Este test no hace nada, como llega sin todo el equipamiento tendria que volver a la mitad del camino

    @Test
    public void Test09UnGladiadorLLegaALaMetaSinLaLLaveYEsteRetrocedeHastaLaMitadDeLasCasillas() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(17, 2);
        Dado dado = new DadoMock();

        Tablero tablero = new Tablero(1,new Turno(5),unMapa,mapa.obtenereCamino() , dado);
        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar();


        int posicionEsperadaEnX = 17;
        int posicionEsperadaEnY = 1;
        assertEquals(posicionEsperadaEnX, unGladiador.obtenerPosicionEnX());
        assertEquals(posicionEsperadaEnY, unGladiador.obtenerPosicionEnY());

    }

    @Test
    public void Test10UnGladiadorConTodosSusEquipamientosEsAtacadoPorUnaFieraSalvajeLaEnergiaNoSeModifica() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();

        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(1, 1);
        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino , dado);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"CAMINO"));

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),2,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),3,1,"CAMINO"));


        tablero.agregarCasillaAlMapa(new Casilla(new FieraSalvaje(20),new NadaOcupacion(),4,1,"CAMINO"));


        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();

        int energiaEsperada1 = 20;
        assertEquals(energiaEsperada1, unGladiador.obtenerEnergia());



    }

    @Test
    public void Test11UnGladiadorTieneLaLLaveYRecibeOtroPremioNoCambianada() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(1, 1);
        Dado dado = new DadoMock();
        List<Casilla> camino = new ArrayList<>();

        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino , dado);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,1,"CAMINO"));

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),2,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),3,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),4,1,"CAMINO"));

        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();

        int cantidadDeEquipamientoEsperado = 4;
        assertEquals(cantidadDeEquipamientoEsperado, unGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test12GladiadorNoLLegaALaMetaAlPasarTreintaTurnosElJuegoSeTermina() {



        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(1, 7);
        Dado dado = new DadoMock();
        List<Casilla> camino = new ArrayList<Casilla>();

        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino ,dado);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,6,"CAMINO"));
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
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),11,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),12,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),12,2,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),12,3,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),12,4,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),12,5,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),12,6,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),12,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),12,8,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),12,9,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),13,9,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),14,9,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),15,9,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),16,9,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),17,9,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),17,8,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),17,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),17,6,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),17,5,"LLEGADA"));


        Gladiador unGladiador = new Gladiador(20,new Novato(),posicion);
        tablero.agregarJugador(unGladiador);

        for (int i = 1; i <= 30; i++) {
            tablero.avanzar();
        }

        boolean juegoTerminado= true;
        assertEquals(juegoTerminado, tablero.FinalizarJuego());

    }



}

