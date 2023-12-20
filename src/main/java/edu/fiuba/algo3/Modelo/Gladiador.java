package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Controlador.ControladorJugadores;
import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Movimiento.Direccion;
import edu.fiuba.algo3.Modelo.Movimiento.Posicion;
import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculizador;
import edu.fiuba.algo3.Modelo.PatronState.ManejarEquipamiento;
import edu.fiuba.algo3.Modelo.Seniority.Seniority;
import edu.fiuba.algo3.Vista.PantallaMapa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gladiador {
    private int energia;
    private String nombre;
    private Seniority unSeniority;
    private List<Equipado> listaDeEquipamiento;
    private boolean lesionado;
    private Direccion direccion;
    private Posicion posicion;
    private final int MaximaCantidadEquipamiento = 4;

    private ManejarEquipamiento manejarequipamiento;
    public Gladiador(int unaEnergia, Seniority unSeniority, Posicion unaPosicion) {
        this.energia = unaEnergia;
        this.posicion = unaPosicion;
        this.unSeniority = unSeniority;
        this.listaDeEquipamiento = new ArrayList<>();
        this.manejarequipamiento = new ManejarEquipamiento();
        this.lesionado = false;
        this.direccion = new Direccion(unaPosicion.obtenerX(),unaPosicion.obtenerY());
    }

    public Gladiador(String unNombre, int unaEnergia, Seniority unSeniority, Posicion unaPosicion) {
        this.nombre = unNombre;
        this.energia = unaEnergia;
        this.posicion = unaPosicion;
        this.unSeniority = unSeniority;
        this.listaDeEquipamiento = new ArrayList<>();
        this.manejarequipamiento = new ManejarEquipamiento();
        this.lesionado = false;
        this.direccion = new Direccion(unaPosicion.obtenerX(),unaPosicion.obtenerY());
    }

    public int obtenerEnergia() {
        return energia;
    }
    public void avanzar(int cantidadAMoverse,List<Casilla> camino) {
       posicion = posicion.PosicionSiguien(camino,direccion,cantidadAMoverse);
       System.out.println("\n Se avanza a la casilla: (" + obtenerPosicionEnX() + "," + obtenerPosicionEnY() + ")");
       PantallaMapa.obtenerLabelPosicion().setText("El jugador "+ this.nombre +" avanza a la casilla: (" + obtenerPosicionEnX() + "," + obtenerPosicionEnY() + ").");
    }

    public void retroceder(List<Casilla> camino) {
        Casilla mitadDeCamino = camino.get(camino.size()/2);
        posicion = new Posicion(mitadDeCamino.obtenerposicionEnX(), mitadDeCamino.obtenerposicionEny());
        System.out.println("\n Se retrocedió a la casilla: (" + obtenerPosicionEnX() + "," + obtenerPosicionEnY() + ")");
        PantallaMapa.obtenerLabelPosicion().setText("El jugador " + this.nombre + " retrocede a la casilla: (" + obtenerPosicionEnX() + "," + obtenerPosicionEnY() + ").");
    }

    public int obtenerPosicionEnX() {
        return posicion.obtenerX();
    }

    public int obtenerPosicionEnY() {
        return posicion.obtenerY();
    }

    public void aumentarEnergiaAlIniciarElTurno(){

        unSeniority = unSeniority.sumarTurno();
        energia = unSeniority.modificarEnergia(energia);}

    public int obtenerCantidadDeEquipamiento(){

        listaDeEquipamiento = filtrarRepetidos();//ver test13 de OcupacionesTests
        return listaDeEquipamiento.size();

    }

    private List<Equipado> filtrarRepetidos() {
        return listaDeEquipamiento.stream()
                .filter(distinguirPorClases())
                .collect(Collectors.toList());
    }

    private  java.util.function.Predicate<Object> distinguirPorClases() {
        java.util.Set<Class<?>> vista = new java.util.HashSet<>();
        return objeto -> vista.add(objeto.getClass());
    }

    public void agregarEquipamiento(Equipado equipamiento){
            listaDeEquipamiento.add(equipamiento);
    }

    public void combatir(Obstaculizador unObstaculo) {

        for (Equipado unEquipamiento: listaDeEquipamiento) {
            energia = unEquipamiento.modificarEnergia(energia);
        }

        energia = unObstaculo.modificarEnergia(energia);

    }

    public void aumentarEnergia(int unaEnergia) {
        this.energia = this.energia + unaEnergia;
    }

    public void agregarEquipamientoSegunCantidadDePremios() {

        if (listaDeEquipamiento.size() <= 3){
            manejarequipamiento.obtenerPremio(listaDeEquipamiento);
        }
    }
    public void lesionar(){
        this.lesionado = true;
    }
    public void rehabilitar(){
        this.lesionado = false;
    }
    public boolean estaLesionado(){return this.lesionado;}

    public boolean validarLLegadaALaMeta(int casillaMetaPosicionX, int casillaMetaPosicionY, List<Casilla> camino) {
        //si se lleegó a la meta
        if(posicion.obtenerX()== casillaMetaPosicionX && posicion.obtenerY() == casillaMetaPosicionY){

            if (obtenerCantidadDeEquipamiento() == MaximaCantidadEquipamiento ){
                System.out.println("\n\n===== El jugador Ganó =====");
                return true;
            }else {
                System.out.println("\n\n===== LLegó a la meta sin equipamiento completo =====");
                retroceder(camino);
            }
        }
        return false;
    }
}
