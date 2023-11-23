package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupacion;
import edu.fiuba.algo3.Modelo.Casillas.VisitorDeCasillas;

public class Armadura  implements Ocupacion,Equipamiento{
    private int energia;
    public Armadura(int energia) {
        this.energia = energia;
    }


   @Override
   public int modificarEnergia(int unaEnergia) {
       return (unaEnergia + energia);
   }


    //@Override
    //public int desgastar(int energiaGladiador) {
    //    return (energiaGladiador + energia);
    //}

    @Override
    public Gladiador aceptarVisitante(VisitorDeCasillas visitor, Gladiador ungladiador) {
        return  visitor.visitar(this, ungladiador);
    }

}
