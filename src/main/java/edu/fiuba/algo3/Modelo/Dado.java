package edu.fiuba.algo3.Modelo;
import java.util.Random;

public class Dado {

    public int tirar() {
        //return lanzarDado(); //devuelve un valor entre 1 y 6
        return 1;
    }

    public static int lanzarDado() {
        Random random = new Random();
        // El método nextInt(n) devuelve un valor entre 0 (inclusive) y n (exclusive).
        // Sumamos 1 para obtener un valor entre 1 y 6.
        return random.nextInt(6) + 1;
    }
}
