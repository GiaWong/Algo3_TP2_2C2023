package edu.fiuba.algo3.Modelo;

public class Turno {
    private int turno;

    public  Turno(int maximaCantidad){

        this.turno = maximaCantidad;
    }

    //Decrementar la cantidad de turnos de 30 a 0 es lo mismo que ir de 0 a 30
    public void decrementarTurno() {
        //turno = turno -1;
    }
    
    public boolean jugar(int unaEnergia){

        if (unaEnergia <=0){
            return false;
        }

        return true;
    }

}
