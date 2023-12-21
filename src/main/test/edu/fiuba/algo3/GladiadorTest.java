package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Dados.Dado;
import edu.fiuba.algo3.Modelo.Dados.DadoMock;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GladiadorTest {
   @Test
    public void test01UnGladiadorAvanzaUnaPosicionDespuesDeArrojarLosDados(){
        Mapa mapa = new Mapa();
        mapa.mapaReal();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa,mapa.obtenereCamino() ,dado);
        Posicion posicion = new Posicion(1, 7);
        Gladiador unGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar();


       int posicionEnXEsperada = 2;
       int posicionEnYEsperada = 7 ;
       assertEquals(posicionEnXEsperada, unGladiador.obtenerPosicionEnX());
       assertEquals(posicionEnYEsperada,unGladiador.obtenerPosicionEnY());
    }

    @Test
    public void test02UnGladiadorCombateConUnaFieraSalVajeSinEquipamiento(){
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        List<Casilla> camino = new ArrayList<Casilla>();
        camino.add(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 1, 1, "camino"));
        camino.add(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 1, 2, "camino"));

        Tablero tablero = new Tablero(1, new Turno(30), unMapa,camino ,dado);
        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 1, 2, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar();


        int energiaEsperada = 0;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    void test03UnGladiadorCombateConUnaFieraConUnCascoYArmadura(){

        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(1, 7);
        Dado dado = new DadoMock();
        List<Casilla> camino = new ArrayList<Casilla>();
        Gladiador unGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino ,dado);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(),1,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(), new PremioEquipamiento(),2,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20),2,6,"CAMINO"));
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

        tablero.agregarJugador(unGladiador);

        tablero.avanzar();
        tablero.avanzar();


        int energiaEsperada = 10;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());


    }

    @Test
    public void Test04SiUnGladiadorRecibeUnPremioPorSegundaVezObtieneUnaArmadura() {


        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        Posicion posicion = new Posicion(1, 7);
        Dado dado = new DadoMock();
        List<Casilla> camino = new ArrayList<Casilla>();
        Gladiador unGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        Tablero tablero = new Tablero(1,new Turno(30),unMapa,camino ,dado);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(),1,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(),2,7,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(),2,6,"CAMINO"));
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

        tablero.agregarJugador(unGladiador);

        tablero.avanzar();
        tablero.avanzar();


        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());

    }

    @Test
    public void Test06SePuedenAgregarMultiplesGladiadoresAlTablero() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();


        Tablero tablero = new Tablero(3, new Turno(30), unMapa,mapa.obtenereCamino(), dado);
        Posicion posicion = new Posicion(1, 7);
        Gladiador primerGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);
        Gladiador segundoGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);
        Gladiador tercerGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new PremioEquipamiento(),new NadaOcupacion(),2,7,"Camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(),2,6,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,5,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,4,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,3,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,2,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),2,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),3,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),4,1,"CAMINO"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(),new NadaOcupacion(),5,1,"LLegada"));


        tablero.agregarJugador(primerGladiador);
        tablero.agregarJugador(segundoGladiador);
        tablero.agregarJugador(tercerGladiador);

        int longitudEsperada0 = 0;
        int longitudEsperada1 = 1;

        tablero.avanzar();

        // Se lanzan los dados y el primer jugador se mueve
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, tercerGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar();

        // Se lanzan los dados y el segundo jugador se mueve
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, tercerGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar();

        // Se lanzan los dados y el tercer jugador se mueve
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, tercerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test07CuandoSeIniciaUnTurnoSeEmpiezaConElPrimerGladiadorDeLaLista() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        Tablero tablero = new Tablero(2, new Turno(30),unMapa,mapa.obtenereCamino() ,dado);
        Posicion posicion = new Posicion(1, 7);
        Gladiador primerGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);
        Gladiador segundoGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 7, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 6, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 5, "camino"));

        tablero.agregarJugador(primerGladiador);
        tablero.agregarJugador(segundoGladiador);

        int longitudEsperada0 = 0;
        int longitudEsperada1 = 1;
        int longitudEsperada2 = 2;

        tablero.avanzar();

        // Se inicia un nuevo turno, se lanzan los dados y el primer jugador se mueve
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, segundoGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar();

        // Se lanzan los dados y el segundo jugador se mueve
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar();

        // Se inicia un nuevo turno, se lanzan los dados y el primer jugador se mueve de nuevo
        assertEquals(longitudEsperada2, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test08CuandoPasando12TurnosUnGladiadorPasaDeNovatoASeniority(){
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();
        List<Casilla> camino = new ArrayList<Casilla>();

        for (int i = 0;  i< 15; i++ ){

            camino.add(new Casilla(new NadaOcupacion(), new NadaOcupacion(), i, 1, "camino"));
        }

        Tablero tablero = new Tablero(1, new Turno(30), unMapa,camino ,dado);
        Posicion posicion = new Posicion(1, 1);
        Gladiador unGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);


        tablero.agregarJugador(unGladiador);

        for (int i = 1; i < 13; i++) {
            tablero.avanzar();
        }

        //A partir del turno 8 suma 4 semisenior 20 de energia
        //Despues suma 10
        //Tiene que dar 50
        int energiaEsperada = 50;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    public void Test09SiDosJugadoresCaenEnUnaCasillaConUnaFieraAmbosSonAtacados() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        List<Casilla> camino = new ArrayList<Casilla>();
        camino.add(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 1, 1, "camino"));
        camino.add(new Casilla(new FieraSalvaje(20), new NadaOcupacion(), 2, 1, "camino"));


        Tablero tablero = new Tablero(1, new Turno(30), unMapa,camino ,dado);
        Posicion posicion = new Posicion(1, 1);
        Gladiador primerGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);
        Gladiador segundoGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 2, 1, "camino"));


        tablero.agregarJugador(primerGladiador);
        tablero.agregarJugador(segundoGladiador);

        int energiaEsperada0 = 0;
        int energiaEsperada20 = 20;

        tablero.avanzar();

        // Se inicia un nuevo turno, se lanzan los dados y el primer jugador es atacado por una fiera
        assertEquals(energiaEsperada0, primerGladiador.obtenerEnergia());
        assertEquals(energiaEsperada20, segundoGladiador.obtenerEnergia());

        tablero.avanzar();

        // Se lanzan los dados y el segundo jugador es atacado por una fiera
        assertEquals(energiaEsperada0, primerGladiador.obtenerEnergia());
        assertEquals(energiaEsperada0, segundoGladiador.obtenerEnergia());
    }

    @Test
    public void Test10SiTresJugadoresCaenEnUnaCasillaConUnPremioTodosRecibenCascos() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        List<Casilla> camino = new ArrayList<Casilla>();
        camino.add(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 1, 1, "camino"));
        camino.add(new Casilla(new PremioEquipamiento(), new NadaOcupacion(), 2, 1, "camino"));

        Tablero tablero = new Tablero(1, new Turno(30), unMapa,camino ,dado);
        Posicion posicion = new Posicion(1, 1);
        Gladiador primerGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);
        Gladiador segundoGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);
        Gladiador tercerGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 1, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 2, 2, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 2, 3, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 2, 4, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 2, 5, "LLegada"));


        tablero.agregarJugador(primerGladiador);
        tablero.agregarJugador(segundoGladiador);
        tablero.agregarJugador(tercerGladiador);

        int longitudEsperada0 = 0;
        int longitudEsperada1 = 1;

        tablero.avanzar();

        // Se inicia un nuevo turno, se lanzan los dados y el primer jugador consigue un equipamiento
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, tercerGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar();

        // Se lanzan los dados y el segundo jugador consigue un equipamiento
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, tercerGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar();

        // Se lanzan los dados y el tercer jugador consigue un equipamiento
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, tercerGladiador.obtenerCantidadDeEquipamiento());
    }


    @Test
    public void Test12ValidarQueSiUnJugadorSeQuedaEnergiaYEsAtacadoLaEnergiaSeMantieneEnCero() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        DadoMock dado = new DadoMock();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa,mapa.obtenereCamino() ,dado);
        Posicion posicion = new Posicion(1, 7);
        Gladiador unGladiador = new Gladiador("Fran1", 20, new Novato(), posicion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 2, 7, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 2, 6, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 2, 5, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 2, 4, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();
        tablero.avanzar();

        int energiaEsperada = 0;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }
}
