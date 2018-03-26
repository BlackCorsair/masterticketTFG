package masterticket.models;


public class Mensaje {

	int id;
	int idOrigen;
	int idDestino;
	String contenido;
	java.sql.Timestamp created;

	public Mensaje(){
	}
	
	public Mensaje(int idOrigen, int idDestino, String contenido){
		this.idOrigen   = idOrigen;
		this.idDestino = idDestino;
		this.contenido = contenido;
	}
	
	public int getId(){
		return id;
	}

	public void setIdOrigen(int idOrigen){
		this.idOrigen = idOrigen;
	}

	public int getIdOrigen(){
		return idOrigen;
	}
	
	public void setIdDestino(int idDestino){
		this.idDestino = idDestino;
	}

	public int getIdDestino(){
		return idDestino;
	}
	
	public void setContenido(String contenido){
		this.contenido = contenido;
	}

	public String getContenido(){
		return contenido;
	}
	
	public java.sql.Timestamp getCreated(){
		return created;
	}

}
