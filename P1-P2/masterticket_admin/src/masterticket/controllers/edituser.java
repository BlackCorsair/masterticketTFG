package masterticket.controllers;


import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.resource.cci.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import masterticket.db.DataAccess;
import masterticket.models.Usuario;

import model.Usuario2;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet({ "/edituser" })
public class edituser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("masterticketds");
	private EntityManager em = emf.createEntityManager();
	//private EntityTransaction tx = em.getTransaction();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public edituser() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("ALERT########## ID: "+id);
		// Comprobamos que hay un usuario en sesión.
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("User");
		
		try {
			//tx.begin();
			System.out.println("Next line will search the user");
			Usuario2 usuario = em.find(Usuario2.class, id);
			System.out.println("#############################");
			System.out.println(usuario.toString());
			//tx.commit();
			em.close();
			emf.close();
			if (usuario != null){
				session.setAttribute("editar", usuario);
			    RequestDispatcher disp = context.getRequestDispatcher("/edit-user.jsp");
			    disp.forward(request, response);
			    session.setAttribute("editar", usuario);
			}else{
				response.sendRedirect("/masterticket_admin/dashboard");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/* Guardamos los datos en la base de datos */
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String tipo = request.getParameter("tipo");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String password = HashPass.md5(request.getParameter("password"));

		// Primero buscamos al usuario con ese id y comprobamos que la
		// contraseña vieja es correcta.
		DataAccess bd = new DataAccess();
		bd.openConnection();
		java.sql.ResultSet rs = bd.exQuery("SELECT * FROM usuarios WHERE id =" + id, "SELECT");
		ArrayList<Usuario> resultados = bd.retrieveUserData(rs);
		bd.closeConnection();
		/* Si se ha equivocado de contraseña redirigimos */
		if (!resultados.isEmpty()) {
			System.out.println("por aqui");
			Usuario actualizar = resultados.get(0);
			/*
			 * En caso contrario actualizamos el usuario con su nueva
			 * contraseña
			 */
			bd = new DataAccess();
			bd.openConnection();
			rs = bd.exQuery("UPDATE usuarios SET nombre = '" + nombre + "', apellidos= '" + apellidos + "', tipo = '"
					+ tipo + "', email = '" + email + "' WHERE id = " + id, "UPDATE");
			bd.closeConnection();
			response.sendRedirect("/masterticket_admin/dashboard");
		} else {
			response.sendRedirect("/masterticket_admin/dashboard");
		}
	}

}
