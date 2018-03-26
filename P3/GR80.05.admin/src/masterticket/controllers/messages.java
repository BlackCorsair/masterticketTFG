package masterticket.controllers;

import java.io.IOException;
import java.util.List;
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
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import masterticket.models.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/messages")
public class messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public messages() {
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
		String id = request.getParameter("id");
		// Comprobamos que hay un usuario en sesión.
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
		
		//Llamamos al recurso para obtener todos los mensajes
		Client client = ClientBuilder.newClient();
		Response serviceResponse = client.target("http://localhost:10503/mensajes/"+id+"/"+user.getId()).request(MediaType.APPLICATION_JSON).get(Response.class);
		ArrayList<Mensaje> mensajesorigen = serviceResponse.readEntity(new GenericType<ArrayList<Mensaje>>() {});
		
		//Llamamos al recurso para obtener todos los mensajes
		client = ClientBuilder.newClient();
		serviceResponse = client.target("http://localhost:10503/mensajes/"+user.getId()+"/"+id).request(MediaType.APPLICATION_JSON).get(Response.class);
		ArrayList<Mensaje> mensajesdestino = serviceResponse.readEntity(new GenericType<ArrayList<Mensaje>>() {});

		// REST Client using GET Verb and Parameters
		client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10507/usuario/"+id+"/");
		Usuario userdestino = webResource.request().accept("application/json").get(Usuario.class);
	    /* Pasamos los resultados a la vista */
	    request.setAttribute("mensajesorigen", mensajesorigen);
	    request.setAttribute("mensajesdestino", mensajesdestino);
	    request.setAttribute("userdestino", userdestino);
	    RequestDispatcher disp = context.getRequestDispatcher("/messages.jsp");
	    disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Nothing to do here */
	}

}
