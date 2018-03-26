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
@WebServlet("/deleteuser")
public class deleteuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteuser() {
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
		System.out.println(id);
		
		// Comprobamos que hay un usuario en sesión.
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
						
		/* Si el usuario no es admin echamos de aqui */
		if(user.getTipo().compareTo("admin") != 0){
			response.sendRedirect("/masterticket_admin/index.jsp");
		}
		
		System.out.println(user.getTipo());
						
		/*Consultamos los usuarios en la base de datos */
		DataAccess bd = new DataAccess();
		bd.openConnection();
		ResultSet rs = bd.exQuery("DELETE FROM usuarios WHERE id="+id, "DELETE");
		bd.closeConnection();
		
		/* Pasamos los resultados a la vista */
		request.setAttribute("eliminado", "true");
		session.setAttribute("eliminado", "true");
		response.sendRedirect("/masterticket_admin/dashboard");		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Nothing to do here
	}

}
