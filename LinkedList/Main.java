package LinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Midnight Signals", "Ethan Blackwood");
        Album album2 = new Album("Waves of Tomorrow", "Lily Hart");
        ArrayList<Album> albums = new ArrayList<>();
        album1.addSong("Neon Skies", 3.9);
        album1.addSong("Echoes in the Dark", 4.4);
        album1.addSong("Last Train Home", 5d);
        album1.addSong("City of Static", 3.91);
        album1.addSong("Broken Satellites", 4.2);

        album2.addSong("Golden Horizon", 4.21);
        album2.addSong("Fading Footsteps", 3.41);
        album2.addSong("Chasing the Sunrise", 3.4);
        album2.addSong("Driftwood Dreams", 4.3);
        album2.addSong("Tides Between Us", 3.7);

        albums.add(album1);
        albums.add(album2);

        LinkedList<Cancion> playList = new LinkedList<>();

        album1.addToPlayList("Neon Skies", playList);
        album1.addToPlayList("aaaa", playList); // no se añade
        album1.addToPlayList(1, playList);
        album1.addToPlayList(0, playList);// no se añade
        album1.addToPlayList("City of Static", playList);
        album2.addToPlayList("djkal", playList); // no se añade
        album2.addToPlayList("Golden Horizon", playList);
        album2.addToPlayList("Golden Horizon", playList); // no se añade
        album2.addToPlayList(3, playList);

        printSong(playList);
        System.out.println();
        play(playList);


    }

    public static void printSong(LinkedList<Cancion> playList) {
        ListIterator<Cancion> it = playList.listIterator();
        int index = 1;
        System.out.println("Canciones de la playlist: ");
        if (playList.isEmpty()) {
            System.out.println("vacio");
        }
        while (it.hasNext()) {
            System.out.printf("%s. %s%n", index, it.next());
            index++;
        }
    }

    public static void play(LinkedList<Cancion> playList) {
        boolean salir = false;
        boolean mostrarMenu = true;
        boolean haciaAdelante = true;
        Scanner sc = new Scanner(System.in);
        ListIterator<Cancion> it = playList.listIterator();

        if (it.hasNext()) {
            System.out.printf("Reproduciendo: %s%n%n", it.next());
        }
        while (!salir) {
            try {
                if (playList.isEmpty())
                    System.out.println("vacio");
                if (mostrarMenu)
                    menu();

                System.out.print("Introduce un valor: ");
                int opc = sc.nextInt();
                switch (opc) {
                    case 0:
                        salir = true;
                        break;
                    case 1:
                        if (!haciaAdelante) {
                            if (it.hasNext())
                                it.next();
                            haciaAdelante = true;
                        }
                        if (it.hasNext()) {
                            System.out.printf("Reproduciendo: %s%n%n", it.next());
                        } else {
                            System.out.println("Has llegado al final");
                        }
                        break;
                    case 2:
                        if (haciaAdelante) {
                            if (it.hasPrevious())
                                it.previous();
                            haciaAdelante = false;
                        }
                        if (it.hasPrevious()) {
                            System.out.printf("Reproduciendo: %s%n%n", it.previous());

                        } else {
                            System.out.println("Has llegado al inicio");
                        }
                        break;
                    case 3:
                        if (haciaAdelante) {
                            if (it.hasPrevious()) {
                                System.out.printf("Reproduciendo: %s%n%n", it.previous());
                                haciaAdelante = false;
                            }
                        } else {
                            if (it.hasNext()) {
                                System.out.printf("Reproduciendo: %s%n%n", it.next());
                                haciaAdelante = true;
                            }
                        }
                        break;
                    case 4:
                        printSong(playList);
                        break;
                    case 5:
                        mostrarMenu = true;
                        break;

                    case 6:
                        it.remove();
                        if (it.hasNext()) {
                            System.out.printf("Reproduciendo: %s%n%n", it.next());

                        } else if (it.hasPrevious()) {
                            System.out.printf("Reproduciendo: %s%n%n", it.previous());

                        } else {
                            System.out.println("La playlist está vacía.");
                        }
                        break;
                    default:
                        throw new InputMismatchException("Unexpected value: " + opc);
                }
                mostrarMenu = false;

            } catch (IllegalStateException | InputMismatchException e) {
                if (e.getMessage() == null) {
                    System.out.println("Unexpected value");
                    sc.nextLine();
                } else
                    System.out.println(e.getMessage());
            }
        }
        System.out.println("Has salido del programa");
    }

    public static void menu() {
        System.out.println("""
                0 – Salir de la lista de reproducción\s
                1 – Reproducir siguiente canción en la lista\s
                2 – Reproducir la canción previa de la lista \s
                3 – Repetir la canción actual\s
                4 – Imprimir la lista de playList en la playlist\s
                5 – Volver a imprimir el menú.\s
                6 - Eliminar canción actual de la playlist\s
                """);
    }
}
