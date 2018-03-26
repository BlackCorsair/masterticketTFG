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

import masterticket.models.Usuario;
import masterticket.db.*;

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
	  	System.out.println("1");
	  	System.out.println(email);
	    if (email == null) {
	    	request.setAttribute("fallo", "true");
	    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
	    	disp.forward(request, response);
	    } else {

	      // Do database lookup for the user
	      DataAccess bd = new DataAccess();
	      bd.openConnection();
	      ResultSet rs = bd.lookForUser(email);
	      ArrayList<Usuario> resultados = bd.retrieveUserData(rs);
	      bd.closeConnection();

	      //Leemos elemento del ArrayList para ver los datos del usuario.
	      if (resultados.isEmpty()){
	    	  request.setAttribute("fallo", "true");
	    	  RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
	    	  disp.forward(request, response);
	      }
	      
	      String emaildb = null;
	      String passworddb = null;
	      boolean hayUser = false;
	      if (!resultados.isEmpty()){
	    	  Usuario user = resultados.get(0);
		      //Realizamos comprobación de que el email y la contraseña coincidan.
		      emaildb = user.getEmail();
		      passworddb = user.getPassword();
		      hayUser = true;
		      
		      if (emaildb == null) {
		    	  request.setAttribute("fallo", "true");
		    	  RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
		    	  disp.forward(request, response);
			  }
		      
		      if(!email.equals(emaildb) || !password.equals(passworddb)){
		    	  request.setAttribute("fallo", "true");
		    	  RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
		    	  disp.forward(request, response);
		      }else{
		    	  if(user.getTipo().equals("admin")){
		    		  HttpSession session = request.getSession();  
				      session.setAttribute("User", user);
		    	  }else{
		    		  request.setAttribute("fallo", "true");
			    	  RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
			    	  disp.forward(request, response);
		    	  }
		    	  
		      }
		      
		      
		      if(user.getTipo().compareTo("admin") == 0){
		    	  response.sendRedirect("/masterticket_admin/dashboard");
		      }else{
		    	  response.sendRedirect("/masterticket_admin/myorders");
		      }
		      
	      }
	      
	      
	      
	      
	    }
	}

}
