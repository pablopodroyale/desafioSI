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
		 
         /*
		 agregarAnimal(TipoAnimal.VACA, "lola", granja);
		 agregarAnimal(TipoAnimal.VACA, "lola", granja);
		
		 granja.listarAnimales();
         granja.listarAnimal("kjh");
         granja.alimentarAnimal("lola");
         granja.alimentarAnimales();
         
         granja.jugarConAnimal("lola");
         granja.jugarConAnimales();
         granja.descansarAnimal("lola");
         granja.descansarAnimales();
         */
		input.close();
	}

	private static void agregarAnimal(TipoAnimal tipo, String nombre, Granja granja) {
		try {
			 granja.agregarAnimal(tipo, nombre);
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
	}

}
