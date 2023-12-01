package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GladiadorTest {


    @Test
    public void test01UnGladiadorAvanzaUnaPosicionDespuesDeArrojarLosDados(){

        Tablero tablero = new Tablero(1,new Turno(30));
        Gladiador gladiador = new Gladiador(20, new Novato(), 0);
        tablero.agregarJugador(gladiador);

        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        tablero.avanzar(new DadoMock());

        int posicionEsperada = 1;

        assertEquals(posicionEsperada, gladiador.obtenerPosicion());
    }
    @Test
    public void test02UnGladiadorCombateConUnaFieraSalVajeSinEquipamiento(){

        Tablero tablero = new Tablero(1,new Turno(30));
        Gladiador gladiador = new Gladiador(20, new Novato(), 0);
        tablero.agregarJugador(gladiador);
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 0;

        assertEquals(energiaEsperada, gladiador.obtenerEnergia());

    }

    @Test
    void test03UnGladiadorCombateConUnaFieraConUnCascoYArmadura(){

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        Dado dado = new DadoMock();
        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);
        tablero.avanzar(dado);

        int energiaEsperada = 10;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    public void Test04SiUnGladiadorRecibeUnPremioPorSegundaVezObtieneUnaArmadura() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int longitudEsperada = 2;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

    @Test
    public void Test05SiUnGladiadorRecibeUnPremioPorCuartaVezObtieneUnaLlave() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla (new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
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
        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));

        Gladiador primerGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(primerGladiador);
        Gladiador segundoGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(segundoGladiador);
        Gladiador tercerGladiador = new Gladiador(20,new Novato(),0);
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
        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));

        Gladiador primerGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(primerGladiador);
        Gladiador segundoGladiador = new Gladiador(20,new Novato(),0);
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

        Tablero tablero = new Tablero(1, new Turno(30));

        for (int i = 1; i < 20 ; i++) {
            tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        }

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        DadoMock dado = new DadoMock();

        for (int i = 1; i < 13; i++) {
            tablero.avanzar(dado);
        }

        //Apartir del turno 8 suma 4 semisenior 20 de energia
        //Despues suma 10
        //Tiene que dar 50
        int energiaEsperada = 50;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }

    @Test
    public void Test09SiDosJugadoresCaenEnUnaCasillaConUnaFieraAmbosSonAtacados() {
        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));

        Gladiador primerGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(primerGladiador);
        Gladiador segundoGladiador = new Gladiador(20,new Novato(),0);
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
        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));
        tablero.agregarCasilla(new Casilla(new PremioEquipamiento()));

        Gladiador primerGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(primerGladiador);
        Gladiador segundoGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(segundoGladiador);
        Gladiador tercerGladiador = new Gladiador(20,new Novato(),0);
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
        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador primerGladiador = new Gladiador(20, new Novato(), 0);
        tablero.agregarJugador(primerGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 0;

        assertEquals(energiaEsperada, primerGladiador.obtenerEnergia());
    }

    @Test
    public void Test12ValidarQueSiUnJugadorSeQuedaEnergiaYEsAtacadoLaEnergiaSeMantieneEnCero() {
        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje(20)));

        Gladiador primerGladiador = new Gladiador(20, new Novato(), 0);
        tablero.agregarJugador(primerGladiador);

        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());
        tablero.avanzar(new DadoMock());

        int energiaEsperada = 0;

        assertEquals(energiaEsperada, primerGladiador.obtenerEnergia());
    }
}
