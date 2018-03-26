package es.uc3m.tiw.domains;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.transaction.Transactional;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Table(name = "eventopedidos")
public class Eventopedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "id_evento")
	private Long idEvento;
	
	@Column(name = "id_pedido")
	private Long idPedido;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	private int num_entradas_compradas;
	private int precio;
	private java.sql.Date created;

	public Eventopedido() {
	}
	
	public Eventopedido(Long idEvento, Long idPedido, Long idUsuario, int num_entradas_compradas, int precio){
		this.idEvento   = idEvento;
		this.idPedido = idPedido;
		this.idUsuario = idUsuario;
		this.num_entradas_compradas = num_entradas_compradas;
		this.precio = precio;
	}

	public Long getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	
	public Long getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	
	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getNumEntradasCompradas() {
		return this.num_entradas_compradas;
	}

	public void setNumEntradasCompradas(int num_entradas_compradas) {
		this.num_entradas_compradas = num_entradas_compradas;
	}
	
	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public java.sql.Date getCreated() {
		return this.created;
	}

}