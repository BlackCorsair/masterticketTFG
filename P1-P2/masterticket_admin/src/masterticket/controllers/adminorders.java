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
@WebServlet("/adminorders")
public class adminorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminorders() {
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
		
		/* Si el usuario no está, echamos de aqui */
		if(user == null){
	    	  response.sendRedirect("/masterticket_admin/index.jsp");
	    }
		
		/*Consultamos los eventos creados por ese usuario en la base de datos */
		DataAccess bd = new DataAccess();
		bd.openConnection();
		ResultSet rs = bd.exQuery("SELECT * FROM eventos WHERE id_usuario = "+user.getId(), "SELECT");
		ArrayList<Evento> resultados = bd.retrieveEventData(rs);
		bd.closeConnection();
		
		/* Por cada evento del usuario consultamos los eventopedidos que hay */
		
		ArrayList<Pedido> pedidos_user = new ArrayList<Pedido>();
		for(Evento viewevent : resultados){
			
			bd = new DataAccess();
            bd.openConnection();
		    rs = bd.exQuery("SELECT * FROM eventopedidos WHERE id_evento = "+viewevent.getId(), "SELECT");
		    ArrayList<Eventopedido> hayeventopedido = bd.retrieveEventoPedidoData(rs);
		    bd.closeConnection();
			
		    if (!hayeventopedido.isEmpty()) {
		    	for(Eventopedido ep : hayeventopedido){
		    		/* Buscamos ese pedido en la base de datos y lo añadimos al arraylist */
		    		bd = new DataAccess();
				    bd.openConnection();
				    rs = bd.exQuery("SELECT * FROM pedidos WHERE id_pedido = "+ep.getIdpedido(), "SELECT");
				    ArrayList<Pedido> pedido = bd.retrieveOrderData(rs);
				    
				    if (!pedido.isEmpty()){
				    	  Pedido ped = pedido.get(0);
				    	  pedidos_user.add(ped);
				    }
				    
				    bd.closeConnection();
		    	}
		    }
		    
		}
		
	    /* Pasamos los resultados a la vista */
	    request.setAttribute("pedidos", pedidos_user);
	    RequestDispatcher disp = context.getRequestDispatcher("/admin-orders.jsp");
	    disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Nothing to do here */
	}

}
