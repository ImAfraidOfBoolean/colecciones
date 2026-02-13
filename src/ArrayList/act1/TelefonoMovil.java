package ArrayList.act1;

import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();;
    }

    public boolean addNewContact(Contacto contacto) {
        if (findContact(contacto.getName())>=0)
            return false;
        myContacts.add(contacto);
        return true;
    }

    public boolean updateContact(Contacto oldCont, Contacto newCont){
        if (findContact(oldCont)==-1)
            return false;
        myContacts.set(myContacts.indexOf(oldCont),newCont);
        return true;
    }

    public boolean removeContact(Contacto contacto){
        if (findContact(contacto)==-1)
            return false;
        myContacts.remove(contacto);
        return true;
    }

    private int findContact(Contacto contacto){
            return myContacts.indexOf(contacto);
    }
    private int findContact(String nombre) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contacto c = this.myContacts.get(i);
            if (c.getName().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public Contacto queryContact (String name){
        if (findContact(name) == -1)
            return null;
        return myContacts.get(findContact(name));
    }

    public void printContacts() {
        if (myContacts.isEmpty())
            System.out.println("Array vacio");
        else
            for (Contacto contacto : myContacts)
                System.out.println(contacto.getName()+" --> "+ contacto.getPhoneNumber());
        System.out.println();
    }

}
