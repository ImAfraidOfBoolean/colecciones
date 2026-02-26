package Map;

import java.util.*;

public class Main {
    private Map<Integer,Ubicacion> ubicaciones = new HashMap<>();

    public Main() {
        ubicaciones.put(0,new Ubicacion(0,"Estás sentado en la clase de programación"));
        ubicaciones.put(1,new Ubicacion(1,"Estás en la cima de una montaña"));
        ubicaciones.put(2,new Ubicacion(2,"Estás bañándote en la playa"));
        ubicaciones.put(3,new Ubicacion(3,"Estás dentro de un edificio muy alto"));
        ubicaciones.put(4,new Ubicacion(4,"Estás de pie en un puente"));
        ubicaciones.put(5,new Ubicacion(5,"Estás en un bosque"));

        ubicaciones.get(1).addExit("N",5);
        ubicaciones.get(1).addExit("S",4);
        ubicaciones.get(1).addExit("E",2);
        ubicaciones.get(1).addExit("O",3);

        ubicaciones.get(2).addExit("N",5);

        ubicaciones.get(3).addExit("O",1);

        ubicaciones.get(4).addExit("N",1);
        ubicaciones.get(4).addExit("O", 2);

        ubicaciones.get(5).addExit("O",2);
        ubicaciones.get(5).addExit("S",1);

        for(int i = 0; i<=5; i++){
            ubicaciones.get(i).addExit("Q",0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        String valor = "";
        int id = 1;

        do {
            try {
                System.out.println(main.ubicaciones.get(id).getDescripcion());
                System.out.print("Tus salidas validas son: ");
                for (String dir : main.ubicaciones.get(id).getExists().keySet()) {
                    System.out.print(dir + " ");
                }
                System.out.println();

                valor = sc.nextLine().toUpperCase();
                if(main.ubicaciones.get(id).getExists().containsKey(valor)){
                    id = main.ubicaciones.get(id).getExists().get(valor);
                }
                else throw new InputMismatchException(String.format("Valor '%s' es invalido", valor));
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }while (!valor.equalsIgnoreCase("Q"));
        System.out.println("Has salido del programa");
    }

// getters & setters

    public Map<Integer, Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(Map<Integer, Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
}
