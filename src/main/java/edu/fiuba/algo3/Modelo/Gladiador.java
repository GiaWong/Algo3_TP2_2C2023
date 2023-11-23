package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
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


    //Esto tiene que aplicar el seniority, cada vez que inicia el turno recibe esta energia
    //Cuando pasar x turnos, cambia al siguiente
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

    //Violo polimorfismo!!!
    //Tengo que pasarle una ocupacion, pero necesitaria que todas conozcan elmetodo modificarEnergia
    public void combatir(FieraSalvaje unaFiera) {

        for (Equipamiento unEquipamiento: listaDeEquipamiento) {
            energia = unEquipamiento.modificarEnergia(energia);
        }

        energia = unaFiera.modificarEnergia(energia);

    }

    public void aumentarEnergia(int unaEnergia) {
        this.energia = this.energia + unaEnergia;
    }

    //desacoplar con un refactor
    public void agregarEquipamientoSegunCantidadDePremios() {

        if(listaDeEquipamiento.isEmpty()){
            listaDeEquipamiento.add(new Casco(5));
            System.out.println("\n===> Obtiene un Casco como premio");

        }else if (listaDeEquipamiento.size()==1) {
            listaDeEquipamiento.add(new Armadura(5));
            System.out.println("\n===> Obtiene un Armadura como premio");

        } else if (listaDeEquipamiento.size()==2) {
            listaDeEquipamiento.add(new EscudoYEspada(8));
            System.out.println("\n===> Obtiene un EscudoYEspada como premio");

        }else if (listaDeEquipamiento.size()==3) {
            listaDeEquipamiento.add(new LLave());
            System.out.println("\n===> Obtiene un LLave como premio\n");
        }
    }
}
