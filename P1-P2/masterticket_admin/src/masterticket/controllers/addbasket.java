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
@WebServlet("/addbasket")
public class addbasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addbasket() {
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
		/* Nothing to do here */
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POr aqui");
		request.setCharacterEncoding("UTF-8");
		String id_evento = request.getParameter("id");
		String num_entradas = request.getParameter("entradas");
		String precio_entradas = request.getParameter("precio_entradas");
		/*Guardamos en sesión esta selección */
		int id = Integer.parseInt(id_evento);
		int n_entradas = Integer.parseInt(num_entradas);
		int p_entradas = Integer.parseInt(precio_entradas);
		Carrito nuevoElemento = new Carrito(id, n_entradas, p_entradas);
		HttpSession session = request.getSession();
		ArrayList<Carrito> carritoCompra = (ArrayList<Carrito>)session.getAttribute("carritoCompra");
		if(carritoCompra != null){
			carritoCompra.add(nuevoElemento);
			session.setAttribute("carritoCompra", carritoCompra);
		}else{
			ArrayList<Carrito> carritoNuevo = new ArrayList<Carrito>();
			carritoNuevo.add(nuevoElemento);
			session.setAttribute("carritoCompra", carritoNuevo);
		}
		
		response.sendRedirect("/masterticket_admin/viewevent?id="+id_evento);
	}

}
