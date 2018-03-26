package es.uc3m.tiw;


import es.uc3m.tiw.domains.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.*;
import org.json.JSONObject;

@Controller
public class Usuarios_Controller {
	
	@Autowired
	UsuarioDAO daousu;
	
	@RequestMapping("/todosusuarios")
	public @ResponseBody List<Usuario> getEventos(){
		return daousu.findAll();
	}
	
	@RequestMapping("/usuarios/{email}")
	public @ResponseBody Usuario getEventosByIdUsuario(@PathVariable String email){
		return daousu.findByEmail(email);
	}
	
	@RequestMapping("/todosusuarios/{tipo}")
	public @ResponseBody ArrayList<Usuario> getEventosByTipo(@PathVariable String tipo){
		return daousu.findByTipo(tipo);
	}
	
	@RequestMapping("/usuario/{id}")
	public @ResponseBody Usuario getUsuarioById(@PathVariable Long id){
		return daousu.findById(id);
	}
	
	@RequestMapping(value="/usuario/{id}", method = RequestMethod.PUT)
	public @ResponseBody Usuario updateuser(@PathVariable Long id, @RequestBody Usuario puser){
		Usuario user = daousu.findById(id);
		user.setNombre(puser.getNombre());
		user.setApellidos(puser.getApellidos());
		user.setEmail(puser.getEmail());
		user.setTipo(puser.getTipo());
		user.setPassword(puser.getPassword());
		return daousu.save(user);					
	}
	
	@RequestMapping(value="/usuario/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteuser(@PathVariable Long id){
		daousu.delete(id);
	}
	
	@RequestMapping(value="/usuarios", method = RequestMethod.POST)
	public @ResponseBody Usuario saveuser(@RequestBody Usuario puser){
		daousu.save(puser);
		return puser;
	}
	
}
