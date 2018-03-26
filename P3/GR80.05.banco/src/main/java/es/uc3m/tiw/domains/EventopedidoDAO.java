package es.uc3m.tiw.domains;

import java.util.ArrayList;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.repository.CrudRepository;

@RestResource(path="usuarios", rel="usuarios")
public interface EventopedidoDAO extends CrudRepository<Eventopedido, Long>{
	public ArrayList<Eventopedido> findByIdUsuario(Long id_usuario);
	public ArrayList<Eventopedido> findByIdEvento(Long id_evento);
	public ArrayList<Eventopedido> findByIdPedido(Long id_pedido);
	public ArrayList<Eventopedido> findAll();

}
