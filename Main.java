import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Persona p = new Persona();
        String opcion;
        boolean rep = true;

        do {
            opcion = JOptionPane.showInputDialog("Ingrese la priemra letra de la opcion\nAgregar personas\nSalir");
            if (opcion.compareTo("A") == 0) {
                p.agregarPersona();
                p.guardar();
            }
            if (opcion.compareTo("S") == 0) {
                rep = false;
            }
        }while (rep);
    }
}
