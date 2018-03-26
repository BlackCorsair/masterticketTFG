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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;
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
		
		
		/*Consultamos el pedido en la base de datos */
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10502/pedidos/"+id+"/");
		Pedido pedido = webResource.request().accept("application/json").get(Pedido.class);

		session.setAttribute("pedido", pedido);
		
		/* Recuperamos también los eventos que pertenecen a ese pedido */
		client = ClientBuilder.newClient();
		Response serviceResponse = client.target("http://localhost:10502/eventopedidos/"+pedido.getId()).request(MediaType.APPLICATION_JSON).get(Response.class);
		ArrayList<Eventopedido> resultadosep = serviceResponse.readEntity(new GenericType<ArrayList<Eventopedido>>() {});	
		session.setAttribute("eventopedidos", resultadosep);
		System.out.println("antes del error viendo eventos");
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		Evento aux = new Evento();
		for(int i=0; i<resultadosep.size(); i++){
			System.out.println("por acaaaaaaa");
			client = ClientBuilder.newClient();
			System.out.println("http://localhost:10504/eventos/"+resultadosep.get(i).getIdEvento()+"/");
			webResource = client.target("http://localhost:10504/eventos/"+resultadosep.get(i).getIdEvento()+"/");
			aux = webResource.request().accept("application/json").get(Evento.class);
			System.out.println(aux.getCategoria());
			eventos.add(aux);
		}
		
		session.setAttribute("eventos", eventos);
		System.out.println(eventos.get(0).getCategoria());
		RequestDispatcher disp = context.getRequestDispatcher("/customer-order.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Nothing to do here*/
	}

}
