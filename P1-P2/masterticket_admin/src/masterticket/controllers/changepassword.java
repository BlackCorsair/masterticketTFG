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
@WebServlet("/changepassword")
public class changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepassword() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Nothing to do here */
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		System.out.println(id);
		String password_old = request.getParameter("password_old");
	  	String password1 = request.getParameter("password_1");
	  	String password2 = request.getParameter("password_2");

	  	// Primero buscamos al usuario con ese id y comprobamos que la contraseña vieja es correcta.
	  	DataAccess bd = new DataAccess();
	    bd.openConnection();
	    ResultSet rs = bd.exQuery("SELECT * FROM usuarios WHERE id ="+id, "SELECT");
		ArrayList<Usuario> resultados = bd.retrieveUserData(rs);
		bd.closeConnection();
		/* Si se ha equivocado de contraseña redirigimos */
		if (!resultados.isEmpty()){
			Usuario actualizar = resultados.get(0);
			/* Comprobamos que las contraseñas nuevas coinciden */
			if(password1 == null || password2 == null){
				response.sendRedirect("/masterticket_admin/editaccount?id="+id); 
			}
			if (password1.compareTo(password2) != 0) {
				response.sendRedirect("/masterticket_admin/editaccount?id="+id); 
			}

			/*En caso contrario actualizamos el usuario con su nueva contraseña */
			bd = new DataAccess();
		    bd.openConnection();
		    rs = bd.exQuery("UPDATE usuarios SET password = '"+HashPass.md5(password1)+"' WHERE id = "+id, "UPDATE");
			bd.closeConnection();

			/*Redirigimos al índice puesto que se destruye sesión */
			HttpSession session = request.getSession();  
			session.invalidate();
		    response.sendRedirect("/masterticket_admin/index.jsp");
		    return; // <--- Here.			
		}else{
			response.sendRedirect("/masterticket_admin/editaccount?id="+id);    	
		}
	}

}
