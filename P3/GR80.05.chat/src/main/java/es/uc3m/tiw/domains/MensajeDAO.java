package es.uc3m.tiw.domains;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path="mensajes", rel="mensajes")
public interface MensajeDAO extends CrudRepository<Mensaje, Long>{
	public List<Mensaje> findByIdOrigenAndIdDestinoOrderByCreatedAsc(int idOrigen, int idDestino);
	public List<Mensaje> findAll();
}