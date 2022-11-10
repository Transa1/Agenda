import javax.swing.*;
import java.io.*;

public class Persona {
    String nombre, redesSociales, correoElectronico, comentarios, direccion;
    String []tipoContacto = {"Amigo", "Conocido", "Compañero"}; // 1.- amigo 2.- conocido 3.-compañero
    int temp; //tipoContacto[temp]
    String numeroTelefono;

    void agregarPersona(){
        nombre = JOptionPane.showInputDialog("Ingrese el nombre a agregar");
        redesSociales = JOptionPane.showInputDialog("Ingrese las redes sociales separadas por espacios");
        correoElectronico = JOptionPane.showInputDialog("Ingrese el correo electrónico");
        comentarios = JOptionPane.showInputDialog("Ingrese algun comentario");
        direccion = JOptionPane.showInputDialog("Ingrese la direccion");
        temp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de contacto(1-Amigo, 2-Conocido, 3-Compañero)"));
        numeroTelefono = JOptionPane.showInputDialog("Ingrese el numero de telefono");
    }
    void guardar() throws IOException { //Funcion que Guarda los datos por el usuario en una carpeta en el escritorio
        File f = new File("C:/Users/kevin/Desktop/Agenda/"); // Definimos en donde se localizara la carpeta
        if(!f.exists())f.mkdirs(); //Si no existe la carpeta entonces la creamos
        f = new File("C:/Users/kevin/Desktop/Agenda/" + nombre + ".txt"); //Creamos un archivo .txt con el nombre dado por el usuario
        BufferedWriter bw = new BufferedWriter(new FileWriter(f)); //Creamos un BufferedWriter para escribir en el documento
        bw.write(nombre); //Escribimos el nombre
        bw.newLine(); //Damos salto de linea
        bw.write(redesSociales); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(correoElectronico); //Escribimos el correo electornico
        bw.newLine(); //Damos salto de linea
        bw.write(comentarios); // Escribimos sus comentarios
        bw.newLine(); //Damos salto de linea
        bw.write(direccion); //Escribimos su direccion
        bw.newLine(); //Damos salto de linea
        bw.write(tipoContacto[temp-1]); //Escribimos que tipo de contacto es (temp - 1 es por que los arreglos comienzan desde 0 y preguntamos por 1.- amig 2.- compañero 3.- conocido)
        bw.newLine();//Damos salto de linea
        bw.write(numeroTelefono); //Escribimos su numero de telefono
        bw.flush(); //Guardamos el documento
        bw.close(); //Cerramos el documento
    }
}

