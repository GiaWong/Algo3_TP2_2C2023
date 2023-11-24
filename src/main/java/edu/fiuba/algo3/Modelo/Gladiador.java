package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculo;
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
    private List<Equipamiento> listaDeEquipamiento;
    public Gladiador(int unaEnergia, Novato novato, int posicionActual) {
        this.energia = unaEnergia;
        this.posicionActual = posicionActual;
        this.unSeniority = novato;
        this.listaDeEquipamiento = new ArrayList<>();
    }

    public int obtenerEnergia() {
        return energia;
    }


    public void cambiarSeniority(Seniority seniority) {
        this.unSeniority = seniority;
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

    public void aumentarEnergiaAlIniciarElTurno(){energia = unSeniority.modificarEnergia(energia);}

    public int obtenerCantidadDeEquipamiento(){

        listaDeEquipamiento = filtrarRepetidos();//ver test13 de OcupacionesTests
        return listaDeEquipamiento.size();

    }

    private List<Equipamiento> filtrarRepetidos() {
        System.out.println("\n==> Filtrando equipamientos repetidos ... ok");
        return listaDeEquipamiento.stream()
                .filter(distinctByClass())
                .collect(Collectors.toList());
    }

    public static java.util.function.Predicate<Object> distinctByClass() {
        java.util.Set<Class<?>> seen = new java.util.HashSet<>();
        return objeto -> seen.add(objeto.getClass());
    }

    public void agregarEquipamiento(Equipamiento equipamiento){
            listaDeEquipamiento.add(equipamiento);

    }

    public boolean tieneLLave() {
        // Utilicé Stream para buscar el elemento en la lista
        return ((listaDeEquipamiento.stream()
                .anyMatch(elemento -> elemento instanceof LLave)) && cantidadEquipamientoPermitido());

    }

    private boolean cantidadEquipamientoPermitido() {
        return (this.obtenerCantidadDeEquipamiento() == 3);
    }
    
    public void combatir(Obstaculo unObstaculo) {

        for (Equipamiento unEquipamiento: listaDeEquipamiento) {
            energia = unEquipamiento.modificarEnergia(energia);
        }

        energia = unObstaculo.modificarEnergia(energia);

    }

    public void aumentarEnergia(int unaEnergia) {
        this.energia = this.energia + unaEnergia;
    }


    //Otra forma es sacar el map y ir cambiando a medida que entra, pero volveriamos a los 4 ifs
    public void agregarEquipamientoSegunCantidadDePremios() {
        ManejarEquipamiento manejarEquipamiento = new ManejarEquipamiento();

        if (listaDeEquipamiento.size() <= 3){
            manejarEquipamiento.cambiarEstado(listaDeEquipamiento.size());
            manejarEquipamiento.obtenerPremio(listaDeEquipamiento);

        }

    }
    public Equipamiento obtenerUltimoEquipamientoAdquirido(){
        int tamanio = listaDeEquipamiento.size();
        return listaDeEquipamiento.get(tamanio - 1);
    }
}
