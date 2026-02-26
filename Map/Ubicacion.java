package Map;

import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    private int id;
    private String descripcion;
    private Map<String,Integer> exists;


    public Ubicacion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.exists = new HashMap<>();
    }

    public void addExit(String direccion, int idUbicacion){
        exists.put(direccion,idUbicacion);
    }

    //getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Map<String, Integer> getExists() {
        return exists;
    }

    public void setExists(Map<String, Integer> exists) {
        this.exists = exists;
    }
}
