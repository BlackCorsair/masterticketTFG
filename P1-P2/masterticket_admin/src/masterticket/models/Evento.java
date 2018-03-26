package masterticket.models;

import java.util.Date;
import java.sql.*;

public class Evento {

	private int id;
	private int id_usuario;
	private String titulo;
	private String estado;
	private String categoria;
	private String foto;
	private int precio_entrada;
	private java.sql.Date fecha;
	private String lugar;
	private String descripcion;
	private int numero_entradas;
	private int numero_entradas_vendidas;
	private java.sql.Date created;
	private java.sql.Date modified;

	public Evento() {
		
	}
	public Evento(int id, int id_usuario, String titulo, String estado, String categoria, String foto, int precio_entrada, java.sql.Date fecha, String lugar, String descripcion, int numero_entradas, int numero_entradas_vendidas){
		this.id = id;
		this.id_usuario = id_usuario;
		this.titulo = titulo;
		this.estado = estado;
		this.categoria = categoria;
		this.foto = foto;
		this.precio_entrada = precio_entrada;
		this.fecha = fecha;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.numero_entradas = numero_entradas;
		this.numero_entradas_vendidas = numero_entradas_vendidas;
		this.created = null;
		this.modified = null;
	}

	public int getId() {
		return id;
	}
	
	public int getIdusuario() {
		return id_usuario;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public java.sql.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}
	
	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getPrecioEntradas() {
		return precio_entrada;
	}

	public void setPrecioEntradas(int precio_entrada) {
		this.precio_entrada = precio_entrada;
	}
	
	public int getNumeroEntradas() {
		return numero_entradas;
	}

	public void setNumeroEntradas(int numero_entradas) {
		this.numero_entradas = numero_entradas;
	}
	
	public int getNumeroEntradasVendidas() {
		return numero_entradas_vendidas;
	}

	public void setNumeroEntradasVendidas(int numero_entradas_vendidas) {
		this.numero_entradas_vendidas = numero_entradas_vendidas;
	}
}
