package Set;

import java.util.*;

public class Main {
    static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {
        Planeta mercurio = new Planeta("Mercurio", 88);
        Planeta venus = new Planeta("Venus", 225);
        Planeta tierra = new Planeta("Tierra", 365);
        Planeta marte = new Planeta("Marte", 687);
        Planeta jupiter = new Planeta("Jupiter", 4332);
        Planeta saturno = new Planeta("Saturno", 10759);
        Planeta urano = new Planeta("Urano", 30660);
        Planeta neptuno = new Planeta("Neptuno", 165);
        Planeta pluton = new Planeta("Pluton", 248);

        sistemaSolar.put(mercurio.getNombre(), mercurio);
        planetas.add(mercurio);
        sistemaSolar.put(venus.getNombre(), venus);
        planetas.add(venus);
        sistemaSolar.put(tierra.getNombre(), tierra);
        planetas.add(tierra);
        sistemaSolar.put(marte.getNombre(), marte);
        planetas.add(marte);
        sistemaSolar.put(jupiter.getNombre(), jupiter);
        planetas.add(jupiter);
        sistemaSolar.put(saturno.getNombre(), saturno);
        planetas.add(saturno);
        sistemaSolar.put(urano.getNombre(), urano);
        planetas.add(urano);
        sistemaSolar.put(neptuno.getNombre(), neptuno);
        planetas.add(neptuno);
        sistemaSolar.put(pluton.getNombre(), pluton);
        planetas.add(pluton);

        // x. Crea un planeta Plutón-884. Imprime de nuevo los planetas utilizando el metodo
        //sobreescrito toString. ¿Se ha agregado este planeta al conjunto? ¿Por qué?
        // no se ha agregado al conjunto porque el set no permite elementos duplicados.
        // ademas, el conjunto se define con el equals de la clase CuerpoCeleste donde se consideran iguales
        // los dos elementos si son del mismo nombre y tipo
        Planeta pluton884 = new Planeta("Pluton", 884);
        sistemaSolar.put(pluton884.getNombre(), mercurio);
        planetas.add(pluton884);
        // ¿Y si lo creamos como un planeta enano en vez de un planeta?
        // en este casi si se podria ya que son de distinto tipo
        PlanetaEnano plutonEna884 = new PlanetaEnano("Pluton", 884);
        sistemaSolar.put(plutonEna884.getNombre(), mercurio);
        planetas.add(plutonEna884);

        Luna luna = new Luna("Luna", 27);
        Luna deimos = new Luna("Deimos", 1.3);
        Luna phobos = new Luna("Phobos", 0.3);
        Luna io = new Luna("Io", 1.8);
        Luna europa = new Luna("Europa", 3.5);
        Luna ganymede = new Luna("Ganymede", 7.1);
        Luna callisto = new Luna("Callisto", 16.7);

        sistemaSolar.put(luna.getNombre(), luna);
        tierra.addSatelite(luna);
        tierra.addSatelite(jupiter);

        sistemaSolar.put(deimos.getNombre(), deimos);
        marte.addSatelite(deimos);
        sistemaSolar.put(phobos.getNombre(), phobos);
        marte.addSatelite(phobos);

        sistemaSolar.put(io.getNombre(), io);
        jupiter.addSatelite(io);
        sistemaSolar.put(europa.getNombre(), europa);
        jupiter.addSatelite(europa);
        sistemaSolar.put(ganymede.getNombre(), ganymede);
        jupiter.addSatelite(ganymede);
        sistemaSolar.put(callisto.getNombre(), callisto);
        jupiter.addSatelite(callisto);

        System.out.println("Planetas:\n");
        for (CuerpoCeleste planeta : planetas)
            System.out.println(planeta);
        System.out.println("\nLunas de marte:\n");
        for (CuerpoCeleste lunas : marte.getSatelites()) {
            System.out.println(lunas);
        }

        Set<CuerpoCeleste> union = new HashSet<>();

        System.out.println("\nUnion: \n");
        for (CuerpoCeleste unionLunas : sistemaSolar.values()) {
            union.addAll(unionLunas.getSatelites());
        }
        for (CuerpoCeleste lunas : union)
            System.out.println(lunas);

        Set<CuerpoCeleste> interseccion = new HashSet<>();
        for(CuerpoCeleste inter)

    }
}
