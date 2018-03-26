package masterticket.models;

import java.util.Date;
import java.sql.*;

public class Pedido {

	private int id;
	private int id_usuario;
	private int precio;
	private String num_tarjeta;
	private int cv2_tarjeta;
	private java.sql.Date caducidad_tarjeta;
	private int pagado;
	private java.sql.Date created;
	private java.sql.Date modified;

	public Pedido(int id, int id_usuario, int precio, String num_tarjeta, int cv2_tarjeta, java.sql.Date caducidad_tarjeta, int pagado){
		this.id = id;
		this.id_usuario = id_usuario;
		this.precio = precio;
		this.num_tarjeta = num_tarjeta;
		this.cv2_tarjeta = cv2_tarjeta;
		this.caducidad_tarjeta = caducidad_tarjeta;
		this.created = null;
		this.modified = null;
	}

	public int getId() {
		return id;
	}
	
	public int getIdusuario() {
		return id_usuario;
	}
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getNumtarjeta() {
		return num_tarjeta;
	}

	public void setNumtarjeta(String num_tarjeta) {
		this.num_tarjeta = num_tarjeta;
	}
	
	public int getCv2tarjeta() {
		return cv2_tarjeta;
	}

	public void setCv2tarjeta(int cv2_tarjeta) {
		this.cv2_tarjeta = cv2_tarjeta;
	}
	
	public java.sql.Date getCaducidadTarjeta() {
		return caducidad_tarjeta;
	}

	public void setCaducidadTarjeta(java.sql.Date caducidad_tarjeta) {
		this.caducidad_tarjeta = caducidad_tarjeta;
	}
	
	public int getPagado() {
		return pagado;
	}

	public void setPagado(int pagado) {
		this.pagado = pagado;
	}
}
