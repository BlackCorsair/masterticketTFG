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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import masterticket.models.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/adminorders")
public class adminorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminorders() {
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
		// Comprobamos que hay un usuario en sesión.
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
		
		/* Si el usuario no está, echamos de aqui */
		if(user == null){
	    	  response.sendRedirect("/GR80.05.client/index.jsp");
	    }
		
		/*Consultamos los eventos creados por ese usuario en la base de datos */
		Client client = ClientBuilder.newClient();
		Response serviceResponse = client.target("http://localhost:10504/eventosporusuario/"+user.getId()).request(MediaType.APPLICATION_JSON).get(Response.class);
		ArrayList<Evento> resultados = serviceResponse.readEntity(new GenericType<ArrayList<Evento>>() {});
		
		/* Por cada evento del usuario consultamos los eventopedidos que hay */
		
		ArrayList<Pedido> pedidos_user = new ArrayList<Pedido>();
		for(Evento viewevent : resultados){
			
			/* Consultamos en el banco si hay pedidos en ese id_evento */
			client = ClientBuilder.newClient();
			serviceResponse = client.target("http://localhost:10502/eventopedidos/"+viewevent.getId()).request(MediaType.APPLICATION_JSON).get(Response.class);
			ArrayList<Eventopedido> hayeventopedido = serviceResponse.readEntity(new GenericType<ArrayList<Eventopedido>>() {});

		    if (!hayeventopedido.isEmpty()) {
		    	for(Eventopedido ep : hayeventopedido){
		    		/* Buscamos ese pedido en la base de datos y lo añadimos al arraylist */
		    		client = ClientBuilder.newClient();
					WebTarget webResource = client.target("http://localhost:10502/pedidos/"+ep.getIdPedido()+"/");
					Pedido pedido =	webResource.request().accept("application/json").get(Pedido.class);
					pedidos_user.add(pedido);
				    
		    	}
		    }
		    
		}
		
	    /* Pasamos los resultados a la vista */
	    request.setAttribute("pedidos", pedidos_user);
	    RequestDispatcher disp = context.getRequestDispatcher("/admin-orders.jsp");
	    disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Nothing to do here */
	}

}
