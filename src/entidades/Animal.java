package entidades;

public abstract class Animal {
	private static final int REDUCCION_POR_DESCANSO = 35;
	protected String nombre;
	protected int alimentacion;
	protected int hambre;
	protected int energia;
	protected static final int MINIMO = 0;
	protected static final int MAXIMO = 100;

	public Animal(String nombre) {
		this.nombre = nombre;
		this.alimentacion = (int) (Math.random() * MAXIMO) + 1;
		this.energia = (int) (Math.random() * MAXIMO) + 1;
		actualizarHambre();
	}

	public String getNombre() {
		return nombre;
	}

	public int getAlimentacion() {
		return alimentacion;
	}

	public int getEnergia() {
		return energia;
	}

	public String ToString() {
		return "Nombre de la mascota:" + nombre + ", Alimentacion," + alimentacion + ", Energia: " + energia;
	}

	public void actualizarHambre() {
		this.hambre = MAXIMO - alimentacion;
	}

	protected void actualizarAlimentacion(int valor) {
		this.alimentacion -= valor;
	}

	protected void actualizarEnergia(int valor) {
		this.energia -= valor;
	}

	protected abstract void alimentar();

	protected abstract void jugar();

	protected void descansar() {
		this.energia = 100;
		if (alimentacion >= REDUCCION_POR_DESCANSO) {
			alimentacion -= REDUCCION_POR_DESCANSO;
		}else {
			alimentacion = 0;
		}
	}
}
