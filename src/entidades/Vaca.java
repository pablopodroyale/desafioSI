package entidades;

public class Vaca extends Animal {
	private static final int MINIMO_ALIMENTACION_JUEGO = 80;
	private static final int CANT_ALIMENTO = 23;
	private static final int REDUCCION_ENERGIA_POR_JUEGO = 15;
	private static final int REDUCCION_ALIMENTACION_POR_JUEGO = 20;

	public Vaca(String nombre) {
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
			System.out.println("El caballo no puede jugar");
			System.out.println("El estado actual es: " + ToString());
			System.out.println("La Vaca requiere de un mínimo de 30 de energía y tener un nivel de hambre menor al 20.");
		} else {
			int MINIMO_ENERGIA_JUEGO = 30;
			if (energia >= MINIMO_ENERGIA_JUEGO) {
				actualizarEnergia(REDUCCION_ENERGIA_POR_JUEGO);
			} else {
				energia = MINIMO;
			}
			if (alimentacion >= MINIMO_ALIMENTACION_JUEGO) {
				actualizarAlimentacion(REDUCCION_ALIMENTACION_POR_JUEGO);
				actualizarHambre();
			} else {
				energia = MINIMO;
			}
		}
		
	}

}
