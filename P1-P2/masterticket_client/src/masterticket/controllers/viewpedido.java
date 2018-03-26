package masterticket.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import masterticket.db.DataAccess;
import masterticket.models.Usuario;
import masterticket.models.Pedido;
import masterticket.models.Eventopedido;
import masterticket.models.Evento;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet({"/viewpedido"})
public class viewpedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewpedido() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		// Comprobamos que hay un usuario en sesión.
		HttpSession session = request.getSession();
		
		
		/*Consultamos el usuario en la base de datos */
	    DataAccess bd = new DataAccess();
	    bd.openConnection();
	    ResultSet rs = bd.exQuery("SELECT * FROM pedidos WHERE id="+id+";", "SELECT");
		ArrayList<Pedido> resultados = bd.retrieveOrderData(rs);
		bd.closeConnection();
		
		if (!resultados.isEmpty()){
			Pedido pedido = resultados.get(0);
			session.setAttribute("pedido", pedido);
			
			/* Consultamos fecha de creación */
			bd.openConnection();
		    rs = bd.exQuery("SELECT created FROM pedidos WHERE id="+id+";", "SELECT");
		    java.sql.Date fecha_creacion = null;
		    try {
			    while (rs.next()) {
			    	fecha_creacion = rs.getDate("created");
			    }
		    } catch (Exception e) {
				System.out.println("Error retrieving created");
			}
			bd.closeConnection();
			session.setAttribute("fecha_creacion", fecha_creacion);
			
			/* Recuperamos también los eventos que pertenecen a ese pedido */
			
			bd.openConnection();
			rs = bd.exQuery("SELECT eventos.*, eventopedidos.* FROM eventopedidos INNER JOIN eventos ON eventos.id = eventopedidos.id_evento AND eventopedidos.id_pedido="
					+ id, "SELECT");
		    ArrayList<Eventopedido> resultadosep = bd.retrieveEventoPedidoData(rs);
			bd.closeConnection();
			
			session.setAttribute("eventopedidos", resultadosep);
			
		    RequestDispatcher disp = context.getRequestDispatcher("/customer-order.jsp");
		    disp.forward(request, response);
		}else{
			RequestDispatcher disp = context.getRequestDispatcher("/myorders");
			disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Nothing to do here*/
	}

}
