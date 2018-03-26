package masterticket.models;

import java.util.Date;
import java.sql.*;

public class Eventopedido {

	private int id;
	private int id_evento;
	private int id_pedido;
	private int id_usuario;
	private int num_entradas_compradas;
	private int precio;
	private java.sql.Date created;
	private java.sql.Date modified;
	private String nombre_evento;
	private String foto;
	private int precio_entrada;

	public Eventopedido(int id, int id_evento, int id_pedido, int id_usuario, int num_entradas_compradas, int precio){
		this.id = id;
		this.id_evento = id_evento;
		this.id_pedido = id_pedido;
		this.id_usuario = id_usuario;
		this.num_entradas_compradas = num_entradas_compradas;
		this.precio = precio;
		this.created = null;
		this.modified = null;
	}
	
	public Eventopedido(int id, int id_evento, int id_pedido, int id_usuario, int num_entradas_compradas, int precio, String nombre_evento, String foto, int precio_entrada){
		this.id = id;
		this.id_evento = id_evento;
		this.id_pedido = id_pedido;
		this.id_usuario = id_usuario;
		this.num_entradas_compradas = num_entradas_compradas;
		this.precio = precio;
		this.nombre_evento = nombre_evento;
		this.foto = foto;
		this.precio_entrada = precio_entrada;
		this.created = null;
		this.modified = null;
	}
	
	public String getNombreEvento(){
		return nombre_evento;
	}
	
	public String getFoto(){
		return foto;
	}
	
	public int getPrecioEntrada(){
		return precio_entrada;
	}

	public int getId() {
		return id;
	}
	
	public int getIdusuario() {
		return id_usuario;
	}
	
	public void setIdusuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public int getIdevento() {
		return id_evento;
	}
	
	public void setIdevento(int id_evento) {
		this.id_evento = id_evento;
	}
	
	public int getIdpedido() {
		return id_pedido;
	}
	
	public void setIdpedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	
	public int getNumEntradasCompradas() {
		return num_entradas_compradas;
	}
	
	public void setNumEntradasCompradas(int num_entradas_compradas) {
		this.num_entradas_compradas = num_entradas_compradas;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
