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
public class Eventos_Controller {
	
	@Autowired
	EventoDAO daoev;
	
	@RequestMapping("/todoseventos")
	public @ResponseBody ArrayList<Evento> getEventos(){
		return daoev.findAll();
	}
	
	@RequestMapping("/eventosporusuario/{idUsuario}")
	public @ResponseBody ArrayList<Evento> getEventosByIdUsuario(@PathVariable Long idUsuario){
		return daoev.findByIdUsuario(idUsuario);
	}
	
	@RequestMapping("/todoseventos/{categoria}")
	public @ResponseBody List<Evento> getEventosByCategoria(@PathVariable String categoria){
		return daoev.findByCategoria(categoria);
	}
	
	@RequestMapping(value="/eventos/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteevent(@PathVariable Long id){
		daoev.delete(id);
	}
	
	@RequestMapping("/eventos/{id}")
	public @ResponseBody Evento getEventoById(@PathVariable Long id){
		return daoev.findById(id);
	}
	
	@RequestMapping(value="/eventos/{id}", method = RequestMethod.PUT)
	public @ResponseBody Evento updateevent(@PathVariable Long id, @RequestBody Evento pevento){
		Evento ev = daoev.findById(id);
		
		ev.setCategoria(pevento.getCategoria());
		ev.setDescripcion(pevento.getDescripcion());
		ev.setEstado(pevento.getEstado());
		ev.setFecha(pevento.getFecha());
		ev.setFoto(pevento.getFoto());
		ev.setLugar(pevento.getLugar());
		ev.setNumeroEntradas(pevento.getNumeroEntradas());
		ev.setPrecioEntrada(pevento.getPrecioEntrada());
		ev.setTitulo(pevento.getTitulo());
		
			
		return daoev.save(ev);	
				
	}
	
	@RequestMapping(value="/eventos", method = RequestMethod.POST)
	public @ResponseBody Evento saveevento(@RequestBody Evento pevento){
		return daoev.save(pevento);
	}
	
}
