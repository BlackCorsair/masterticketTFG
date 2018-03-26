package masterticket.models;

import java.util.Date;
import java.sql.*;

public class Usuario {

	private int id;
	private String nombre;
	private String apellidos;
	private String tipo;
	private String email;
	private String password;
	private java.sql.Date created;
	private java.sql.Date modified;

	public Usuario(int id, String nombre, String apellidos, String tipo, String email, String password){
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipo = tipo;
		this.email = email;
		this.password = password;
		this.created = null;
		this.modified = null;
	}

	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
