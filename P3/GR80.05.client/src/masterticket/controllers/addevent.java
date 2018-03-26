package masterticket.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.Date;

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
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import java.sql.*;

import org.omg.Messaging.SyncScopeHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.*;
import masterticket.*;
import masterticket.auxiliar.DateFormatter;
import masterticket.models.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import masterticket.auxiliar.ImageUploader;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/addevent")
@MultipartConfig
public class addevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addevent() {
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
    	RequestDispatcher disp = context.getRequestDispatcher("/add-event.jsp");
    	disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		/*Guardamos los datos en la base de datos */
		String titulo = request.getParameter("titulo");
		String estado = request.getParameter("estado");
		String categoria = request.getParameter("categoria");
		Part foto = request.getPart("foto");
		int precio_entrada = Integer.parseInt(request.getParameter("precio_entrada"));
		String fecha = (String)request.getParameter("fecha");
		java.sql.Date fecha_db = DateFormatter.DTLocalToDBDate(fecha);
		String lugar = request.getParameter("lugar");	
		String descripcion = request.getParameter("descripcion");
		int numero_entradas = Integer.parseInt(request.getParameter("numero_entradas"));
		java.sql.Date fecha_creacion = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		
		/* Antes de nada comprobamos los datos */
	  	if(titulo == null || estado == null || categoria == null || foto == null || fecha == null || precio_entrada == 0 || lugar == null || descripcion == null || numero_entradas == 0){
	    	RequestDispatcher disp = context.getRequestDispatcher("/add-event.jsp");
	    	disp.forward(request, response);
	  	}
		
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
		
		byte[] data = new byte[(int) foto.getSize()];
		foto.getInputStream().read(data, 0, data.length);
		
		Evento nuevoEvento = new Evento(user.getId(), titulo, estado, categoria, data, precio_entrada, fecha_db, lugar, descripcion, numero_entradas, 0);
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10504/eventos/");
		boolean result=	webResource.request("application/json").accept("application/json").post(Entity.entity(nuevoEvento,MediaType.APPLICATION_JSON),boolean.class);
		
	    response.sendRedirect("/GR80.05.client/eventsdashboard");
	}

}
