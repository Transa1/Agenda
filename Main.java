import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    //static String[] contacts = {"Nombres", "Ejemplo", "Pedro"};
    static JComboBox contactos;
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
            final String[]hayContacto = new String[1];
            hayContacto[0] = "Si";
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
                frame.setVisible(false);
                try {
                    p.agregarPersona();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    p.guardar();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            });
            borrarContactos.addActionListener(e -> {
                frame.setVisible(false);
                p.borrarContacto();
                frame.setVisible(true);
            });
            importarContactos.addActionListener(e -> {
                frame.setVisible(false);
                try {
                    p.importar();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            });
            exportarContactos.addActionListener(e -> {
                frame.setVisible(false);
                try {
                    p.exportar();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(true);
            });
            verContactos.addActionListener(e -> {
                frame.setVisible(false);
                try {
                    contactos = new JComboBox(p.lecturaNombre());//se convierte en el arreglo de nombres
                } catch (IOException ex) {
                   JOptionPane.showMessageDialog(null,"No hay ningun contacto en la agenda!");
                   hayContacto[0] = "No";
                }
                if(hayContacto[0].compareTo("Si")==0){
                    JFrame frameContactos = new JFrame();
                    frameContactos.setSize(300, 250);
                    frameContactos.setLayout(null);
                    frameContactos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameContactos.setResizable(false);
                    frameContactos.getContentPane().setBackground(new Color(46, 112, 161));
                    frameContactos.setVisible(true);
                    frameContactos.add(contactos);
                    JTextArea selecContacto = new JTextArea("Seleccione el\n   Contacto");
                    selecContacto.setBounds(60,20,260,150);
                    selecContacto.setFont(new Font("Times New Roman", Font.BOLD, 30));
                    selecContacto.setBackground(new Color(46, 112, 161));
                    selecContacto.setEditable(false);
                    selecContacto.setLineWrap(false);
                    selecContacto.setWrapStyleWord(true);
                    selecContacto.setVisible(true);
                    frameContactos.add(selecContacto);
                    final String[] band = new String[1];
                    contactos.setBounds(50,150,200,50);
                    contactos.addActionListener(E -> {
                        band[0] = "AAA";
                        try {
                            p.verContactos((String) contactos.getSelectedItem());
                            frameContactos.dispose();
                            if(band[0].compareTo("AAA") == 0)frame.setVisible(true);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                }
                else {
                    frame.setVisible(true);
                }
            });
            salir.addActionListener(e -> System.exit(0));
    }
}
