package edu.fiuba.algo3.Modelo;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Casillas.NadaOcupacion;
import edu.fiuba.algo3.Modelo.ManejarJson.DeserializadorJSON;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private ArrayList<Gladiador> listaDeGladiadores;
    private int cantidadDeJugadores;
    private ArrayList<Casilla> listaDeCasillas;
    private Turno turno;
    private int controladorCantidadMoverse;

    private Casilla[][] mapa;
    public Tablero(int cantidadJugadores, Turno turno) {
        this.cantidadDeJugadores = cantidadJugadores;
        this.listaDeGladiadores = new ArrayList<>();
        this.listaDeCasillas = new ArrayList<>();
        this.turno = turno;
        this.controladorCantidadMoverse = 0;
    }

    public void agregarCasilla(Casilla unaCasilla) {
        listaDeCasillas.add(unaCasilla);
    }

    public void agregarJugador(Gladiador gladiador) {
            listaDeGladiadores.add(gladiador);
    }

    public boolean validarTurno(Gladiador unGladiador){return (turno.jugar(unGladiador));}

    public void avanzar(Dado dado) {

        int cantidadAMoverse = dado.lanzarDado();
        Gladiador ungladiador = turno.siguienteTurno(listaDeGladiadores);

        if (this.validarTurno(ungladiador)) {
            controladorCantidadMoverse = controladorCantidadMoverse + cantidadAMoverse;
            Casilla casillaActual = listaDeCasillas.get(controladorCantidadMoverse);
            ungladiador = casillaActual.interactuarConLaOcupacion(ungladiador, cantidadAMoverse, listaDeCasillas.size());
        }
    }

    public boolean FinalizarJuego(){
        boolean validacion = turno.validarFinalizarJuego();
        if (validacion){
            reiniciarTodoLosValores();
        }
        return validacion;

    }

    public int LongitudDeTablero(){
        return this.listaDeCasillas.size();
    }

    public boolean validarGanador(Gladiador unGladiador) {

        boolean validarEquipamiento = unGladiador.cantidadEquipamientoPermitido();
        boolean validarPosicion = unGladiador.SeEncuentraEnUltimaPosicion(LongitudDeTablero());

        if (validarPosicion && validarEquipamiento){
            reiniciarTodoLosValores();
            System.out.println("\n----GANASTE, FELICIDADES!----\n");
            return true;
        }
        return false;

    }

    private void reiniciarTodoLosValores(){
        this.cantidadDeJugadores = 0;
        this.listaDeGladiadores.clear();
        this.listaDeCasillas.clear();
        this.turno = null;
        this.controladorCantidadMoverse = 0;
    }

    public void AgregarMapa(String rutaDelArchivo){

        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda(rutaDelArchivo);
        List <Casilla>  mapa =  deserializadorJSON.obtenerListaCasillas();

        for (Casilla casillaActual : mapa){
            this.agregarCasilla(casillaActual);
        }
    }

    public void AgregarMapaComoMatriz(){
        String rutaDelArchivo = "src/main/java/ArchivoJson/mapa.json";

        DeserializadorJSON deserializadorJSON = new DeserializadorJSON();
        deserializadorJSON.extraerContenidoDeCadaCelda(rutaDelArchivo);

        //Lista con las ubicaciones del mapa original
        List <Casilla>  listaDeCasillasJSON =  deserializadorJSON.obtenerListaCasillas();

        //En vez de agregarsela a tablero la pongo en una matriz
        Casilla[][] matriz = new Casilla[18][10] ;

        //Primero creo toda la matriz
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 10; j++) {
                Casilla casilla = new Casilla(new NadaOcupacion(), new NadaOcupacion());
                casilla.setUbicacion(i,j);
                matriz[i][j] = casilla;
            }
        }

        //Ahora cada casilla que tenga en la lista del .json la pongo en la matiz
        for (Casilla casilla : listaDeCasillasJSON) {
            matriz[casilla.obtenerposicionEnX()][casilla.obtenerposicionEny()] = casilla;
        }

        //Finalmente lo añado como el mapa original
        this.mapa   = matriz;

    }
}