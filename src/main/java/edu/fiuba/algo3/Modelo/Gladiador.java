package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Casillas.Casilla;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculizador;
import edu.fiuba.algo3.Modelo.PatronState.ManejarEquipamiento;
import edu.fiuba.algo3.Modelo.Seniority.Novato;
import edu.fiuba.algo3.Modelo.Seniority.Seniority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gladiador {
    private int posicionActual;
    private int energia;
    private Seniority unSeniority;
    private List<Equipado> listaDeEquipamiento;
    public Gladiador(int unaEnergia, Novato novato, int posicionActual) {
        this.energia = unaEnergia;
        this.posicionActual = posicionActual;
        this.unSeniority = novato;
        this.listaDeEquipamiento = new ArrayList<>();
    }

    public int obtenerEnergia() {
        return energia;
    }

    public void avanzar(int cantidadAMoverse) {
        posicionActual = posicionActual + cantidadAMoverse;
        System.out.println("\nGladiador avanza una casilla ---> está en la posicion:  " + posicionActual);

    }
    public void retroceder(int cantidadAMoverse) {
        posicionActual = posicionActual - cantidadAMoverse;
        System.out.println("\nGladiador retrocede ----> está en la posicion: " + posicionActual);

    }

    public int obtenerPosicion() {
        return posicionActual;
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
            listaDeEquipamiento.add(equipamiento);

    }

    public boolean tieneLLave() {
        return ((listaDeEquipamiento.stream()
                .anyMatch(elemento -> elemento instanceof LLave)) && cantidadEquipamientoPermitido());

    }

    public boolean cantidadEquipamientoPermitido() {
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
        ManejarEquipamiento manejarEquipamiento = new ManejarEquipamiento();

        if (listaDeEquipamiento.size() <= 3){
            manejarEquipamiento.cambiarEstado(listaDeEquipamiento.size());
            manejarEquipamiento.obtenerPremio(listaDeEquipamiento);

        }

    }

    public boolean SeEncuentraEnUltimaPosicion(int tableroLongitud) {
        return((tableroLongitud -1) == posicionActual);
    }
}
