package masterticket.models;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	Long id;
	String nombre;
	String apellidos;
	String tipo;
	String email;
	String password;
	java.sql.Timestamp created;

	public Usuario(){
	}
	
	public Usuario(String nombre, String apellidos, String tipo, String email, String password){
		this.nombre   = nombre;
		this.apellidos = apellidos;
		this.tipo = tipo;
		this.email = email;
	    this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public java.sql.Timestamp getCreated() {
		return created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}
	
}
