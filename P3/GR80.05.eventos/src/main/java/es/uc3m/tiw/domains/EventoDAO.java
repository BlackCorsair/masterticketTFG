package es.uc3m.tiw.domains;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path="eventos", rel="eventos")
public interface EventoDAO extends CrudRepository<Evento, Long>{
	public ArrayList<Evento> findByIdUsuario(Long id_usuario);
	public Evento findById(Long id_usuario);
	public List<Evento> findByCategoria(String categoria);
	public ArrayList<Evento> findAll();
}