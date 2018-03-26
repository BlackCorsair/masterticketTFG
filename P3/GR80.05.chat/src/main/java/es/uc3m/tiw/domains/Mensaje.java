package es.uc3m.tiw.domains;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "mensajes")
public class Mensaje {
	@Id
	@GeneratedValue
	int id;
	@Column(name = "id_origen")
	int idOrigen;
	@Column(name = "id_destino")
	int idDestino;
	String contenido;
	@GeneratedValue
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
