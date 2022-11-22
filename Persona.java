import javax.swing.*;
import java.io.*;

public class Persona {
    String nombre, facebook, twitter, instagram, correoElectronico, comentarios, direccion;
    String []tipoContacto = {"Amigo", "Conocido", "Compañero"}; // 1.- amigo 2.- conocido 3.-compañero
    int temp; //tipoContacto[temp]
    String numeroTelefono;
    String path, pathImportar;
    String tipo;

    public Persona() throws IOException {
        //crear un archivo en una direccion que solo nosotros conozcamos c:/Direccion/direccion.txt
        // variable path
        // direccion.exist();
        //leer la direccion buffered reader
        File f = new File("C:/Direccion/"); // Definimos en donde se localizara la carpeta
        if(!f.exists()){
            f.mkdirs(); //Si no existe la carpeta entonces la creamos
            f = new File("C:/Direccion/direccion.txt");
            path = JOptionPane.showInputDialog("Ingrese la ruta de memoria para guardar sus contactos \n Ejemplo: C:/agenda");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(path);
            bw.flush();
            bw.close();
        }
        else{
            f = new File("C:/Direccion/direccion.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            path = br.readLine();
        }
    }
    //path = usuario
    //Que contacto quieres ver sus datos?
    //jose
    //path + contacto + .txt exist()
    // else "El contacto no esta en el ajenDon"
    // br.readLine
    void verContactos() throws IOException {
        nombre = JOptionPane.showInputDialog("Que contacto quieres ver sus datos?");
        File f = new File(path);
        f = new File(path + nombre + ".txt");
        if(!f.exists())JOptionPane.showMessageDialog(null,"El contacto no esta en el AjenDon");
        BufferedReader br = new BufferedReader(new FileReader(f));
        nombre = br.readLine();
        numeroTelefono = br.readLine(); //Escribimos su numero de telefono
        twitter = br.readLine(); //Escribimos las redes sociales
        facebook = br.readLine();
        instagram = br.readLine();
        tipo = br.readLine(); //Escribimos que tipo de contacto es (temp - 1 es por que los arreglos comienzan desde 0 y preguntamos por 1.- amig 2.- compañero 3.- conocido)
        comentarios = br.readLine(); // Escribimos sus comentarios
        correoElectronico = br.readLine(); //Escribimos el correo electornico
        direccion = br.readLine();

        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\n" + "Numero de telefono: " + numeroTelefono + "\n" + "Twitter: " + twitter + "\n" + "Facebook: " + facebook + "\n" +  "Instagram: " + instagram + "\n" + "Tipo: " + tipo + "\n" + "Comentarios: " + comentarios + "\n" + "Correo Electronico: " + correoElectronico + "\n" + "Direccion: " + direccion);
    }

    void agregarPersona() {
        nombre = JOptionPane.showInputDialog("Ingrese el nombre a agregar");
        numeroTelefono = JOptionPane.showInputDialog("Ingrese el numero de telefono");
        twitter = JOptionPane.showInputDialog("Ingrese el usuario de Twitter del contacto");
        facebook = JOptionPane.showInputDialog("Ingrese el usuario de Facebook del contacto");
        instagram = JOptionPane.showInputDialog("Ingrese el usuario de Instagram del contacto");
        correoElectronico = JOptionPane.showInputDialog("Ingrese el correo electrónico");
        comentarios = JOptionPane.showInputDialog("Ingrese algun comentario");
        temp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de contacto(1-Amigo, 2-Conocido, 3-Compañero)"));
        direccion = JOptionPane.showInputDialog("Ingres la direccion del contacto");
    }
    void guardar() throws IOException { //Funcion que Guarda los datos por el usuario en una carpeta en el escritorio
        File f = new File(path); // Definimos en donde se localizara la carpeta
        if(!f.exists())f.mkdirs(); //Si no existe la carpeta entonces la creamos
        f = new File(path + nombre + ".txt"); //Creamos un archivo .txt con el nombre dado por el usuario
        BufferedWriter bw = new BufferedWriter(new FileWriter(f)); //Creamos un BufferedWriter para escribir en el documento
        bw.write(nombre); //Escribimos el nombre
        bw.newLine(); //Damos salto de linea
        bw.write(numeroTelefono); //Escribimos su numero de telefono
        bw.newLine();//Damos salto de linea
        bw.write(twitter); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(facebook); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(instagram); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(tipoContacto[temp-1]); //Escribimos que tipo de contacto es (temp - 1 es por que los arreglos comienzan desde 0 y preguntamos por 1.- amig 2.- compañero 3.- conocido)
        bw.newLine(); //Damos salto de linea
        bw.write(comentarios); // Escribimos sus comentarios
        bw.newLine();
        bw.write(correoElectronico); //Escribimos el correo electornico
        bw.newLine(); //Damos salto de linea
        bw.write(direccion);
        bw.flush(); //Guardamos el documento
        bw.close(); //Cerramos el documento
        JOptionPane.showMessageDialog(null,"¡Contacto guardado con éxito!");
    }
    void importar() throws IOException {
        pathImportar = JOptionPane.showInputDialog("Ingrese la ruta de memoria en donde se encuentra el contacto a importar \n Ejemplo: C:/agenda/");
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto");
        File f = new File(pathImportar);
        f = new File(pathImportar + nombre + ".txt");
        if(!f.exists())JOptionPane.showMessageDialog(null,"No se encontró el archivo");
        BufferedReader br = new BufferedReader(new FileReader(f));
        nombre = br.readLine();
        numeroTelefono = br.readLine(); //Escribimos su numero de telefono
        twitter = br.readLine(); //Escribimos las redes sociales
        facebook = br.readLine();
        instagram = br.readLine();
        tipo = br.readLine(); //Escribimos que tipo de contacto es (temp - 1 es por que los arreglos comienzan desde 0 y preguntamos por 1.- amig 2.- compañero 3.- conocido)
        comentarios = br.readLine(); // Escribimos sus comentarios
        System.out.println(nombre);
        System.out.println(numeroTelefono);
        System.out.println(twitter);
        System.out.println(facebook);
        System.out.println(instagram);
        System.out.println(tipo);
        System.out.println(comentarios);
        f = new File(path + nombre + ".txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(nombre); //Escribimos el nombre
        bw.newLine(); //Damos salto de linea
        bw.write(numeroTelefono); //Escribimos su numero de telefono
        bw.newLine();//Damos salto de linea
        bw.write(twitter); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(facebook); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(instagram); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(tipo); //Escribimos que tipo de contacto es (temp - 1 es por que los arreglos comienzan desde 0 y preguntamos por 1.- amig 2.- compañero 3.- conocido)
        bw.newLine(); //Damos salto de linea
        bw.write(comentarios); // Escribimos sus comentarios
        bw.flush();
        bw.close();
        JOptionPane.showMessageDialog(null,"¡Contacto importado con éxito!");
    }

    void exportar() throws IOException {
        nombre = JOptionPane.showInputDialog("¿Que contacto quiere exportar?");
        File f = new File(path); // Definimos en donde se localizara la carpeta
        f = new File(path + nombre + ".txt"); //Creamos un archivo .txt con el nombre dado por el usuario
        if(!f.exists())JOptionPane.showMessageDialog(null,"No se encontró el archivo");
        BufferedReader br = new BufferedReader(new FileReader(f));
        nombre = br.readLine();
        numeroTelefono = br.readLine(); //Escribimos su numero de telefono
        twitter = br.readLine(); //Escribimos las redes sociales
        facebook = br.readLine();
        instagram = br.readLine();
        tipo = br.readLine(); //Escribimos que tipo de contacto es (temp - 1 es por que los arreglos comienzan desde 0 y preguntamos por 1.- amig 2.- compañero 3.- conocido)
        comentarios = br.readLine(); // Escribimos sus comentarios
        f = new File(path + nombre + " Exportado" + ".txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(nombre); //Escribimos el nombre
        bw.newLine(); //Damos salto de linea
        bw.write(numeroTelefono); //Escribimos su numero de telefono
        bw.newLine();//Damos salto de linea
        bw.write(twitter); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(facebook); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(instagram); //Escribimos las redes sociales
        bw.newLine(); //Damos salto de linea
        bw.write(tipo); //Escribimos que tipo de contacto es (temp - 1 es por que los arreglos comienzan desde 0 y preguntamos por 1.- amig 2.- compañero 3.- conocido)
        bw.newLine(); //Damos salto de linea
        bw.write(comentarios); // Escribimos sus comentarios
        bw.flush();
        bw.close();
        JOptionPane.showMessageDialog(null,"¡Contacto exportado con éxito!");
    }
    void borrarContacto(){
        nombre = JOptionPane.showInputDialog("Que contacto desea borrar?");
        File f = new File(path + nombre + ".txt");
        f.delete();
        JOptionPane.showMessageDialog(null,"¡Contacto borrado con éxito!");
    }
}

