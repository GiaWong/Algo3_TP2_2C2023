package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.Dado;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Premios.Comida;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Movimiento.Direccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsosEntregaUno {

    @Test
    public void Test01UnGladiadorSeInicializaConLaEnergiaYNoTieneEquipamiento() {
         Mapa mapa = new Mapa();
         mapa.mapaTest();
         Casilla[][] unMapa = mapa.obtenerMapa();
         Direccion direccion = new Direccion(1,1);

        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

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

        Direccion direccion = new Direccion(1,1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),1,2,"CAMINO"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());

        int posicionEnYEsperada = 2;
        assertEquals(posicionEnYEsperada, unGladiador.obetenerPosicionEnY());

    }

    @Test
    public void Test03VerificarQuejugadorSinEnergiaNoPuedaJugarElTurno() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Direccion direccion = new Direccion(1,1);
         Gladiador unGladiador = new Gladiador(0, new Novato(), 1,1,direccion);

        Tablero tablero = new Tablero(1, new Turno(30),unMapa);


        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());

        int posicionEsperadaEnX = 1;
         int posicionEsperadaEnY = 1;
        assertEquals(posicionEsperadaEnX, unGladiador.obetenerPosicionEnX());
         assertEquals(posicionEsperadaEnY, unGladiador.obetenerPosicionEnY());


    }

   @Test
    public void Test04VerificarQueSiRecibeComidaIncrementaEnergiaEn15() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Direccion direccion = new Direccion(1,1);
        Gladiador unGladiador = new Gladiador(20,new Novato(),1,1,direccion);

        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new Comida(15),new NadaOcupacion(),1,2,"CAMINO"));


        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());


        int energiaEsperada = 35;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }

    @Test
    public void Test05VerificarQueSiRecibeUnPremioPorPrimeraVezObtieneUnCasco() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Direccion direccion = new Direccion(1,1);
        Gladiador unGladiador = new Gladiador(20,new Novato(),1,1,direccion);
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,1,"CAMINO"));


        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        int longitudEsperada = 1;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }



    @Test
    public void Test06VerificarQueSiRecibeUnPremioPorTerceraVezObtieneEscudoYEspada(){

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Direccion direccion = new Direccion(1,1);
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,2,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,3,"camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),1,4,"camino"));

        Gladiador unGladiador = new Gladiador(20,new Novato(),1,1, direccion);
        tablero.agregarJugador(unGladiador);


        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());


        int longitudEsperada = 3;

        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());

    }

    @Test
    public void Test07VerificarQueSiHayUnCombateConUnaFieraSalvajeYTieneCascoPierde15Puntos() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Direccion direccion = new Direccion(1,1);
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new FieraSalvaje(20),new PremioEquipamiento(),1,2,"CAMINO"));


        Gladiador unGladiador = new Gladiador(20,new Novato(),1,1, direccion);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());


        int energiaEsperada = 5;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());


    }

    @Test
    public void Test08VerificarQueSiPasan8TurnosElGladiadorPasaDeNovatoASemiSeniorYVeSuEnergiaIncrementadaEnElSiguienteTurno() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Direccion direccion = new Direccion(1,1);

        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        Dado dado = new DadoMock();

        Gladiador unGladiador = new Gladiador(20,new Novato(),1,1, direccion);
        tablero.agregarJugador(unGladiador);

         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),5,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),6,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),7,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),8,1,"CAMINO"));
         tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),9,1,"CAMINO"));



        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);

        int energiaEsperada1 = 20;
        assertEquals(energiaEsperada1, unGladiador.obtenerEnergia());

        tablero.avanzar(dado);

        //Tuvo otro turno, se sube el rango del seniority y aumenta a 25
        int energiaEsperada = 25;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    //Hay que repensar los metodos
    /*
    @Test
    public void Test09UnGladiadorLLegaALaMetaSinLaLLaveYEsteRetrocedeHastaLaMitadDeLasCasillas() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int posicionEsperada = 1;
        assertEquals(posicionEsperada, unGladiador.obtenerPosicion());

    }
     */
    @Test
    public void Test10UnGladiadorConTodosSusEquipamientosEsAtacadoPorUnaFieraSalvajeLaEnergiaNoSeModifica() {

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Direccion direccion = new Direccion(1,1);
        Tablero tablero = new Tablero(1,new Turno(30),unMapa);
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),2,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new PremioEquipamiento(),3,1,"CAMINO"));


        tablero.agregarCasillaAlMapa(new Casilla(new FieraSalvaje(20),new NadaOcupacion(),4,1,"CAMINO"));
        Dado dado = new DadoMock();
        Gladiador unGladiador = new Gladiador(20,new Novato(),1,1, direccion);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);

        int energiaEsperada1 = 20;
        assertEquals(energiaEsperada1, unGladiador.obtenerEnergia());



    }

    @Test
    public void Test11UnGladiadorTieneLaLLaveY1da() {

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

        int cantidadDeEquipamientoEsperado = 4;
        assertEquals(cantidadDeEquipamientoEsperado, unGladiador.obtenerCantidadDeEquipamiento());
    }
    /*
    @Test
    public void Test12GladiadorNoLLegaALaMetaAlPasarTreintaTurnosElJuegoSeTermina() {
        Tablero tablero = new Tablero(1, new Turno(30));
        DadoMock dado = new DadoMock();
        for (int i=1 ; i <33 ;i++){
            tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        }

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        for (int i=1 ; i <31 ;i++){
            tablero.avanzar(dado);
        }


        boolean juegoTerminado= true;
        assertEquals(juegoTerminado, tablero.FinalizarJuego());
    }*/

}

