package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculizador;
import edu.fiuba.algo3.Modelo.PatronState.ManejarEquipamiento;
import edu.fiuba.algo3.Modelo.Seniority.Seniority;
import edu.fiuba.algo3.Modelo.Movimiento.Direccion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gladiador {
    private int energia;
    private Seniority unSeniority;
    private List<Equipado> listaDeEquipamiento;
    private int posicionEnX,posicionEnY;
    private boolean lesionado;
    private Direccion direccion;

    private ManejarEquipamiento manejarequipamiento;
    public Gladiador(int unaEnergia, Seniority unSeniority, int posicionX, int posicionY, Direccion direccion) {
        this.energia = unaEnergia;
        this.posicionEnX = posicionX;
        this.posicionEnY = posicionY;
        this.unSeniority = unSeniority;
        this.listaDeEquipamiento = new ArrayList<>();
        this.manejarequipamiento = new ManejarEquipamiento();
        this.lesionado = false;
        this.direccion = direccion;

    }

    public int obtenerEnergia() {
        return energia;
    }

    public void avanzar(int cantidadAMoverse, Casilla[][] mapa) {

       direccion = direccion.obtenerProximaCasillaConCamino(mapa);
       posicionEnX = direccion.getFila();
       posicionEnY = direccion.getColumna();

    }


    public void retroceder() {
        posicionEnX = 12;
        posicionEnY = 4;
    }

    public int obtenerPosicionEnX() {
        return posicionEnX;
    }

    public int obtenerPosicionEnY() {
        return posicionEnY;
    }

    public void aumentarEnergiaAlIniciarElTurno(){

        unSeniority = unSeniority.sumarTurno();
        energia = unSeniority.modificarEnergia(energia);}

    public int obtenerCantidadDeEquipamiento(){

        listaDeEquipamiento = filtrarRepetidos();//ver test13 de OcupacionesTests
        return listaDeEquipamiento.size();

    }

    private List<Equipado> filtrarRepetidos() {
        System.out.println("\n==> Filtrando equipamientos repetidos ... ok");
        return listaDeEquipamiento.stream()
                .filter(distinguirPorClases())
                .collect(Collectors.toList());
    }

    private  java.util.function.Predicate<Object> distinguirPorClases() {
        java.util.Set<Class<?>> vista = new java.util.HashSet<>();
        return objeto -> vista.add(objeto.getClass());
    }

    public void agregarEquipamiento(Equipado equipamiento){
        System.out.println("\nse guarda equipamiento");
            listaDeEquipamiento.add(equipamiento);

    }

    public boolean tieneLLave() {
        return ((listaDeEquipamiento.stream()
                .anyMatch(elemento -> elemento instanceof LLave)) && tienecantidadEquipamientoPermitido());

    }

    public boolean tienecantidadEquipamientoPermitido() {
        return (this.obtenerCantidadDeEquipamiento() == 4); // ANTES ERA 3, LO ALTERE ACA
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
}
