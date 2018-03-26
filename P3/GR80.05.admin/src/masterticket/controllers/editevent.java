package masterticket.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import masterticket.auxiliar.DateFormatter;
import masterticket.models.Evento;
import masterticket.models.Usuario;

/**
 * Servlet implementation class editevent
 */
@WebServlet("/editevent")
@MultipartConfig
public class editevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editevent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
		if(user==null){
			RequestDispatcher disp = context.getRequestDispatcher("/index.jsp");
		    disp.forward(request, response);
		}
		int id = Integer.parseInt(request.getParameter("id"));
		
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10504/eventos/"+id+"/");
		Evento editar = webResource.request().accept("application/json").get(Evento.class);
		session.setAttribute("modifiedEvent", editar);
		RequestDispatcher disp = context.getRequestDispatcher("/edit-event.jsp");
	    disp.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Comprobamos que hay un usuario en sesión.
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
		if(user==null){
			RequestDispatcher disp = context.getRequestDispatcher("/index.jsp");
		    disp.forward(request, response);
		}
		
		Evento modifiedEvent = (Evento)session.getAttribute("modifiedEvent");
		
		Long idEvento = modifiedEvent.getId();
		modifiedEvent.setTitulo((String)request.getParameter("titulo"));
		modifiedEvent.setEstado((String)request.getParameter("estado"));
		modifiedEvent.setCategoria((String)request.getParameter("categoria"));
		modifiedEvent.setFecha(DateFormatter.DTLocalToDBDate((String)request.getParameter("fecha")));
		modifiedEvent.setLugar((String)request.getParameter("lugar"));
		modifiedEvent.setDescripcion((String)request.getParameter("descripcion"));
		int precio_entrada = Integer.parseInt(request.getParameter("precio_entrada"));
		int num_entradas = Integer.parseInt(request.getParameter("numero_entradas"));
		modifiedEvent.setNumeroEntradas(num_entradas);
		Part foto = request.getPart("foto");
		byte[] data = new byte[(int) foto.getSize()];
		foto.getInputStream().read(data, 0, data.length);
	    modifiedEvent.setFoto(data);
	    modifiedEvent.setPrecioEntrada(precio_entrada);
		System.out.println("antes de error al editar evento");
	    //Put data to edit event
	  	Client client = ClientBuilder.newClient();
	  	WebTarget webResource = client.target("http://localhost:10504/eventos/"+idEvento);
	  	webResource.request("application/json").accept("application/json").put(Entity.entity(modifiedEvent,MediaType.APPLICATION_JSON),String.class);
	  	
		
		response.sendRedirect("/GR80.05.admin/eventsdashboard");


	}

}