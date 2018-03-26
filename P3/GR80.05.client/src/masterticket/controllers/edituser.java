package masterticket.controllers;


import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.resource.cci.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import masterticket.models.Usuario;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet({ "/edituser" })
public class edituser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;

	
	//private EntityTransaction tx = em.getTransaction();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public edituser() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Comprobamos que hay un usuario en sesi√≥n.
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("User");
		if(user==null){
			RequestDispatcher disp = context.getRequestDispatcher("/index.jsp");
		    disp.forward(request, response);
		}
		
		//Buscamos el usuario con ese id que recibimos por par·metro.
		String id = request.getParameter("id");
		// REST Client using GET Verb and Parameters
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10507/usuario/"+id+"/");
		Usuario usuario = webResource.request().accept("application/json").get(Usuario.class);

		
		
		if (usuario != null){
			session.setAttribute("editar", usuario);
			RequestDispatcher disp = context.getRequestDispatcher("/edit-user.jsp");
			disp.forward(request, response);
			session.setAttribute("editar", usuario);
		}else{
			response.sendRedirect("/GR80.05.client/dashboard");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String tipo = request.getParameter("tipo");
		String email = request.getParameter("email");
		
		Usuario editar = (Usuario) session.getAttribute("User");
		editar.setNombre(nombre);
		editar.setApellidos(apellidos);
		editar.setTipo(tipo);
		editar.setEmail(email);
		
		//Put data to edit user
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10507/usuario").path(String.valueOf(editar.getId()));
		webResource.request("application/json").accept("application/json").put(Entity.entity(editar,MediaType.APPLICATION_JSON),String.class);
		
		response.sendRedirect("/GR80.05.client/dashboard");
	}

}
