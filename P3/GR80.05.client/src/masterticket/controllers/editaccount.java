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
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import masterticket.models.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/editaccount")
public class editaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editaccount() {
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
		// Comprobamos que hay un usuario en sesión.
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("User");
		if(user==null){
			RequestDispatcher disp = context.getRequestDispatcher("/index.jsp");
		    disp.forward(request, response);
		}
				
		if (user != null){
			session.setAttribute("editar", user);
			RequestDispatcher disp = context.getRequestDispatcher("/customer-account.jsp");
			disp.forward(request, response);
			session.setAttribute("editar", user);
		}else{
			response.sendRedirect("/GR80.05.client/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String tipo = request.getParameter("tipo");
		String email = request.getParameter("email");
		
		System.out.println(nombre);
		System.out.println(apellidos);
		System.out.println(tipo);
		System.out.println(email);
		
		Usuario editar = (Usuario) session.getAttribute("User");
		editar.setNombre(nombre);
		editar.setApellidos(apellidos);
		editar.setTipo(tipo);
		editar.setEmail(email);
		
		//Put data to edit user
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10507/usuario").path(String.valueOf(editar.getId()));
		webResource.request("application/json").accept("application/json").put(Entity.entity(editar,MediaType.APPLICATION_JSON),String.class);
				
		response.sendRedirect("/GR80.05.client/customer-account.jsp");
	}

}
