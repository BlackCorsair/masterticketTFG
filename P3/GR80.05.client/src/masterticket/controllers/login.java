package masterticket.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
import masterticket.models.Usuario;
 


/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
    	disp.forward(request, response);			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
	  	String password = request.getParameter("password");
	  	password = HashPass.md5(password);
	  	
	    if (email == null) {
	    	request.setAttribute("fallo", "true");
	    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
	    	disp.forward(request, response);
	    } else {
	    	
	    	// REST Client using GET Verb and Parameters
			Client client = ClientBuilder.newClient();
			WebTarget webResource = client.target("http://localhost:10507/usuarios/"+email+"/");
			Usuario usu=	webResource.request().accept("application/json").get(Usuario.class);
			
			if(usu.getEmail() == null){
				request.setAttribute("fallo", "true");
		    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
		    	disp.forward(request, response);
			}
			
			//Comprobamos que el hash de la contraseña introducida coincide con el recurso.
			if(password.equals(usu.getPassword())){
				if(usu.getTipo().equals("comprador")){
		    		  HttpSession session = request.getSession();  
				      session.setAttribute("User", usu);
		    	}else{
		    		  request.setAttribute("fallo", "true");
			    	  RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
			    	  disp.forward(request, response);
		    	}
			}else{
				request.setAttribute("fallo", "true");
		    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
		    	disp.forward(request, response);
			}
			
			if(usu.getTipo().compareTo("admin") == 0){
		    	  response.sendRedirect("/GR80.05.client/dashboard");
		    }else{
		    	  response.sendRedirect("/GR80.05.client/myorders");
		    }
	      
	    }
	}

}
