package edu.fiuba.algo3.Modelo.ManejarJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiuba.algo3.Modelo.Casillas.*;
import edu.fiuba.algo3.Modelo.Equipamientos.PremioEquipamiento;
import edu.fiuba.algo3.Modelo.Obstaculos.Bacanal;
import edu.fiuba.algo3.Modelo.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.Modelo.Obstaculos.Lesion;
import edu.fiuba.algo3.Modelo.Premios.Comida;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeserializadorJSON {
    List<Casilla> listaCasillas;
    public DeserializadorJSON() {
       listaCasillas = new ArrayList<>();
    }

    public int extraerValorAnchoDelMapa(String rutaArchivoJson) {

        try {

            String json = new String(Files.readAllBytes(Paths.get(rutaArchivoJson)));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode mapaNode = rootNode.get("mapa");
            return mapaNode.get("ancho").asInt();

        } catch (Exception e) {
            e.printStackTrace();
            return -1; //devuelvvo -1 porque el 0 se contempla en el tablero como una posicion mas
        }
    }

    public int extraerValorLargoDelMapa(String rutaArchivoJson) {

        try {

            String json = new String(Files.readAllBytes(Paths.get(rutaArchivoJson)));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode mapaNode = rootNode.get("mapa");
            return mapaNode.get("largo").asInt();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }



    public void extraerContenidoDeCadaCelda(String rutaArchivoJson) {

        try {

            String json = new String(Files.readAllBytes(Paths.get(rutaArchivoJson)));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode celdas = rootNode.get("camino").get("celdas");

            for (JsonNode celda : celdas) {

                int posX = celda.get("x").asInt();
                int posY = celda.get("y").asInt();
                String obstaculo = celda.get("obstaculo").asText().toUpperCase();
                String premio = celda.get("premio").asText().toUpperCase();

                //System.out.println("\n\t------------");
                Casilla casillaActual = new Casilla(transformarAObjeto(obstaculo), transformarAObjeto(premio),posX,posY);
                listaCasillas.add(casillaActual);

            }


        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    private Ocupable transformarAObjeto(String nombreActual) {

        if (nombreActual.equalsIgnoreCase("Lesion")) {
           // System.out.println("\nConvirtiendo a clase Lesion()");
            return new Lesion();

        } else if (nombreActual.equalsIgnoreCase("Fiera")) {
            //System.out.println("\nConvirtiendo a clase FieraSalvaje()");
            return new FieraSalvaje(5);

        } else if (nombreActual.equalsIgnoreCase("Bacanal")) {
            //System.out.println("\nConvirtiendo a clase Bacanal()");
            return new Bacanal();

        } else if (nombreActual.equalsIgnoreCase("Equipamiento")) {
            //System.out.println("\nConvirtiendo a clase Equipamiento");
            return new PremioEquipamiento();

        } else if (nombreActual.equalsIgnoreCase("Comida")) {
            //System.out.println("\nConvirtiendo a clase Comida");
            return new Comida(15);

        } else {
            //System.out.println("\nConvirtiendo a clase NadaOcupacion()");
            return new NadaOcupacion();
        }


    }

    public int cantidadCeldasDeserealizadas() {
        return  listaCasillas.size();
    }

    public List<Casilla> obtenerListaCasillas() {
        return  listaCasillas;
    }
}
