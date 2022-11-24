import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Persona p = new Persona();
        JFrame frame = new JFrame();
        JTextArea AjenDon = new JTextArea("Bienvenido al AjenDon");
        JButton agregarContactos = new JButton("Agregar Contactos");
        JButton borrarContactos = new JButton("Borrar Contactos");
        JButton importarContactos = new JButton("Importar Contactos");
        JButton exportarContactos = new JButton("Exportar Contactos");
        JButton verContactos = new JButton("Ver Contactos");
        JButton salir = new JButton("Salir");
        frame.setSize(1110, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(46, 112, 161));
        frame.setVisible(true);
        agregarContactos.setBounds(30, 100, 150, 50); //180 + 30
        borrarContactos.setBounds(210, 100, 150, 50);
        importarContactos.setBounds(390, 100, 150, 50);
        exportarContactos.setBounds(570, 100, 150, 50);
        verContactos.setBounds(750, 100, 150, 50);
        salir.setBounds(930, 100, 150, 50);
        AjenDon.setBounds(400,35,500,50);
        frame.add(agregarContactos);
        frame.add(borrarContactos);
        frame.add(importarContactos);
        frame.add(exportarContactos);
        frame.add(verContactos);
        frame.add(salir);
        frame.add(AjenDon);
        AjenDon.setFont(new Font("Times New Roman", Font.BOLD, 30));
        AjenDon.setBackground(new Color(46, 112, 161));
        AjenDon.setEditable(false);
        AjenDon.setLineWrap(false);
        AjenDon.setWrapStyleWord(true);

        agregarContactos.addActionListener(e -> {
            p.agregarPersona();
            try {
                p.guardar();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        borrarContactos.addActionListener(e -> p.borrarContacto());
        importarContactos.addActionListener(e -> {
            try {
                p.importar();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        exportarContactos.addActionListener(e -> {
            try {
                p.exportar();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        verContactos.addActionListener(e -> {
            try {
                p.verContactos();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        salir.addActionListener(e -> System.exit(0));
    }
}
