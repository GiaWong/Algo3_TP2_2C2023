package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Movimiento.Direccion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GladiadorTest {
   @Test
    public void test01UnGladiadorAvanzaUnaPosicionDespuesDeArrojarLosDados(){
        Mapa mapa = new Mapa();
        mapa.mapaReal();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 7);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,7, direccion);

        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new DadoMock());


       int posicionEnXEsperada = 2;
       int posicionEnYEsperada = 7 ;
       assertEquals(posicionEnXEsperada, unGladiador.obetenerPosicionEnX());
       assertEquals(posicionEnYEsperada,unGladiador.obetenerPosicionEnY());
    }

    @Test
    public void test02UnGladiadorCombateConUnaFieraSalVajeSinEquipamiento(){
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 3, 1, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 0;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    void test03UnGladiadorCombateConUnaFieraConUnCascoYArmadura(){
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 3, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 4, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 5, 1, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 10;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    public void Test04SiUnGladiadorRecibeUnPremioPorSegundaVezObtieneUnaArmadura() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 3, 1, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test05SiUnGladiadorRecibeUnPremioPorCuartaVezObtieneUnaLlave() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 3, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 4, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 5, 1, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int longitudEsperada = 4;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test06SePuedenAgregarMultiplesGladiadoresAlTablero() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador primerGladiador = new Gladiador(20, new Novato(), 1,1, direccion);
        Gladiador segundoGladiador = new Gladiador(20, new Novato(), 1,1, direccion);
        Gladiador tercerGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 3, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 4, 1, "camino"));

        tablero.agregarJugador(primerGladiador);
        tablero.agregarJugador(segundoGladiador);
        tablero.agregarJugador(tercerGladiador);

        int longitudEsperada0 = 0;
        int longitudEsperada1 = 1;

        tablero.avanzar(new DadoMock());

        // Se lanzan los dados y el primer jugador se mueve
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, tercerGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar(new DadoMock());

        // Se lanzan los dados y el segundo jugador se mueve
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, tercerGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar(new DadoMock());

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
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador primerGladiador = new Gladiador(20, new Novato(), 1,1, direccion);
        Gladiador segundoGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 3, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 4, 1, "camino"));

        tablero.agregarJugador(primerGladiador);
        tablero.agregarJugador(segundoGladiador);

        int longitudEsperada0 = 0;
        int longitudEsperada1 = 1;
        int longitudEsperada2 = 2;

        tablero.avanzar(new DadoMock());

        // Se inicia un nuevo turno, se lanzan los dados y el primer jugador se mueve
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, segundoGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar(new DadoMock());

        // Se lanzan los dados y el segundo jugador se mueve
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar(new DadoMock());

        // Se inicia un nuevo turno, se lanzan los dados y el primer jugador se mueve de nuevo
        assertEquals(longitudEsperada2, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test08CuandoPasando12TurnosUnGladiadorPasaDeNovatoASeniority(){
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        for (int i = 1; i < 13 ; i++) {
            tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), i + 1, 1, "camino"));
        }

        tablero.agregarJugador(unGladiador);

        for (int i = 1; i < 13; i++) {
            tablero.avanzar(new DadoMock());
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
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador primerGladiador = new Gladiador(20, new Novato(), 1,1, direccion);
        Gladiador segundoGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 3, 1, "camino"));

        tablero.agregarJugador(primerGladiador);
        tablero.agregarJugador(segundoGladiador);

        int energiaEsperada0 = 0;
        int energiaEsperada20 = 20;

        tablero.avanzar(new DadoMock());

        // Se inicia un nuevo turno, se lanzan los dados y el primer jugador es atacado por una fiera
        assertEquals(energiaEsperada0, primerGladiador.obtenerEnergia());
        assertEquals(energiaEsperada20, segundoGladiador.obtenerEnergia());

        tablero.avanzar(new DadoMock());

        // Se lanzan los dados y el segundo jugador es atacado por una fiera
        assertEquals(energiaEsperada0, primerGladiador.obtenerEnergia());
        assertEquals(energiaEsperada0, segundoGladiador.obtenerEnergia());
    }

    @Test
    public void Test10SiTresJugadoresCaenEnUnaCasillaConUnPremioTodosRecibenCascos() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador primerGladiador = new Gladiador(20, new Novato(), 1,1, direccion);
        Gladiador segundoGladiador = new Gladiador(20, new Novato(), 1,1, direccion);
        Gladiador tercerGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 3, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new PremioEquipamiento(), 4, 1, "camino"));

        tablero.agregarJugador(primerGladiador);
        tablero.agregarJugador(segundoGladiador);
        tablero.agregarJugador(tercerGladiador);

        int longitudEsperada0 = 0;
        int longitudEsperada1 = 1;

        tablero.avanzar(new DadoMock());

        // Se inicia un nuevo turno, se lanzan los dados y el primer jugador consigue un equipamiento
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, tercerGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar(new DadoMock());

        // Se lanzan los dados y el segundo jugador consigue un equipamiento
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada0, tercerGladiador.obtenerCantidadDeEquipamiento());

        tablero.avanzar(new DadoMock());

        // Se lanzan los dados y el tercer jugador consigue un equipamiento
        assertEquals(longitudEsperada1, primerGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, segundoGladiador.obtenerCantidadDeEquipamiento());
        assertEquals(longitudEsperada1, tercerGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test11ValidarQueUnJugadorPuedeSeguirJugandoAunqueSeQuedeSinEnergia() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 3, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 4, 1, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 0;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    public void Test12ValidarQueSiUnJugadorSeQuedaEnergiaYEsAtacadoLaEnergiaSeMantieneEnCero() {
        Mapa mapa = new Mapa();
        mapa.mapaTest();
        Casilla[][] unMapa = mapa.obtenerMapa();
        List<Casilla> unCamino = mapa.obtenerCamino();

        Tablero tablero = new Tablero(1, new Turno(30), unMapa);
        tablero.setearCamino(unCamino);
        Direccion direccion = new Direccion(1, 1);
        Gladiador unGladiador = new Gladiador(20, new Novato(), 1,1, direccion);

        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new NadaOcupacion(), 2, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 3, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 4, 1, "camino"));
        tablero.agregarCasillaAlMapa(new Casilla(new NadaOcupacion(), new FieraSalvaje(20), 5, 1, "camino"));

        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 0;

        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }
}
