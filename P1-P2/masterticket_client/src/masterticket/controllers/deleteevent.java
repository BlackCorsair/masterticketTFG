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
import masterticket.models.Evento;
import masterticket.db.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/deleteevent")
public class deleteevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteevent() {
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
		
		DataAccess bd = new DataAccess();
		bd.openConnection();
		ResultSet rs = bd.exQuery("SELECT * FROM eventos WHERE id="+id, "SELECT");
		ArrayList<Evento> resultados = bd.retrieveEventData(rs);
		bd.closeConnection();
		
		if (resultados.isEmpty()){
			response.sendRedirect("/masterticket_client/eventsdashboard");
		}
		
		Evento event = resultados.get(0);
						
		/* Si el usuario no es admin ni es el propietario del evento, echamos de aqui */
		if(user.getTipo().compareTo("admin") != 0 && event.getIdusuario() != user.getId()){
			response.sendRedirect("/masterticket_client/eventsdashboard");
		}
						
		/* Eliminamos el evento de la base de datos */
		bd = new DataAccess();
		bd.openConnection();
		rs = bd.exQuery("DELETE FROM eventos WHERE id="+id, "DELETE");
		bd.closeConnection();
		
		/* Pasamos los resultados a la vista */
		request.setAttribute("eliminado", "true");
		session.setAttribute("eliminado", "true");
		response.sendRedirect("/masterticket_client/eventsdashboard");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Nothing to do here
	}

}
