package entidades;

public class Factory {
	private static final String ERROR_NO_SE_PUDO_REGISTRAR_EL_ANIMAL = "Error, no se pudo registrar el animal";

	public static Animal getAnimal(TipoAnimal tipo, String nombre) {
		Animal animal = null;
		switch (tipo) {
		case CABALLO:
			animal = new Caballo(nombre);
			break;
		case VACA:
			animal = new Vaca(nombre);
			break;
		case GALLINA:
			animal = new Gallina(nombre);
			break;
		default:
			System.out.println("No existe ese animal");
			break;
		}
		if (animal == null) {
			throw new NullPointerException(ERROR_NO_SE_PUDO_REGISTRAR_EL_ANIMAL);
		}
		return animal;
	}
}
