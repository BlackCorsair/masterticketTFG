package masterticket.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.regex.*;
import masterticket.*;
import masterticket.models.Mensaje;
import masterticket.models.Usuario;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/addmensaje")
public class addmensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addmensaje() {
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
		System.out.println("Do get de addmensaje");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("Do post de addmessage");
		String idOrigen = request.getParameter("idOrigen");
		System.out.println("ESTOY AQUÍ 1");
		String idDestino = request.getParameter("idDestino");
		System.out.println("ESTOY AQUÍ 2");
		String contenido = request.getParameter("contenido");
		System.out.println("ESTOY AQUÍ 3");
		Mensaje nuevoMensaje = new Mensaje(Integer.parseInt(idOrigen), Integer.parseInt(idDestino), contenido);
		System.out.println("ESTOY AQUÍ 4");

		//Llamamos al recurso para obtener todos los mensajes
		Client client = ClientBuilder.newClient();
		System.out.println("ESTOY AQUÍ 5");

		WebTarget webResource = client.target("http://localhost:10503/mensajes/");
		System.out.println("ESTOY AQUÍ 6");

		Mensaje result=	webResource.request("application/json").accept("application/json").post(Entity.entity(nuevoMensaje,MediaType.APPLICATION_JSON),Mensaje.class);
		System.out.println("ESTOY AQUÍ 7");

		
		
	    /* Volvemos */
		response.sendRedirect("/GR80.05.admin/messages?id="+idDestino);
		System.out.println("ESTOY AQUÍ 8");
	}

}
