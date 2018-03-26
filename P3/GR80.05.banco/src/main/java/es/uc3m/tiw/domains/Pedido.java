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
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue
	Long id;
	@Column(name = "id_usuario")
	Long idUsuario;
	int precio;
	@Column(name = "num_tarjeta")
	Long numTarjeta;
	@Column(name = "cv2_tarjeta")
	int cv2Tarjeta;
	@Column(name = "caducidad_tarjeta")
	String caducidadTarjeta;
	int pagado;

	public Pedido(){
	}
	
	public Pedido(Long id_usuario, int precio, Long numTarjeta, int cv2Tarjeta, String caducidad_tarjeta, int pagado){
		this.idUsuario   = id_usuario;
		this.precio = precio;
		this.numTarjeta = numTarjeta;
		this.cv2Tarjeta = cv2Tarjeta;
	    this.caducidadTarjeta = caducidad_tarjeta;
		this.pagado = pagado;
	}
	
	public Long getId(){
		return id;
	}

	public void setIdUsuario(Long idUsuario){
		this.idUsuario = idUsuario;
	}

	public Long getIdUsuario(){
		return idUsuario;
	}
	
	public void setPrecio(int precio){
		this.precio = precio;
	}

	public int getPrecio(){
		return precio;
	}
	
	public void setNumTarjeta(Long numTarjeta){
		this.numTarjeta = numTarjeta;
	}

	public Long getNumTarjeta(){
		return numTarjeta;
	}
	
	public void setCV2Tarjeta(int cv2Tarjeta){
		this.cv2Tarjeta = cv2Tarjeta;
	}

	public int getCV2Tarjeta(){
		return cv2Tarjeta;
	}
	
	public void setCaducidadTarjeta(String caducidadTarjeta){
		this.caducidadTarjeta = caducidadTarjeta;
	}

	public String getCaducidadTarjeta(){
		return caducidadTarjeta;
	}
	
	public void setPagado(int pagado){
		this.pagado = pagado;
	}

	public int getPagado(){
		return pagado;
	}

}
