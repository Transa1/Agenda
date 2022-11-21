import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Persona p = new Persona();
        String opcion;
        //if(!configuracion.exist()){
        //}
        boolean rep = true;

        do {
            opcion = JOptionPane.showInputDialog("Ingrese la primera letra de la opcion\nAgregar personas\nVer contactos\nSalir");
            opcion = opcion.toUpperCase();
            if (opcion.compareTo("A") == 0) {
                p.agregarPersona();
                p.guardar();
            }
            else if (opcion.compareTo("S") == 0) {
                rep = false;
            }
            else if(opcion.compareTo("V") == 0){
                p.verContactos();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ingrese un valor valido");
            }
        }while (rep);
    }
}

