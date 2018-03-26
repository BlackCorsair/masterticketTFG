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
@WebServlet("/viewevents")
public class viewevents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewevents() {
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
		String categoria = request.getParameter("categoria");
		
		request.setAttribute("categoria_url", categoria);
		
		if(categoria.equals("concierto")){
			request.setAttribute("categoria", "Conciertos");
		}else if(categoria.equals("festival")){
			request.setAttribute("categoria", "Festivales");
		}else if(categoria.equals("musical")){
			request.setAttribute("categoria", "Musicales");
		}else if(categoria.equals("teatro")){
			request.setAttribute("categoria", "Teatro");
		}else if(categoria.equals("monologo")){
			request.setAttribute("categoria", "Monólogos");
		}else if(categoria.equals("ballet")){
			request.setAttribute("categoria", "Ballet");
		}else if(categoria.equals("opera")){
			request.setAttribute("categoria", "Ópera");
		}else if(categoria.equals("turismo")){
			request.setAttribute("categoria", "Turístico");
		}else if(categoria.equals("museo")){
			request.setAttribute("categoria", "Museos");
		}else if(categoria.equals("profesional")){
			request.setAttribute("categoria", "Eventos profesionales");
		}else if(categoria.equals("deportivo")){
			request.setAttribute("categoria", "Eventos deportivos");
		}else if(categoria.equals("curso")){
			request.setAttribute("categoria", "Cursos");
		}else{
			request.setAttribute("categoria", "Circo");
		}
		
		if(categoria.equals("opera")){
			categoria = "ópera";
		}
		
		if(categoria.equals("monologo")){
			categoria = "monólogo";
		}
		
		/* Consultamos los eventos de esa categoría */
		DataAccess bd = new DataAccess();
	    bd.openConnection();
	    ResultSet rs = bd.exQuery("SELECT * FROM eventos WHERE categoria LIKE '%"+categoria+"%'" , "SELECT");
	    ArrayList<Evento> resultados = bd.retrieveEventData(rs);
	    bd.closeConnection();
	    
	    /* Pasamos los resultados a la vista */
	    request.setAttribute("eventos", resultados);
	    RequestDispatcher disp = context.getRequestDispatcher("/view-events.jsp");
	    disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Nothing to do here */
	}

}
