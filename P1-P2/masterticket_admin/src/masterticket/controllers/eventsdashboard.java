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

import masterticket.db.DataAccess;
import masterticket.models.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/eventsdashboard")
public class eventsdashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventsdashboard() {
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
		
		
		/* Consultamos los eventos en la base de datos */
		/* Una salvedad: si es un admin, todos los eventos */
		DataAccess bd = new DataAccess();
	    bd.openConnection();
	    ResultSet rs = null;
		if(user.getTipo().compareTo("admin") == 0){
			rs = bd.exQuery("SELECT * FROM eventos;", "SELECT");
		}else{
			rs = bd.exQuery("SELECT * FROM eventos WHERE id_usuario = "+user.getId(), "SELECT");
		}
		ArrayList<Evento> resultados = bd.retrieveEventData(rs);
		bd.closeConnection();

	    /* Pasamos los resultados a la vista */
	    request.setAttribute("eventos", resultados);
	    request.setAttribute("eliminado", "false");
	    session.setAttribute("eliminado", "false");
	    RequestDispatcher disp = context.getRequestDispatcher("/admin-events.jsp");
	    disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Nothing to do here */
	}

}
