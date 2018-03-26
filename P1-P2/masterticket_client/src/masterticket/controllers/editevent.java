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

import masterticket.auxiliar.DateFormatter;
import masterticket.db.DataAccess;
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
		// Comprobamos que hay un usuario en sesi�n.
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
		
		int id = Integer.parseInt(request.getParameter("id"));
	
		DataAccess bd = new DataAccess();
	    bd.openConnection();
	    ResultSet rs = null;
		//rs = bd.exQuery("SELECT * FROM eventos WHERE id="+id, "SELECT");

	    rs = bd.exQuery("SELECT * FROM eventos WHERE id = "+id, "SELECT");
	    ArrayList<Evento> resultados = bd.retrieveEventData(rs);
		bd.closeConnection();
		
		
		if (!resultados.isEmpty()){
			Evento editar = resultados.get(0);
			/* Pasamos variables a la vista para saber los datos actuales */
			session.setAttribute("modifiedEvent", editar);
			RequestDispatcher disp = context.getRequestDispatcher("/edit-event.jsp");
		    disp.forward(request, response);
		}else{
			response.sendRedirect("/masterticket_client/index.jsp");    	
		}
    	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Comprobamos que hay un usuario en sesión.
		HttpSession session = request.getSession();
		Usuario user = (Usuario)session.getAttribute("User");
		Evento modifiedEvent = (Evento)session.getAttribute("modifiedEvent");
		
		
		int idEvento = modifiedEvent.getId();
		System.out.println("el id es del evento a modificar es:" + idEvento);
		/*Conecta con la DB y modifica los valores*/
		DataAccess bd = new DataAccess();
		bd.openConnection();
		modifiedEvent.setTitulo((String)request.getParameter("titulo"));
		modifiedEvent.setEstado((String)request.getParameter("estado"));
		modifiedEvent.setCategoria((String)request.getParameter("categoria"));
		modifiedEvent.setFoto((String)request.getParameter("foto"));
		System.out.println(request.getParameter("precio_entrada"));
		int precio_entrada = Integer.parseInt(request.getParameter("precio_entrada"));
		
		modifiedEvent.setPrecioEntradas(precio_entrada);
		System.out.println("String fecha en datetime local es: " + (String)request.getParameter("fecha"));
		modifiedEvent.setFecha(DateFormatter.DTLocalToDBDate((String)request.getParameter("fecha")));
		modifiedEvent.setLugar((String)request.getParameter("lugar"));
		modifiedEvent.setDescripcion((String)request.getParameter("descripcion"));
		System.out.println(request.getParameter("numero_entradas"));
		int num_entradas = Integer.parseInt(request.getParameter("numero_entradas"));
		
		modifiedEvent.setNumeroEntradas(num_entradas);
		bd.modifyEvent(modifiedEvent);
		bd.closeConnection();
					
    	/*Muestra de par�metros por consola*/
    	Enumeration en=request.getParameterNames();	 
		while(en.hasMoreElements())
		{
			Object objOri=en.nextElement();
			String param=(String)objOri;
			String value=request.getParameter(param);
			System.out.println("Parameter Name is '"+param+"' and Parameter Value is '"+value+"'");
		}
		
		Part foto = request.getPart("foto");
		
		
		
		    
		    /*Cargador de fotos de eventos en BD*/
			byte[] data = new byte[(int) foto.getSize()];
			foto.getInputStream().read(data, 0, data.length);
		    
			bd.uploadImg(data, (String)request.getParameter("titulo"));

		
    	//RequestDispatcher disp = context.getRequestDispatcher("eventsdashboard");
    	//System.out.println("ya ha creado el disp");
    	//disp.forward(request, response);
		
		response.sendRedirect("/masterticket_client/eventsdashboard");


	}

}