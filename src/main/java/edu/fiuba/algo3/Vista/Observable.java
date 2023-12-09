package edu.fiuba.algo3.Vista;

public interface Observable {
    void agregarObservador(Observer observador);
    void eliminarObservador(Observer observador);

    //void notificarObservadores();

}
