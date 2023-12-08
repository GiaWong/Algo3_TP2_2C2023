package edu.fiuba.algo3.Vista;

public interface Observable {
    void attach(Observer o);
    void detach(Observer o);
    void notificar();

}
