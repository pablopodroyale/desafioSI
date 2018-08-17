package test;

import java.io.IOException;
import java.util.Scanner;

import entidades.Granja;
import entidades.Interfaz;
import entidades.TipoAnimal;

public class Test {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Granja granja = new Granja();	
		Interfaz interfaz = new Interfaz();
		 try {
			interfaz.interaccionUsuario(granja, input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input.close();
	}

}
