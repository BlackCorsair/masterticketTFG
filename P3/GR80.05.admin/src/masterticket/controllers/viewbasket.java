package masterticket.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import masterticket.models.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/viewbasket")
public class viewbasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public viewbasket() {
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
		ArrayList<Evento> eventosCarrito = new ArrayList<Evento>();
		if(carritoCompra != null){
			/*Vamos cogiendo ids del carrito y lo almacenamos en un ArrayList eventos */
			for(Carrito elemCarrito : carritoCompra){
				/* Consultamos el evento en la base de datos */
				Client client = ClientBuilder.newClient();
				WebTarget webResource = client.target("http://localhost:10504/eventos/"+elemCarrito.getIdEvento()+"/");
				Evento evento = webResource.request().accept("application/json").get(Evento.class);
				eventosCarrito.add(evento);
			    
			}
			
			request.setAttribute("carritoCompra", carritoCompra);
			request.setAttribute("eventosCarrito", eventosCarrito);
			session.setAttribute("eventosCarrito", eventosCarrito);
	    	RequestDispatcher disp = context.getRequestDispatcher("/view-basket.jsp");
	    	disp.forward(request, response);
			
		}else{
			request.setAttribute("carritoCompra", null);
			request.setAttribute("eventosCarrito", null);
	    	RequestDispatcher disp = context.getRequestDispatcher("/view-basket.jsp");
	    	disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Nothing to do here */
	}

}
