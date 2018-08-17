package entidades;

public class Caballo extends Animal {
	private static final int MINIMO_ALIMENTACION_JUEGO = 75;
	private static final int MINIMO_ENERGIA_JUEGO = 50;
	private static final int REDUCCION_ALIMENTACION_POR_JUEGO = 33;
	private static final int REDUCCION_ENERGIA_POR_JUEGO = 12;
	private static final int RANDOM_ALIMENTO = 50;
	private static final int CANT_ALIMENTO = 40;

	public Caballo(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void alimentar() {
		int random = (int) (Math.random() * MAXIMO) + 1;
		if (random > RANDOM_ALIMENTO) {
			if (alimentacion >= (MAXIMO - CANT_ALIMENTO)) {
				alimentacion = MAXIMO;
			} else {
				alimentacion += CANT_ALIMENTO;
			}
		} else {
			System.out.println("EL caballo no se quiere alimentar");
		}

	}

	@Override
	public void jugar() {
		if (energia < 50 && hambre > 25) {
			System.out.println("El caballo no puede jugar");
			System.out.println("El estado actual es: " + ToString());
			System.out.println("Los minimos requeridos son: 50 de energia y hambre menor al 25");
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
