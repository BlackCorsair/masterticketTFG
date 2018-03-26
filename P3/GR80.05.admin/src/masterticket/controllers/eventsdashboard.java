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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import masterticket.models.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/eventsdashboard")
public class eventsdashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventsdashboard() {
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
		
		/* Una salvedad: si es un admin, todos los eventos */
		ArrayList<Evento> resultados = null;
		if(user.getTipo().compareTo("admin") == 0){
			//Llamamos al recurso para obtener todos los eventos
			Client client = ClientBuilder.newClient();
			Response serviceResponse = client.target("http://localhost:10504/todoseventos").request(MediaType.APPLICATION_JSON).get(Response.class);
			resultados = serviceResponse.readEntity(new GenericType<ArrayList<Evento>>() {});
		}else{
			//Llamamos al recurso para obtener solo los eventos de ese usuario
			Client client = ClientBuilder.newClient();
			Response serviceResponse = client.target("http://localhost:10504/eventos/"+user.getId()).request(MediaType.APPLICATION_JSON).get(Response.class);
			resultados = serviceResponse.readEntity(new GenericType<ArrayList<Evento>>() {});
		}

	    /* Pasamos los resultados a la vista */
	    request.setAttribute("eventos", resultados);
	    request.setAttribute("eliminado", "false");
	    session.setAttribute("eliminado", "false");
	    RequestDispatcher disp = context.getRequestDispatcher("/admin-events.jsp");
	    disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Nothing to do here */
	}

}
