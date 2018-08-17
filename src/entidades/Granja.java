package entidades;

import java.util.ArrayList;

public class Granja {
	private ArrayList<String> listaDeNombres;
	private ArrayList<Animal> listaDeAnimales;
	private static final String ERROR_NOMBRE_EXISTE = "Error, ya existe el nombre";
	private static final String ERROR_ANIMAL_NO_EXISTE = "Error, el animal no se encuentra registrado";

	public Granja() {
		this.listaDeAnimales = new ArrayList<>();
		this.listaDeNombres = new ArrayList<>();

	}

	public void agregarAnimal(TipoAnimal tipo, String nombre) {
		if (tipo == null || nombre.isEmpty() || nombre == null) {
			throw new NullPointerException("Error, los datos ingresados nos son validos");
		}
		if (listaDeNombres.contains(nombre)) {
			throw new IllegalArgumentException(ERROR_NOMBRE_EXISTE);
		} else {
			Animal animal = Factory.getAnimal(tipo, nombre);
			listaDeAnimales.add(animal);
			listaDeNombres.add(nombre);
		}

	}

	private Animal getAnimal(String nombre) {
		int indice = 0;
		Animal aux;
		Animal animal = null;
		while (indice < listaDeAnimales.size() && animal == null) {
			aux = listaDeAnimales.get(indice);
			if (aux.getNombre().equals(nombre)) {
				animal = aux;
			} else {
				indice++;
			}
		}
		return animal;

	}

	public void listarAnimales() {
		System.out.println("Listado de animales");
		for (Animal animal : listaDeAnimales) {
			System.out.println(animal.ToString());
		}

	}

	public void listarAnimal(String nombre) {
		Animal animal = getAnimal(nombre);
		if (animal != null) {
			System.out.println("Datos del animal buscado");
			System.out.println(animal.ToString());
		} else {
			throw new IllegalArgumentException(ERROR_ANIMAL_NO_EXISTE);
		}

	}

	public void alimentarAnimal(String nombre) {
		Animal animal = getAnimal(nombre);
		if (animal != null) {
			animal.alimentar();
		} else {
			throw new IllegalArgumentException(ERROR_ANIMAL_NO_EXISTE);
		}

	}

	public void alimentarAnimales() {
		for (Animal animal : listaDeAnimales) {
			animal.alimentar();
		}

	}

	public void jugarConAnimal(String nombre) {
		Animal animal = getAnimal(nombre);
		if (animal != null) {
			animal.jugar();
		} else {
			throw new IllegalArgumentException(ERROR_ANIMAL_NO_EXISTE);
		}

	}

	public void jugarConAnimales() {
		for (Animal animal : listaDeAnimales) {
			animal.jugar();
		}

	}

	public void descansarAnimal(String nombre) {
		Animal animal = getAnimal(nombre);
		if (animal != null) {
			animal.descansar();
		} else {
			throw new IllegalArgumentException(ERROR_ANIMAL_NO_EXISTE);
		}

	}

	public void descansarAnimales() {
		for (Animal animal : listaDeAnimales) {
			animal.descansar();
		}

	}

}
