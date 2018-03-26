package es.uc3m.tiw;


import es.uc3m.tiw.domains.*;
import java.util.List;
import java.util.ArrayList;
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
public class Banco_Controller {
	
	@Autowired
	PedidoDAO daoped;
		
	@Autowired
	EventopedidoDAO daoevped;
	
	@RequestMapping("/todospedidos")
	public @ResponseBody List<Pedido> getPedidos(){
		return daoped.findAll();
	}
	
	@RequestMapping("/eventopedidos/{idPedido}")
	public @ResponseBody List<Eventopedido> getEventopedidosByIdPedido(@PathVariable Long idPedido){
		return daoevped.findByIdPedido(idPedido);
	}
	
	@RequestMapping("/eventopedido/{idUsuario}")
	public @ResponseBody List<Eventopedido> getEventopedidosByIdUsuario(@PathVariable Long idUsuario){
		return daoevped.findByIdUsuario(idUsuario);
	}
	
	@RequestMapping("/eventopedid/{idEvento}")
	public @ResponseBody List<Eventopedido> getEventopedidosByIdEvento(@PathVariable Long idEvento){
		return daoevped.findByIdEvento(idEvento);
	}
	
	@RequestMapping(value="/eventopedido", method = RequestMethod.POST)
	public @ResponseBody Eventopedido saveeventopedido(@RequestBody Eventopedido evped){
		return daoevped.save(evped);
	}
	
	@RequestMapping("/pedidos/{id}")
	public @ResponseBody Pedido getPedidoById(@PathVariable Long id){
		return daoped.findById(id);
	}
	
	@RequestMapping(value="/pedido", method = RequestMethod.POST)
	public ResponseEntity<Long> savepedido(@RequestBody Pedido ppedido){
		
		
		/* Comprobamos los requisitos para guardar */
		int length = String.valueOf(ppedido.getNumTarjeta()).length();
		if(length != 16) {
			System.out.println("por aqui");
			return new ResponseEntity<Long>(HttpStatus.PAYMENT_REQUIRED);
		}
		if(ppedido.getNumTarjeta()%4 != 0) {
			System.out.println("por aca");
			return new ResponseEntity<Long>(HttpStatus.PAYMENT_REQUIRED);
		}
		int length2 = String.valueOf(ppedido.getCV2Tarjeta()).length();
		if(length2 != 3) {
			return new ResponseEntity<Long>(HttpStatus.PAYMENT_REQUIRED);
		}
		daoped.save(ppedido);
		Long id = ppedido.getId();
		return new ResponseEntity<Long>(id,HttpStatus.OK);
	}
	
	@RequestMapping("/todospedidos/{idUsuario}")
	public @ResponseBody ArrayList<Pedido> getPedidosByIdUsuario(@PathVariable Long idUsuario){
		return daoped.findByidUsuario(idUsuario);
	}
	
}
