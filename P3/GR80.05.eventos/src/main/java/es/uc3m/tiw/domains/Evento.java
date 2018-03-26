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
@Table(name = "eventos")
public class Evento {
	@Id
	Long id;
	@Column(name = "id_usuario")
	Long idUsuario;
	String titulo;
	String estado;
	String categoria;
	byte[] foto;
	@Column(name = "precio_entrada")
	int precioEntrada;
	java.sql.Date fecha;
	String lugar;
	String descripcion;
	@Column(name = "numero_entradas")
	int numeroEntradas;
	@Column(name = "numero_entradas_vendidas")
	int numeroEntradasVendidas;
	@GeneratedValue
	java.sql.Timestamp created;
	

	public Evento(){
	}
	
	public Evento(Long idUsuario, String titulo, String estado, String categoria, byte[] foto, int precio, int precioEntrada, java.sql.Date fecha, String lugar, String descripcion, int numeroEntradas, int numeroEntradasVendidas){
		this.idUsuario   = idUsuario;
		this.titulo = titulo;
		this.estado = estado;
		this.categoria = categoria;
	    this.foto = foto;
		this.precioEntrada = precioEntrada;
		this.fecha = fecha;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.numeroEntradas = numeroEntradas;
		this.numeroEntradasVendidas = numeroEntradasVendidas;
	}

	public Long getId() {
		return id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public int getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(int precioEntrada) {
		this.precioEntrada = precioEntrada;
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

	public int getNumeroEntradas() {
		return numeroEntradas;
	}

	public void setNumeroEntradas(int numeroEntradas) {
		this.numeroEntradas = numeroEntradas;
	}

	public int getNumeroEntradasVendidas() {
		return numeroEntradasVendidas;
	}

	public void setNumeroEntradasVendidas(int numeroEntradasVendidas) {
		this.numeroEntradasVendidas = numeroEntradasVendidas;
	}

	public java.sql.Timestamp getCreated() {
		return created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}
	

}
