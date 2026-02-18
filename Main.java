package LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        boolean continuar = true;

        Album album1 = new Album("Midnight Signals","Ethan Blackwood");
        Album album2 = new Album("Waves of Tomorrow","Lily Hart");
        ArrayList<Album> albums = new ArrayList<>();
        album1.addSong("Neon Skies", 3.9);
        album1.addSong("Echoes in the Dark", 4.4);
        album1.addSong("Last Train Home", 5.1);

        album2.addSong("Golden Horizon", 4.21);
        album2.addSong("Fading Footsteps", 3.41);
        album2.addSong("Chasing the Sunrise", 3.4);

        albums.add(album1);
        albums.add(album2);

        // ELIMINAR
        Iterator<Album> it = albums.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        LinkedList<Cancion> canciones = new LinkedList<>();

        album1.addToPlayList("Neon Skies",canciones);
        album1.addToPlayList(1,canciones);
        album1.addToPlayList(0,canciones);
        album2.addToPlayList("djkal", canciones);
        printSong(canciones);
    }

    public static void printSong(LinkedList<Cancion> canciones){
        ListIterator<Cancion> it = canciones.listIterator();

        if(canciones.isEmpty()){
            System.out.println("vacio");
        }
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
