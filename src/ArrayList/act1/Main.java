package ArrayList.act1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TelefonoMovil telefonoMovil = new TelefonoMovil("1234123");
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        boolean salir = false;
        boolean volverImp = true;
        String name;
        String phoneNumber;
        while (!salir) {
            if (volverImp) {
                System.out.print("""
                        
                        1. Imprimir contacto
                        2. add contacto
                        3. update contacto
                        4. remove contacto
                        5. find contacto
                        6. volver a imprimir la lista de opciones
                        
                        """);
                volverImp = false;
            }
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    System.out.println();
                    telefonoMovil.printContacts();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    name = sc.nextLine();
                    System.out.print("\nTelefono: ");
                    phoneNumber = sc.nextLine();

                    telefonoMovil.addNewContact(Contacto.createContact(name, phoneNumber));

                    break;

                case 3:
                    System.out.print("Nombre: ");
                    name = sc.nextLine();

                    if (telefonoMovil.queryContact(name) != null) {
                        System.out.print("Nuevo Nombre: ");
                        String newName = sc.nextLine();
                        System.out.print("\nNuevo Telefono: ");
                        phoneNumber = sc.nextLine();
                        telefonoMovil.updateContact(telefonoMovil.queryContact(name), Contacto.createContact(newName, phoneNumber));
                    } else
                        System.out.printf("el valor '%s' no existe\n", name);
                    break;
                case 4:
                    System.out.print("Nombre: ");
                    name = sc.nextLine();
                    if (telefonoMovil.removeContact(telefonoMovil.queryContact(name))) {
                        telefonoMovil.removeContact(telefonoMovil.queryContact(name));
                        System.out.println("\nSe ha eliminado correctamente");
                    } else
                        System.out.printf("el valor '%s' no existe\n", name);
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    name = sc.nextLine();
                    Contacto contacto = telefonoMovil.queryContact(name);
                    if (telefonoMovil.queryContact(name) != null)
                            System.out.printf("Nombre: %s \n Numero de telefono: %s", name, contacto.getPhoneNumber());
                    else
                        System.out.printf("el valor '%s' no existe\n", name);
                    break;
                case 6:
                    volverImp = true;
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + menu);
            }
        }
    }
}
