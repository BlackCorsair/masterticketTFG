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
@WebServlet("/editaccount")
public class editaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editaccount() {
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
		/*Consultamos el usuario en la base de datos */
	    DataAccess bd = new DataAccess();
	    bd.openConnection();
	    ResultSet rs = bd.exQuery("SELECT * FROM usuarios WHERE id="+id+";", "SELECT");
		ArrayList<Usuario> resultados = bd.retrieveUserData(rs);
		bd.closeConnection();

		if (!resultados.isEmpty()){
			Usuario editar = resultados.get(0);
			/* Pasamos variables a la vista para saber los datos actuales */
			session.setAttribute("editar", editar);
		    RequestDispatcher disp = context.getRequestDispatcher("/customer-account.jsp");
		    disp.forward(request, response);
		}else{
			response.sendRedirect("/masterticket_admin/index.jsp");    	
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*Guardamos los datos en la base de datos */
		String nombre = request.getParameter("nombre");
	  	String apellidos = request.getParameter("apellidos");
	  	String tipo = request.getParameter("tipo");
	  	String email = request.getParameter("email");
	  	String id = request.getParameter("id");
	  	
	  	// Primero buscamos al usuario con ese id y comprobamos que la contraseña vieja es correcta.
	  	DataAccess bd = new DataAccess();
	    bd.openConnection();
	    ResultSet rs = bd.exQuery("SELECT * FROM usuarios WHERE id ="+id, "SELECT");
		ArrayList<Usuario> resultados = bd.retrieveUserData(rs);
		bd.closeConnection();
		/* Si se ha equivocado de contraseña redirigimos */
		if (!resultados.isEmpty()){
			System.out.println("por aqui");
			Usuario actualizar = resultados.get(0);
			/*En caso contrario actualizamos el usuario con su nueva contraseña */
			bd = new DataAccess();
		    bd.openConnection();
		    rs = bd.exQuery("UPDATE usuarios SET nombre = '"+nombre+"', apellidos= '"+apellidos+"', tipo = '"+tipo+"', email = '"+email+"' WHERE id = "+id, "UPDATE");
			bd.closeConnection();
			System.out.println("por aqui");
		    response.sendRedirect("/masterticket_admin/editaccount?id="+id);
		}else{
			System.out.println("por aca");
			response.sendRedirect("/masterticket_admin/editaccount?id="+id);    	
		}
	}

}
