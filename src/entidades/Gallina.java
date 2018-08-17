package entidades;

public class Gallina extends Animal {
	private static final int MINIMO_ALIMENTACION_JUEGO = 60;
	private static final int MINIMO_ENERGIA_JUEGO = 50;
	private static final int CANT_ALIMENTO = 30;
	private static final int REDUCCION_ENERGIA_POR_JUEGO = (int) (Math.random() * 50) + 20;
	private static final int REDUCCION_ALIMENTACION_POR_JUEGO = 20;

	public Gallina(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void alimentar() {
		if (alimentacion >= (MAXIMO - CANT_ALIMENTO)) {
			alimentacion = MAXIMO;
		} else {
			alimentacion += CANT_ALIMENTO;
		}

	}

	@Override
	public void jugar() {
		if (energia < 50 && hambre > 25) {
			System.out.println("La gallina no puede jugar");
			System.out.println("El estado actual es: " + ToString());
			System.out.println(
					"La Gallina requiere de un mínimo de 50 de energía y tener un nivel de hambre menor al 40.");
		} else {
			if (energia >= MINIMO_ENERGIA_JUEGO) {
				actualizarEnergia(REDUCCION_ENERGIA_POR_JUEGO);
			} else {
				energia = 0;
			}
			if (alimentacion >= MINIMO_ALIMENTACION_JUEGO) {
				actualizarAlimentacion(REDUCCION_ALIMENTACION_POR_JUEGO);
				actualizarHambre();
			} else {
				energia = 0;
			}
		}

	}

}
