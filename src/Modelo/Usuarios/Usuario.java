package src.Modelo.Usuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Usuario {

	public String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String contraseña;
	public String rol;

	// Constructor
	public Usuario(String nombre, String contraseña, String rol) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.rol = rol;
	}

	public Usuario(){
		 super();
	}

	public void cambiarContraseña(String nuevaContraseña) {
		this.contraseña = nuevaContraseña;
	}

	public static Usuario RegistrarUsuario(String nombre, String contraseña, String rol) {

		try {
			String userData = "\n" + nombre + " " + contraseña + " " + rol;
			if (nombre.contains(" ") || contraseña.contains(" ")) {
				System.out.println("Datos no pueden contener espacios.");
				return null;
			} else {
				FileWriter fw = new FileWriter("data/db.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(userData);
				bw.close();
				JOptionPane.showMessageDialog(null, "Te has registrado exitosamente");
				System.out.println("Te has registrado exitosamente");
			}
			return null;

		} catch (Exception E) {

			JOptionPane.showMessageDialog(null,
					"Oops! Parece que ha ocurrido un error con tu registro, vuelve a intentarlo");
			System.out.println("Oops! Parece que ha ocurrido un error con tu registro, vuelve a intentarlo");
			return null;
		}

	}

	public static Usuario iniciarSesion(String nombre, String contraseña) throws IOException {
		String record = null;
		FileReader in = null;
		boolean existe = false; // para comprobar si cuenta y pass no coindicen con ninguna línea
		in = new FileReader("data/db.txt");
		BufferedReader br = new BufferedReader(in);

		while ((record = br.readLine()) != null) {
			String[] word = record.split(" "); // dividir en palabras delimitadas por espacios
			if (word[0].equals(nombre) && word[1].equals(contraseña)) {
				System.out.println("\n\n\n\n\n\n" + "Has iniciado sesión exitosamente como: " + word[2]);
				existe = true;
				br.close();
				return new Usuario(nombre, contraseña, word[2]);
			}
		}

		if (!existe) {
			System.out.println("Usuario o contraseña incorrecto.");
			br.close();
			return null;
		}
		br.close();
		return null;

	}

}
