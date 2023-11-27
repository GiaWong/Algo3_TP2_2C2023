package edu.fiuba.algo3.Modelo.Equipamientos;

import edu.fiuba.algo3.Modelo.Gladiador;
import edu.fiuba.algo3.Modelo.Casillas.Ocupable;

public class Armadura  implements Ocupable,Equipamiento{
    private int energia;
    public Armadura(int energia) {
        this.energia = energia;
    }

   @Override
   public int modificarEnergia(int unaEnergia) {
       return (unaEnergia + energia);
   }

    @Override
    public Gladiador interactuarConLaOcupacion(Gladiador unGladiador) {
        unGladiador.agregarEquipamiento(this);
        System.out.println("\n===> Se agrega una Armadura al Equipamiento");
        return  unGladiador;
    }


}
