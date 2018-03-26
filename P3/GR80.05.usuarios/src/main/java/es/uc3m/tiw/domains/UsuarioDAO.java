package es.uc3m.tiw.domains;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path="eventos", rel="eventos")
public interface UsuarioDAO extends CrudRepository<Usuario, Long>{
	public Usuario findByEmail(String email);
	public ArrayList<Usuario> findByTipo(String tipo);
	public Usuario findById(Long id);
	public ArrayList<Usuario> findAll();
}