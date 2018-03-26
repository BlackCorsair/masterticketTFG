package masterticket.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.regex.*;
import masterticket.*;
import masterticket.db.DataAccess;
import masterticket.models.Usuario;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/registro")
public class registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registro() {
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
		/*Guardamos los datos en la base de datos */
		String nombre = request.getParameter("nombre");
	  	String apellidos = request.getParameter("apellidos");
	  	String tipo = "admin";
	  	String email = request.getParameter("email");
	  	String password = request.getParameter("password");
	  	String password2 = request.getParameter("password2");
	  	
	  	/* Antes de nada parseamos los datos */
	  	if(nombre == null || apellidos == null || tipo == null || email == null || password == null || password2 == null){
	  		request.setAttribute("faltandatos", "true");
	    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
	    	disp.forward(request, response);
	  	}
	  	
	  	
	  	if(password.compareTo(password2) != 0){
	  		request.setAttribute("nocoinciden", "true");
	    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
	    	disp.forward(request, response);
	  	}
	  	
	  	String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
        	request.setAttribute("emailnovalido", "true");
	    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
	    	disp.forward(request, response);
        }
        
        // Do database lookup for the email
        DataAccess bd = new DataAccess();
	 	bd.openConnection();
	    ResultSet rs = bd.lookForUser(email);
	    ArrayList<Usuario> resultados = bd.retrieveUserData(rs);
	    bd.closeConnection();
	    if (!resultados.isEmpty()){
	    	request.setAttribute("emailnovalido", "true");
	    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
	    	disp.forward(request, response);
	    }

        bd = new DataAccess();
	    bd.openConnection();
	    bd.insertUser(nombre, apellidos, tipo, email, HashPass.md5(password));
	    bd.closeConnection();
	    request.setAttribute("registrocorrecto", "true");
    	RequestDispatcher disp = context.getRequestDispatcher("/customer-register.jsp");
    	disp.forward(request, response);
	}

}
