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
import javax.ws.rs.client.WebTarget;

import masterticket.models.Usuario;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/darbaja")
public class darbaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public darbaja() {
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
		int identificador = Integer.parseInt(id);
		// Comprobamos que hay un usuario en sesión.
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
						
		/* Si el id no coincide con el que intenta dar de baja no se permite */
		if(user.getId() != identificador){
			response.sendRedirect("/GR80.05.admin/editaccount?="+id);
		}
		
		//Eliminamos el usuario
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10507/usuario/"+id+"/");
		webResource.request().accept("application/json").delete();
		
		/* Pasamos los resultados a la vista */
		request.setAttribute("eliminado", "true");
		session.setAttribute("eliminado", "true");
		response.sendRedirect("/GR80.05.admin/dashboard");

		/* Redirigimos al índice puesto que se destruye sesión, el usuario ya no dispone de cuenta */
		session = request.getSession();  
		session.invalidate();
	    response.sendRedirect("/GR80.05.admin/index.jsp");
	    return; // <--- Here.
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Nothing to do here
	}

}
