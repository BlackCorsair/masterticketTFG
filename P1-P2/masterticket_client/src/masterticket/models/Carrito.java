package masterticket.models;

public class Carrito {

	private int id_evento;
	private int num_entradas;
	private int precio_entradas;

	public Carrito(int id_evento, int num_entradas, int precio_entradas){
		this.id_evento = id_evento;
		this.num_entradas = num_entradas;
		this.precio_entradas = precio_entradas;
	}

	public int getIdEvento() {
		return id_evento;
	}
	
	public int getNumEntradas() {
		return num_entradas;
	}
	
	public void setNumEntradas(int num_entradas) {
		this.num_entradas = num_entradas;
	}
	
	public int getPrecioEntradas() {
		return precio_entradas;
	}
	
	public void setPrecioEntradas(int precio_entradas) {
		this.precio_entradas = precio_entradas;
	}
}
