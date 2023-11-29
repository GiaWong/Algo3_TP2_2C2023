package edu.fiuba.algo3.Modelo.ManejarJson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeserializadorJSON {

    public int extraerValorAnchoDelMapa(String rutaArchivoJson) {

        try {

            String json = new String(Files.readAllBytes(Paths.get(rutaArchivoJson)));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode mapaNode = rootNode.get("mapa");
            return mapaNode.get("ancho").asInt();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
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
}
