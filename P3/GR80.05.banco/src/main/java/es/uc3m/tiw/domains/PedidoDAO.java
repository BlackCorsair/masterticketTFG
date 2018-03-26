package es.uc3m.tiw.domains;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path="pedidos", rel="pedidos")
public interface PedidoDAO extends CrudRepository<Pedido, Long>{
	public ArrayList<Pedido> findByidUsuario(Long id_usuario);
	public Pedido findById(Long id);
	public List<Pedido> findAll();
}