package masterticket.auxiliar;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

import java.io.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import masterticket.models.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Servlet implementation class VisualizarImagen
 */
@WebServlet("/visualizarImagen")
public class VisualizarImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarImagen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		//Hacer get con el id
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:10504/eventos/"+id+"/");
		Evento verimagen = webResource.request().accept("application/json").get(Evento.class);
		
		System.out.println(verimagen.getTitulo());
		response.setContentType("image/png");
		response.getOutputStream().write(verimagen.getFoto());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
