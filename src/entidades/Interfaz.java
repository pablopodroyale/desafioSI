package entidades;

import java.io.IOException;
import java.util.Scanner;

import jdk.nashorn.internal.ir.Terminal;

public class Interfaz {
	private static final String ERROR_EL_TIPO_ES_INVALIDO = "Error, el tipo es invalido";
	private static final String ERROR_OPCION_INVALIDA = "Error, opcion invalida";
	private String ingreso;
	private String ingreso2;
	private TipoAnimal tipo;

	public void interaccionUsuario(Granja granja, Scanner input) throws IOException, NullPointerException {
		String opcion;
		do {
			salida();
			opcion = input.nextLine();
			switch (opcion) {
			case "1":
				try {
					this.ingreso = pedirString("Ingrese nombre del animal a listar", input);
					granja.listarAnimal(ingreso);
				} catch (RuntimeException re) {
					System.out.println(re.getMessage());
				}
				break;
			case "2":
				granja.listarAnimales();
				break;
			case "3":
				try {
					this.ingreso = pedirString("Ingrese nombre del animal", input);
					this.ingreso2 = pedirString("Ingrese el tipo de animal", input);
					this.tipo = asignarTipo(ingreso2);
					granja.agregarAnimal(tipo, ingreso);
				} catch (RuntimeException re) {
					System.out.println(re.getMessage());
				}

				break;
			case "4":
				this.ingreso = pedirString("Ingrese nombre del animal", input);
				granja.alimentarAnimal(ingreso);
				break;
			case "5":
				granja.alimentarAnimales();
				break;
			case "6":
				this.ingreso = pedirString("Ingrese nombre del animal", input);
				granja.jugarConAnimal(ingreso);
				break;
			case "7":
				granja.jugarConAnimales();
				break;
			case "8":
				this.ingreso = pedirString("Ingrese nombre del animal", input);
				granja.descansarAnimal(ingreso);
				break;
			case "9":
				granja.descansarAnimales();
				break;
			case "clean":
				try {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				} catch (Exception e) {
					/* No hacer nada */
				}
				break;
			case "save":
				System.out.println("Se ha guardado la informacion");
				break;
			case "load":
				System.out.println("Se ha cargado la informacion");
				break;
			default:
				System.out.println(ERROR_OPCION_INVALIDA);
				break;
			}
		} while (!opcion.equalsIgnoreCase("exit"));

	}

	private TipoAnimal asignarTipo(String ingreso2) {
		TipoAnimal tipo = null;
		switch (ingreso2.toUpperCase()) {
		case "VACA":
			tipo = TipoAnimal.VACA;
			break;
		case "GALLINA":
			tipo = TipoAnimal.GALLINA;
			break;
		case "CABALLO":
			tipo = TipoAnimal.CABALLO;
			break;
		default:
			System.out.println("\"" + ingreso2 + "\"" + " No es un tipo valido");
			break;
		}
		if (tipo == null) {
			throw new NullPointerException(ERROR_EL_TIPO_ES_INVALIDO);
		}
		return tipo;
	}

	private void salida() {
		System.out.println("----------------------------------------");
		System.out.println("             Menu");
		System.out.println("----------------------------------------");
		System.out.println("1.Listar Animal");
		System.out.println("2.Listar Animales");
		System.out.println("3.Agregar Animal");
		System.out.println("4.Alimentar Animal");
		System.out.println("5.Alimentar Animales");
		System.out.println("6.Jugar con Animal");
		System.out.println("7.Jugar con Animales");
		System.out.println("8.Descansar Animal");
		System.out.println("9.Descansar Animales");
		System.out.println("----------------------------------------");
		System.out.println("*Para salir ingrese: exit");
		System.out.println("*Para limpiar la pantalla ingrese: clean");
		System.out.println("*Para guardar los datos del sistema ingrese: save");
		System.out.println("*Para cargar datos del sistema ingrese: load");
		System.out.println("----------------------------------------");
		System.out.println("Opcion:");
	}

	public String pedirString(String mensaje, Scanner input) {
		String respuesta;
		do {
			System.out.println(mensaje);
			respuesta = input.nextLine();
		} while (respuesta.isEmpty() || respuesta == null);

		return respuesta;

	}

}
