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
import java.util.concurrent.TimeUnit;
import masterticket.models.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/changepassword")
public class changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepassword() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		System.out.println(id);
		String password_old = request.getParameter("password_old");
	  	String password1 = request.getParameter("password_1");
	  	String password2 = request.getParameter("password_2");
	  	
	  	//Buscamos el usuario y vemos si la contraseña vieja es correcta.
	  	HttpSession session = request.getSession();
	  	Usuario editar = (Usuario) session.getAttribute("User");
		
		if(!editar.getPassword().equals(password_old)){
			response.sendRedirect("/GR80.05.client/editaccount?id="+id); 
		}
		if(password1 == null || password2 == null){
			response.sendRedirect("/GR80.05.client/editaccount?id="+id); 
		}
		if (password1.compareTo(password2) != 0) {
			response.sendRedirect("/GR80.05.client/editaccount?id="+id); 
		}
		
		//Cambiamos contraseña
		editar.setPassword(HashPass.md5(password1));

		//Put data to edit user
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10507/usuario").path(String.valueOf(editar.getId()));
		String hola = webResource.request("application/json").put(Entity.entity(editar,MediaType.APPLICATION_JSON),String.class);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Comprobamos que hay un usuario en sesiÃ³n.
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

}
