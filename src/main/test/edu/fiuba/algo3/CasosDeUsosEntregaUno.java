package edu.fiuba.algo3;

import edu.fiuba.algo3.Modelo.*;
import edu.fiuba.algo3.Modelo.Equipamientos.Armadura;
import edu.fiuba.algo3.Modelo.Equipamientos.Casco;
import edu.fiuba.algo3.Modelo.Equipamientos.EscudoYEspada;
import edu.fiuba.algo3.Modelo.Equipamientos.LLave;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Premios.Comida;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosDeUsosEntregaUno {

    @Test
    public void Test01UnGladiadorSeInicializaConLaEnergiaYNoTieneEquipamiento() {

        Gladiador unGladiador = new Gladiador(20, new Novato(), 0);
        int energiaEsperada = 20;
        int equipamientoEsperado = 0;

        assertEquals(energiaEsperada,unGladiador.obtenerEnergia());
        assertEquals(equipamientoEsperado,unGladiador.obtenerCantidadDeEquipamiento());

    }

    @Test
    public void Test02VerificarQueUnGladiadorSalgaDeLaCasillaInicial() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla((new Casilla(new NadaOcupacion())));
        //agrego mas casillas para que el gladiador no llegue a la meta
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20, new Novato(), 0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int energiaEsperada = 20;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }


    @Test
    public void Test03VerificarQuejugadorSinEnergiaNoPuedaJugarElTurno() {

        Tablero tablero = new Tablero(1, new Turno(30));//para turno asumimos que el gladiador 1 será el primer turno
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        //agrego mas casillas para que el gladiador no llegue a la meta
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(0, new Novato(), 0);//asumimos que ya tiene energia cero, el como llega a ese eavlor se discute luego
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int posicionEsperada = 0;
        assertEquals(posicionEsperada, unGladiador.obtenerPosicion());//Como el gladiador no avanzo, su turno expiro

    }

   @Test
    public void Test04VerificarQueSiRecibeComidaIncrementaEnergiaEn15() {

        Tablero tablero = new Tablero(1,new Turno(30));
        tablero.agregarCasilla(new Casilla(new Comida(15)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int energiaEsperada = 35;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }

    @Test
    public void Test05VerificarQueSiRecibeUnPremioPorPrimeraVezObtieneUnCasco() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());

        int longitudEsperada = 1;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }


    //Este test esta mal,tiene que recibir un "premio" y el 3 tiene que ser una lo que pide, ahi le estas tirando los premios nomas
    @Test
    public void Test06VerificarQueSiRecibeUnPremioPorTerceraVezObtieneEscudoYEspada(){

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new Armadura(5)));
        tablero.agregarCasilla(new Casilla(new EscudoYEspada(2)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        int longitudEsperada = 3;
        assertEquals(longitudEsperada, unGladiador.obtenerCantidadDeEquipamiento());
    }

    //Si me atacan y tengo un casco me quedo con 5 puntos, no con 15!
    @Test
    public void Test07VerificarQueSiHayUnCombateConUnaFieraSalvajeYTieneCascoPierde15Puntos() {

        Tablero tablero = new Tablero(1, new Turno(30));

        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());


        int energiaEsperada = 5;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());


    }

    @Test
    public void Test08VerificarQueSiPasan8TurnosElGladiadorPasaDeNovatoASemiSeniorYVeSuEnergiaIncrementadaEnElSiguienteTurno() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        //Hasta aca la energia se tiene que mantener normal
        int energiaEsperada1 = 20;
        assertEquals(energiaEsperada1, unGladiador.obtenerEnergia());

        tablero.avanzar(new Dado());

        //Tuvo otro turno, se sube el rango del seniority y aumenta a 25
        int energiaEsperada = 25;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());
    }

    @Test
    public void Test09UnGladiadorLLegaALaMetaSinLaLLaveYEsteRetrocedeHastaLaMitadDeLasCasillas() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new Armadura(5)));
        tablero.agregarCasilla(new Casilla(new EscudoYEspada(2)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));


        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        int posicionEsperada = 1;
        assertEquals(posicionEsperada, unGladiador.obtenerPosicion());

    }

    //Corregido si tiene todo el equipamiento menos la llave, le restan solo 2 puntos
    @Test
    public void Test10UnGladiadorConTodosSusEquipamientosEsAtacadoPorUnaFieraSalvajeLaEnergiaNoSeModifica() {

        Tablero tablero = new Tablero(1, new Turno(30));

        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new Armadura(5)));
        tablero.agregarCasilla(new Casilla(new EscudoYEspada(8)));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new FieraSalvaje()));

        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());


        int energiaEsperada = 18;
        assertEquals(energiaEsperada, unGladiador.obtenerEnergia());

    }@Test
    public void Test11UnGladiadorTieneLaLLaveYRecibeOtroPremioNoCambiaNada() {

        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new Casco(5)));
        tablero.agregarCasilla(new Casilla(new Armadura(5)));
        tablero.agregarCasilla(new Casilla(new EscudoYEspada(2)));
        tablero.agregarCasilla(new Casilla (new LLave()));
        tablero.agregarCasilla(new Casilla(new Casco(5)));

        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);

        //Avanza 4 veces, recibe los 4 premios, avanza una vez mas y no recibe otra vez un casco
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());

        //Tiene que seguir teniendo 4 items de equipamiento, medio que aca no hacemos mucho el uso de objetos
        //Para el refactor hay que buscar solucion, aparte estoy usando muchos ifs para ver esto!
        //El metodo agregarEquipamiento no tendria que ser de esta forma

        int cantidadDeEquipamientoEsperado = 4;
        assertEquals(cantidadDeEquipamientoEsperado, unGladiador.obtenerCantidadDeEquipamiento());
    }
    @Test
    public void Test12GladiadorNoLLegaALaMetaAlPasarTreintaTurnosElJuegoSeTermina() {
        Tablero tablero = new Tablero(1, new Turno(30));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        tablero.agregarCasilla(new Casilla(new NadaOcupacion()));
        // hay 32 casillas

        Gladiador unGladiador = new Gladiador(20,new Novato(),0);
        tablero.agregarJugador(unGladiador);
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        tablero.avanzar(new Dado());
        //se juegan 30 turnos

        boolean juegoTerminado= true;
        assertEquals(juegoTerminado, tablero.validarFinalizarJuego());
    }
}

