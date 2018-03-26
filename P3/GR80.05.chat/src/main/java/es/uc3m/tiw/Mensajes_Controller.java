package es.uc3m.tiw;


import es.uc3m.tiw.domains.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.*;
import org.json.JSONObject;

@Controller
@CrossOrigin
public class Mensajes_Controller {
	
	@Autowired
	MensajeDAO daomen;
	
	@RequestMapping("/todosmensajes")
	public @ResponseBody List<Mensaje> getAllMensajes(){
		return daomen.findAll();
	}
	
	@RequestMapping("/mensajes/{idOrigen}/{idDestino}")
	public @ResponseBody List<Mensaje> getInteraccion(@PathVariable Integer idOrigen, @PathVariable Integer idDestino){
		return daomen.findByIdOrigenAndIdDestinoOrderByCreatedAsc(idOrigen, idDestino);
	}
	
	@RequestMapping(value="/mensajes", method = RequestMethod.POST)
	public @ResponseBody Mensaje savemensaje(@RequestBody Mensaje pmensaje){
		return daomen.save(pmensaje);
	}
	
}
