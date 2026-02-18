package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> cancion;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.cancion = new ArrayList<Cancion>();
    }

    private Cancion findSong(String titulo){
        for (int i = 0; i < cancion.size(); i++) {
            if (cancion.get(i).getTitulo().equals(titulo)) {
                return cancion.get(i);
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion){
        if(findSong(titulo) == null){
            cancion.add(new Cancion(titulo, duracion));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int pista, LinkedList<Cancion> playList){
        if(pista>=0 && pista<=cancion.size()) {
            if(!playList.contains(cancion.get(pista))){
                playList.add(cancion.get(pista));
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> playList){
        if(findSong(titulo) != null){
            if(!playList.contains(findSong(titulo))) {
                playList.add(findSong(titulo));
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nombre='" + nombre + '\'' +
                ", artista='" + artista + '\'' +
                ", cancion=" + cancion +
                '}';
    }
}
