package src.Interfaces;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import src.Modelo.Usuarios.Administrador;
import src.Modelo.Usuarios.Participante;
import src.Modelo.Usuarios.Usuario;
import src.Vista.App;

public class Login extends JFrame {

    static JLabel correo_electronico, contraseña, logo;
    static JTextField correo_electronico_input, contraseña_input;
    static JButton iniciar_sesion, registrarse;

    public Login() throws IOException {

        this.setLayout(null);
        this.setTitle("Fantasy League | Iniciar Sesión | Registro");
        this.setSize(1480, 920);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage Logo = ImageIO.read(new File("Assets/Logo.png"));
        logo = new JLabel(new ImageIcon(Logo));
        logo.setBounds(200, 250, 347, 321);

        correo_electronico = new JLabel("Correo Electrónico");
        correo_electronico.setBounds(700, 200, 200, 60);

        correo_electronico_input = new JTextField();
        correo_electronico_input.setBounds(700, 250, 480, 60);

        contraseña = new JLabel("Contraseña");
        contraseña.setBounds(700, 300, 200, 60);

        contraseña_input = new JTextField();
        contraseña_input.setBounds(700, 350, 480, 60);

        iniciar_sesion = new JButton("Iniciar Sesión");
        iniciar_sesion.setBounds(700, 450, 480, 60);
        iniciar_sesion.setBackground(new Color(0, 123, 255));

        registrarse = new JButton("Regístrate Gratis");
        registrarse.setBounds(700, 550, 480, 60);

        this.add(logo);
        this.add(correo_electronico);
        this.add(correo_electronico_input);
        this.add(contraseña);
        this.add(contraseña_input);
        this.add(iniciar_sesion);
        this.add(registrarse);

        this.setVisible(true);

        iniciar_sesion.addActionListener(e -> {
            try {
                Usuario user = src.Modelo.Usuarios.Usuario.iniciarSesion(correo_electronico_input.getText(),
                        contraseña_input.getText());
                if (user == null) {
                    App.usuarioLogueado = false;
                }

                App.usuarioActual = user;
                App.usuarioLogueado = true;
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if (App.usuarioActual.rol == "Administrador") {
                App.adminActual = new Administrador(App.usuarioActual.nombre,
                        App.usuarioActual.contraseña,
                        App.usuarioActual.rol);
                // ir a frame administrador
            } else {
                App.participanteActual = new Participante(App.usuarioActual.nombre,
                        App.usuarioActual.contraseña,
                        App.usuarioActual.rol);

                // ir a frame participante
                

                this.dispose();
                new UserFrame();
            }

        });

        registrarse.addActionListener(e -> {
            Usuario user = src.Modelo.Usuarios.Usuario.RegistrarUsuario(correo_electronico_input.getText(),
                    contraseña_input.getText(), "Usuario");
            if (user != null) {
                App.usuarioActual = user;

                if (App.usuarioActual.rol == "Administrador") {
                    App.adminActual = new Administrador(App.usuarioActual.nombre,
                            App.usuarioActual.contraseña,
                            App.usuarioActual.rol);
                } else {
                    App.participanteActual = new Participante(App.usuarioActual.nombre,
                            App.usuarioActual.contraseña,
                            App.usuarioActual.rol);
                }
            }
        });
    }

}
