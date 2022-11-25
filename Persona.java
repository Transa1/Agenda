import javax.swing.*;
import java.io.*;

public class Persona {
    String nombre, facebook, twitter, instagram, correoElectronico, comentarios, direccion; //Variables de los contactos
    String []tipoContacto = {"Amigo", "Conocido", "Compañero"}; // 1.- amigo 2.- conocido 3.-compañero
    String []nombres = new String[100];
    int temp; //Variable para acceder al tipo de contacto
    String numeroTelefono;
    String path, pathImportar; //Variable de donde quieres guardar los contactos
    String tipo; //Tipo de contacto

    public Persona() throws IOException { //TODO Constructor de la agenda
        //TODO Crea un archivo en una direccion que solo nosotros conozcamos (Por Ejemplo:   c:/Direccion/direccion.txt)
        File f = new File("C:/Direccion/"); //TODO Definimos en donde se localizara la carpeta de configuracion
        if(!f.exists()){
            f.mkdirs(); //Si no existe la carpeta entonces la creamos
            f = new File("C:/Direccion/direccion.txt");//Creamos el archivo de configuracion
            //Guardamos la direccion de memoria que diga el usuario:
            path = JOptionPane.showInputDialog("Ingrese la ruta de memoria para guardar sus contactos \n Ejemplo: C:/agenda");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(path);//Escribimos la direccion en el archivo
            bw.flush();//guardamos el archivo
            bw.close();//cerramos el archivo
        }
        else{//TODO si ya hay un archivo de configuracion entonces accede a el para ver cual es la direccion de memoria
            f = new File("C:/Direccion/direccion.txt");//Abrimos el archivo
            BufferedReader br = new BufferedReader(new FileReader(f));
            path = br.readLine();//Leemos la direccion de memoria y la asignamos a la vairable path
        }
    }
    void registroNombres(String nombre) throws IOException {
        File f = new File("C:/Direccion/nombres.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
        bw.newLine();
        bw.write(nombre);
        bw.flush();
        bw.close();
    }
    String[] lecturaNombre() throws IOException {
        int i = 0;
        File f = new File("C:/Direccion/nombres.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        while (true){
            nombres[i] = br.readLine();
            if(nombres[i] == null){
             break;
            }
            i++;
        }
        return nombres;
    }
    void verContactos(String name) throws IOException { //TODO Metodo para ver los contactos de la agenda
        //nombre = JOptionPane.showInputDialog("Que contacto quieres ver sus datos?"); //Solicitamos el nombre del contacto
        File f = new File(path + name + ".txt"); //Abrimos el archivo
        if(!f.exists()){
            JOptionPane.showMessageDialog(null,"El contacto no esta en el AjenDon");//Si no existe el contacto lo avisa
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(f));
        nombre = br.readLine();//Leemos el numero de telefono
        numeroTelefono = br.readLine(); //Leemos su numero de telefono
        twitter = br.readLine(); //Leemos su twitter
        facebook = br.readLine();//Leemos su Facebook
        instagram = br.readLine();//Leemos su Instagram
        tipo = br.readLine(); //Leemos que tipo de contacto es
        comentarios = br.readLine(); // Leemos sus comentarios
        correoElectronico = br.readLine(); //Leemos el correo electornico
        direccion = br.readLine(); //Leemos la direccion
        //TODO Mostramos las variables de los datos en un MessageDialog
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\n" + "Numero de telefono: " + numeroTelefono + "\n" + "Twitter: " + twitter + "\n" + "Facebook: " + facebook + "\n" +  "Instagram: " + instagram + "\n" + "Tipo: " + tipo + "\n" + "Comentarios: " + comentarios + "\n" + "Correo Electronico: " + correoElectronico + "\n" + "Direccion: " + direccion);
    }

    void agregarPersona() throws IOException { //TODO Metodo para agregar personas a la agenda
        //Solicitamos los datos al usuario
        nombre = JOptionPane.showInputDialog("Ingrese el nombre a agregar");
        registroNombres(nombre);
        numeroTelefono = JOptionPane.showInputDialog("Ingrese el numero de telefono");
        twitter = JOptionPane.showInputDialog("Ingrese el usuario de Twitter del contacto");
        facebook = JOptionPane.showInputDialog("Ingrese el usuario de Facebook del contacto");
        instagram = JOptionPane.showInputDialog("Ingrese el usuario de Instagram del contacto");
        correoElectronico = JOptionPane.showInputDialog("Ingrese el correo electrónico");
        comentarios = JOptionPane.showInputDialog("Ingrese algún comentario");
        temp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de contacto(1-Amigo, 2-Conocido, 3-Compañero)"));
        direccion = JOptionPane.showInputDialog("Ingrese la dirección del contacto");
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
        JOptionPane.showMessageDialog(null,"¡Contacto guardado con éxito!");//Avisamos al usuario que se guardó el usuario
    }
    void importar() throws IOException { //TODO Metodo para importar contactos
        //Solicitamos la direccion de memoria a importar
        pathImportar = JOptionPane.showInputDialog("Ingrese la ruta de memoria en donde se encuentra el contacto a importar \n Ejemplo: C:/agenda/");
        //Solicitamos el nombre del contacto
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto");
        File f = new File(pathImportar + nombre + ".txt"); //Abrimos el archivo
        if(!f.exists()){
            JOptionPane.showMessageDialog(null,"No se encontró el archivo");//Si no existe el archivo avisa de que no lo encontró
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(f));
        nombre = br.readLine(); //Leemos su nombre
        numeroTelefono = br.readLine(); //Leemos su numero de telefono
        twitter = br.readLine(); //Leemos su Twitter
        facebook = br.readLine();//Leemos su Facebook
        instagram = br.readLine();//Leemos su Instagram
        tipo = br.readLine(); //Leemos que tipo de contacto es
        comentarios = br.readLine(); //Leemos sus comentarios
        br.close();
        File F = new File(path + nombre + ".txt");//TODO Creamos un nuevo archivo dentro de nuestra carpeta de contactos
        BufferedWriter bw = new BufferedWriter(new FileWriter(F));
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
        bw.write(tipo); //Escribimos que tipo de contacto es (temp - 1 es por que los arreglos comienzan desde 0 y preguntamos por 1.- amigo 2.- compañero 3.- conocido)
        bw.newLine(); //Damos salto de linea
        bw.write(comentarios); // Escribimos sus comentarios
        bw.flush();//Guardamos el archivo
        bw.close();//Cerramos el archivo
        JOptionPane.showMessageDialog(null,"¡Contacto importado con éxito!"); //Avisamos al usuario que se importó con éxito
    }

    void exportar() throws IOException { //TODO Metodo que exporta los contactos
        //Preguntamos que contacto vamos a exportar
        nombre = JOptionPane.showInputDialog("¿Que contacto quiere exportar?");
        File f = new File(path + nombre + ".txt"); //Creamos un archivo .txt con el nombre dado por el usuario
        if(!f.exists()){
            JOptionPane.showMessageDialog(null,"No se encontró el archivo"); //Avisamos si no encontramos el contacto
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(f));
        nombre = br.readLine();//Leemos el nombre
        numeroTelefono = br.readLine(); //Leemos su numero de telefono
        twitter = br.readLine(); //Leemos su Twitter
        facebook = br.readLine();//Leemos su Facebook
        instagram = br.readLine();//Leemos su Instagram
        tipo = br.readLine(); //Leemos que tipo de contacto es
        comentarios = br.readLine(); //Leemos sus comentarios
        f = new File(path + nombre + " Exportado" + ".txt"); //TODO Creamos el contacto exportado
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
        bw.flush();//Guardamos el archivo
        bw.close();//Cerramos el archivo
        JOptionPane.showMessageDialog(null,"¡Contacto exportado con éxito!");//Avisamos que fue exportado con éxito
    }
    void borrarContacto(){//TODO Metodo para borrar contactos
        nombre = JOptionPane.showInputDialog("Que contacto desea borrar?");//Preguntamos por el contacto a borrar
        File f = new File(path + nombre + ".txt"); //Abrimos el archivo
        if(!f.exists()){
            JOptionPane.showMessageDialog(null,"No se encontro el archivo");
            return;
        }
        f.delete(); //Borramos el archivo
        JOptionPane.showMessageDialog(null,"¡Contacto borrado con éxito!");//Avisamos que fue borrado con éxito
    }
}


