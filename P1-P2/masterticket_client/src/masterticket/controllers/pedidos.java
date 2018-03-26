package masterticket.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import masterticket.models.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/pedidos")
public class pedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pedidos() {
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
		
		/*if(user == null){
			request.setAttribute("fallo", "true");
			request.setAttribute("faltandatos", "false");
			request.setAttribute("emailnovalido", "false");
			request.setAttribute("nocoinciden", "false");
			request.setAttribute("registrocorrecto", "false");
			request.setAttribute("emailenuso", "false");
	    	RequestDispatcher disp = context.getRequestDispatcher("/login");
	    	disp.forward(request, response);
		}*/
		
		// Redirigimos a la página de pedidos si es un usuario de tipo comprador.
		if(user.getTipo().compareTo("admin") == 0){
			 RequestDispatcher disp = context.getRequestDispatcher("/admin-users.jsp");
		     disp.forward(request, response);
		  }else{
			 RequestDispatcher disp = context.getRequestDispatcher("/customer-orders.jsp");
			 disp.forward(request, response);
		  }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// Comprobamos que hay un usuario en sesión.
				HttpSession session = request.getSession();
				Usuario user = (Usuario)session.getAttribute("User");
				
				/*if(user == null){
					request.setAttribute("fallo", "true");
					request.setAttribute("faltandatos", "false");
					request.setAttribute("emailnovalido", "false");
					request.setAttribute("nocoinciden", "false");
					request.setAttribute("registrocorrecto", "false");
					request.setAttribute("emailenuso", "false");
			    	RequestDispatcher disp = context.getRequestDispatcher("/login");
			    	disp.forward(request, response);
				}*/
				
				// Redirigimos a la página de pedidos si es un usuario de tipo comprador.
				if(user.getTipo().compareTo("admin") == 0){
					 RequestDispatcher disp = context.getRequestDispatcher("/admin-users.jsp");
				     disp.forward(request, response);
				  }else{
					 RequestDispatcher disp = context.getRequestDispatcher("/customer-orders.jsp");
					 disp.forward(request, response);
				  }
	}

}
