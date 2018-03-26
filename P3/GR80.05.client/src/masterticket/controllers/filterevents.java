package masterticket.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.*;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import masterticket.models.Evento;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/filterevents")
public class filterevents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filterevents() {
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
		
		String categoria = request.getParameter("categoria");
		String titulo = request.getParameter("titulo");
		String fecha = request.getParameter("fecha");
		String lugar = request.getParameter("lugar");
		String estado = request.getParameter("estado");
		
		request.setAttribute("categoria_url", categoria);
		
		if(categoria.equals("opera")){
			categoria = "ópera";
		}
		
		if(categoria.equals("monologo")){
			categoria = "monólogo";
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			Date parsed = format.parse(fecha);
	        java.sql.Date sql_date = new java.sql.Date(parsed.getTime());
	        
		}catch(Exception e){
			System.out.println("Ha ocurrido un error parseando fecha");
		}
        
		
		/* Consultamos los eventos con esas condiciones */
		Client client = ClientBuilder.newClient();
		Response serviceResponse = client.target("http://localhost:10504/eventos/"+categoria).queryParam("titulo", titulo).queryParam("fecha", fecha).queryParam("lugar", lugar).queryParam("estado", estado).request(MediaType.APPLICATION_JSON).get(Response.class);
		ArrayList<Evento> resultados = serviceResponse.readEntity(new GenericType<ArrayList<Evento>>() {});
	    
	    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	    
        if(resultados.isEmpty()) {
        	out.println("<p class='text-muted lead text-center'>No hay eventos registrados en esta categoría</p>");
        }else{
        	for(Evento viewevent : resultados) {
        		out.println("<div class='col-md-3 col-sm-4'>"
                                +"<div class='product'>"
                                    +"<div class='image'>"
                                        +"<a href='viewevent?id="+viewevent.getId()+"'>"
                                            +"<img src='visualizarImagen?id="+viewevent.getId()+"' alt='' class='img-responsive image1'>"
                                        +"</a>"
                                    +"</div>"
                                    +"<!-- /.image -->"
                                    +"<div class='text'>"
                                        +"<h3>"+"<a href=viewevent?id="+viewevent.getId()+">"+viewevent.getTitulo()+"</a>"+"</h3>"
                                        +"<p class='price'>"+viewevent.getPrecioEntrada()+"<i class='fa fa-eur' aria-hidden='true'>"+"</i>"+"</p>"
                                        +"<p class='buttons'>"
                                            +"<a href=viewevent?id="+viewevent.getId()+" class='btn btn-default'>Ver evento</a>"
                                            +"<a href=addbasket?id="+viewevent.getId()+" class='btn btn-template-main'>"+"<i class='fa fa-shopping-cart'>"+"</i>Añadir al carrito</a>"
                                        +"</p>"
                                    +"</div>"
                                    +"<!-- /.text -->");
        		if(viewevent.getEstado().equals("disponible")) {
        			out.println("<div class='ribbon new'>"
                            +"<div class='theribbon' style='width:100px !important;'>Disponible</div>"
                            +"<div class='ribbon-background'>"+"</div>"
                        +"</div>");
        		}else if(viewevent.getEstado().equals("completo")) {
        			out.println("<div class='ribbon new' style='color:yellow;'>"
                            +"<div class='theribbon' style='width:100px !important;'>Completo</div>"
                            +"<div class='ribbon-background'>"+"</div>"
                        +"</div>");
        		}else if(viewevent.getEstado().equals("terminado")) {
        			out.println("<div class='ribbon new' style='color:blue;'>"
                            +"<div class='theribbon' style='width:100px !important;'>Terminado</div>"
                            +"<div class='ribbon-background'>"+"</div>"
                        +"</div>");
        		}else{
        			out.println("<div class='ribbon new' style='color:red;'>"
                            +"<div class='theribbon' style='width:100px !important;'>Completo</div>"
                            +"<div class='ribbon-background'>"+"</div>"
                        +"</div>");
        		}

        		out.println("</div>"+
                            "<!-- /.product -->"+
                         "</div>");
        	}
        }
	    
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Nothing to do here */
	}

}
