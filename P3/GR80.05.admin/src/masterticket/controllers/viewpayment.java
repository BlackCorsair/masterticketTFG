package masterticket.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.*;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import masterticket.models.*;
import masterticket.auxiliar.*;
/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/viewpayment")
public class viewpayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public viewpayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		context = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/* Desgranamos el carrito y hacemos un arraylist de eventos con el mismo orden que el carrito */
		HttpSession session = request.getSession();
		ArrayList<Carrito> carritoCompra = (ArrayList<Carrito>)session.getAttribute("carritoCompra");
		ArrayList<Evento> eventosCarrito = (ArrayList<Evento>)session.getAttribute("eventosCarrito");
		Usuario user = (Usuario)session.getAttribute("User");
		if(carritoCompra != null){
			
			/*Pasamos el total del pedido */
			int precio = 0;
			for (int i = 0; i < eventosCarrito.size(); i++) {
				Evento ev = eventosCarrito.get(i);
				Carrito cr = carritoCompra.get(i);
				precio += cr.getNumEntradas()*cr.getPrecioEntradas();
			}
			request.setAttribute("precio", String.valueOf(precio));
			request.setAttribute("id_usuario", String.valueOf(user.getId()));
			request.setAttribute("carritoCompra", carritoCompra);
			request.setAttribute("eventosCarrito", eventosCarrito);
	    	RequestDispatcher disp = context.getRequestDispatcher("/view-payment.jsp");
	    	disp.forward(request, response);
			
		}else{
			request.setAttribute("carritoCompra", null);
			request.setAttribute("eventosCarrito", null);
	    	RequestDispatcher disp = context.getRequestDispatcher("/view-payment.jsp");
	    	disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Post the order */
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id_usuario");
	  	String precio_s = request.getParameter("precio");
	  	String numero_tarjeta = request.getParameter("numero_tarjeta");
	  	String cvv_tarjeta_s = request.getParameter("cvv_tarjeta");
	  	String fecha_caducidad_s = request.getParameter("fecha_caducidad");
	  	System.out.println("LA FECHA DE CADUCIDAD ES : "+fecha_caducidad_s);
	  	java.sql.Date fecha_db = DateFormatter.DTLocalToDB(fecha_caducidad_s);
	  	System.out.println("LA FECHA DE CADUCIDAD EN BD ES : "+fecha_db);
	  	Long id_usuario = Long.parseLong(id);
	  	Long num_tarjeta = Long.parseLong(numero_tarjeta);
	  	int precio = Integer.parseInt(precio_s);
	  	int cvv_tarjeta = Integer.parseInt(cvv_tarjeta_s);
	  	
	  	Pedido pedidoNuevo = new Pedido(id_usuario, precio, num_tarjeta, cvv_tarjeta, fecha_caducidad_s, 1);
	  	
	  	 /* Insertamos el pedido en la base de datos */
	  	Client client = ClientBuilder.newClient();
	  	WebTarget webResource = client.target("http://localhost:10502/pedido/");
		Integer codigo =	webResource.request("application/json").accept("application/json").post(Entity.entity(pedidoNuevo,MediaType.APPLICATION_JSON),Integer.class);
	    
	    /* Una vez insertados los pedidos insertamos los eventospedidos recorriendo el arraylist */
	    ArrayList<Carrito> carritoCompra = (ArrayList<Carrito>)session.getAttribute("carritoCompra");
		ArrayList<Evento> eventosCarrito = (ArrayList<Evento>)session.getAttribute("eventosCarrito");
		
		/*Cogemos el ultimo id */
		
		    
		    for (int i = 0; i < eventosCarrito.size(); i++) {
				Evento ev = eventosCarrito.get(i);
				Carrito cr = carritoCompra.get(i);
				
				Long id_ev = ev.getId();
				int num_entradas_compradas = cr.getNumEntradas();
				java.sql.Date fechaCreacion = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
				java.sql.Date fechaModificacion = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
				
				
				Eventopedido nuevoEventopedido = new Eventopedido(id_ev, pedidoNuevo.getId(), id_usuario, num_entradas_compradas, precio);
				
				client = ClientBuilder.newClient();
			  	webResource = client.target("http://localhost:10502/eventopedido/");
				webResource.request("application/json").accept("application/json").post(Entity.entity(nuevoEventopedido,MediaType.APPLICATION_JSON),Integer.class);	
			}
		
		request.setAttribute("comprado", "true");
		RequestDispatcher disp = context.getRequestDispatcher("/myorders");
	    disp.forward(request, response);
	  	
		
	}

}
