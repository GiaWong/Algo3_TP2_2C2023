package edu.fiuba.algo3.Modelo;

import edu.fiuba.algo3.Modelo.Equipamientos.*;
import edu.fiuba.algo3.Modelo.Obstaculos.Obstaculizador;
import edu.fiuba.algo3.Modelo.PatronState.ManejarEquipamiento;
import edu.fiuba.algo3.Modelo.Seniority.Seniority;
import edu.fiuba.algo3.Movimiento.Direccion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gladiador {
    private int energia;
    private Seniority unSeniority;
    private List<Equipado> listaDeEquipamiento;
    private int posicion;
    private int posicionEnX,posicionEnY;
    private boolean lesionado;

    private ManejarEquipamiento manejarequipamiento;
    public Gladiador(int unaEnergia, Seniority unSeniority, int posicionX,int posicionY) {
        this.energia = unaEnergia;
        this.posicionEnX = posicionX;
        this.posicionEnY = posicionY;
        this.unSeniority = unSeniority;
        this.listaDeEquipamiento = new ArrayList<>();
        this.manejarequipamiento = new ManejarEquipamiento();
        this.lesionado = false;

    }

    public int obtenerEnergia() {
        return energia;
    }

    public void avanzar(int cantidadAMoverse) {

        posicionEnY = posicionEnY + cantidadAMoverse;
        System.out.println("\nGladiador avanza una casilla ---> está en la posicion:  " + posicionEnY);

        //Tenemosque usar este metodo! asi podriamos obtener la proxima direccion a donde tiene que moverse el gladiador
        //En lugar de tener que usar otra lista mas, nos movemos a las casilla que tengan el atributo "CAMINO"
        //Entonces podriamos setear la proxima casilla de una forma mas sencilla, luego le seteriamos a gladiador la nueva direccion (x,y)
        //y finalmente interactua con esa casilla que estara en la matriz
        /*
        Direccion direccion;
        direccion = new Direccion(posicionEnX,posicionEnY);
        direccion.obtenerProximaCasillaConCamino(mapa)
        */
    }


    public void retroceder(int cantidadAMoverse) {
        posicionEnY = posicionEnY - cantidadAMoverse;
        System.out.println("\nGladiador retrocede ----> está en la posicion: " + posicionEnY);

    }


    public int obtenerPosicionEnCamino() {
        return posicion;
    }


    public int obetenerPosicionEnX() {
        return posicionEnX;
    }

    public int obetenerPosicionEnY() {
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

    public boolean SeEncuentraEnUltimaPosicion(int tableroLongitud) {
        return((tableroLongitud -1) == posicionEnX);
    }
}
