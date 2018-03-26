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
import java.sql.*;

import org.omg.Messaging.SyncScopeHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.*;
import masterticket.*;
import masterticket.auxiliar.DateFormatter;
import masterticket.db.DataAccess;
import model.Usuario2;
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
		System.out.println("ENTRADO EN doPOST");
		/*Guardamos los datos en la base de datos */
		String titulo = request.getParameter("titulo");
		System.out.println("Par�metro t�tulo = " + titulo);
		String estado = request.getParameter("estado");
		System.out.println("Par�metro estado = " + estado);
		String categoria = request.getParameter("categoria");
		System.out.println("Par�metro categoria = " + categoria);
		Part foto = request.getPart("foto");
		System.out.println("Par�metro fechaDB = " + foto);
		int precio_entrada = Integer.parseInt(request.getParameter("precio_entrada"));
		System.out.println("Par�metro precio _entrada = " + precio_entrada);
		String fecha = (String)request.getParameter("fecha");
		System.out.println("Par�metro fecha = " + fecha);
		java.sql.Date fecha_db = DateFormatter.DTLocalToDBDate(fecha);
		System.out.println("Par�metro fechaDB = " + fecha_db);
		String lugar = request.getParameter("lugar");	
		System.out.println("Par�metro lugar = " + lugar);
		String descripcion = request.getParameter("descripcion");
		System.out.println("Par�metro descripcion = " + descripcion);
		int numero_entradas = Integer.parseInt(request.getParameter("numero_entradas"));
		System.out.println("Par�metro numero_entradas = " + numero_entradas);
		java.sql.Date fecha_creacion = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		System.out.println("Par�metro fecha_creacion = " + titulo);

			
		/*
		ImagenenbbddManager ibm2 = new ImagenenbbddManager("UP");
		Imagenenbbdd i2 = new  Imagenenbbdd();
		Part filePart = request.getPart("foto");
	    byte[] data = new byte[(int) filePart.getSize()];
	    filePart.getInputStream().read(data, 0, data.length);
	    i2.setTitulo(request.getParameter("titulo"));
		i2.setImagen(data);
		ibm2.create(i2);
		*/		
		/* Antes de nada comprobamos los datos */
	  	if(titulo == null || estado == null || categoria == null || foto == null || fecha == null || precio_entrada == 0 || lugar == null || descripcion == null || numero_entradas == 0){
	    	RequestDispatcher disp = context.getRequestDispatcher("/add-event.jsp");
	    	disp.forward(request, response);
	  	}
	  	
	  	
	  	
	  	HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
	  	
		System.out.println("CONECTANDO A BD PARA A�ADIR EVENTO");
	  	DataAccess bd = new DataAccess();
	 	bd.openConnection();
	    boolean result = bd.insertEvent(user.getId(), titulo, estado, categoria, null, precio_entrada, fecha_db, lugar, descripcion, numero_entradas, fecha_creacion);
	    
	    /*Cargador de fotos de eventos en BD*/
		byte[] data = new byte[(int) foto.getSize()];
		foto.getInputStream().read(data, 0, data.length);
	    
		bd.uploadImg(data, titulo);
		
	    response.sendRedirect("/masterticket_admin/eventsdashboard");
	}

}
