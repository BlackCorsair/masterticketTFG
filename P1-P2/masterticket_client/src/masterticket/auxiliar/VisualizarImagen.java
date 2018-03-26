package masterticket.auxiliar;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

import java.io.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import masterticket.db.DataAccess;
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
		
		DataAccess bd = new DataAccess();
	    bd.openConnection();
	    ResultSet rs = bd.exQuery("SELECT * FROM eventos WHERE id="+id , "SELECT");
	    
	    try{
	    	while(rs.next()){
	    		response.setContentType("image/png");
	    		System.out.println(rs.getBytes("foto"));
	    		response.getOutputStream().write(rs.getBytes("foto"));
	    		
	    		response.reset();
	            response.setContentType("image/png");
	            // Write image content to response.
	            response.getOutputStream().write(rs.getBytes("foto"));
		    }
		    bd.closeConnection();
	    }catch(Exception e){
	    	System.out.println("Error cogiendo foto");
	    }
	    
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
