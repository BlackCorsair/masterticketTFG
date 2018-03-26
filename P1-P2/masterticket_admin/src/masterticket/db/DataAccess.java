package masterticket.db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.*;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import masterticket.models.*;

public class DataAccess {
	Connection con;
	Statement st;

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Inicializa conexión JDBC.
	 */
	public boolean openConnection() {
		try {
			String database = "masterticket?useUnicode=true&characterEncoding=utf-8";
			String servername = "localhost";
			String port = "3306";
			String username = "root"; // complete
			String password = "1234"; // complete
			// Load Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Connect to the database
			con = DriverManager.getConnection("jdbc:mysql://" + servername + "/" + database, username, password);
			System.out.println("Sucessful connection to masterticket");
			return true;
		} catch (Exception e) {
			System.out.println("Error when connecting to the database ");
			System.out.println(e.toString());
			return false;
		}
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Ejecuta una query determinada dado su tipo
	 * y devuelve su resultset
	 */
	public ResultSet exQuery(String query, String type) {
		ResultSet rs = null;
		try {
			// Create statement
			st = con.createStatement();
			// Execute statement
			
			if (type.compareTo("SELECT") == 0) {
				rs = st.executeQuery(query);
			} else {
				st.executeUpdate(query);
			}
		} catch (Exception e) {
			System.out.println("Error when opening table");
		}
		return rs;
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Inserta un usuario determinado en la bd.
	 */
	public boolean insertUser(String nombre, String apellidos, String tipo, String email, String password) {
		ResultSet rs = null;
		try {
			// Create statement
			st = con.createStatement();
			// Execute statement
			System.out.println(
					"INSERT INTO `usuarios` (`id`, `nombre`, `apellidos`, `tipo`, `email`, `password`, `created`, `modified`) VALUES (NULL, '"
							+ nombre + "', '" + apellidos + "', '" + tipo + "', '" + email + "', '" + password
							+ "', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP())");
			st.executeUpdate(
					"INSERT INTO `usuarios` (`id`, `nombre`, `apellidos`, `tipo`, `email`, `password`, `created`, `modified`) VALUES (NULL, '"
							+ nombre + "', '" + apellidos + "', '" + tipo + "', '" + email + "', '" + password
							+ "', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP())");
			return true;
		} catch (Exception e) {
			System.out.println("Error when opening table");
			return false;
		}
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Devuelve un resultset con el usuario dado
	 * un email.
	 */
	public ResultSet lookForUser(String email) {
		ResultSet rs = null;
		try {
			// Create statement
			st = con.createStatement();
			// Execute statement
			rs = st.executeQuery("SELECT * FROM usuarios WHERE email = '" + email + "'");
		} catch (Exception e) {
			System.out.println("Error when opening table");
		}
		return rs;
	}

	public boolean insertEvent(int id_usuario, String titulo, String estado, String categoria, InputStream inputStream, int precio_entrada, java.sql.Date fecha, String lugar, String descripcion, int numero_entradas, java.sql.Date fecha_creacion) {  
		try {   
			//Create statement   
			st=con.createStatement();   
			//Execute statement   
			st.executeUpdate("INSERT INTO masterticket.eventos (id_usuario, titulo, estado, categoria, foto, precio_entrada, fecha, lugar, descripcion, numero_entradas, created) values (" + id_usuario + ", '" + titulo + "', '" + estado + "', '" + categoria + "', '" + inputStream + "', " + precio_entrada + ", '" + fecha + "', '" + lugar + "', '" + descripcion + "', " + numero_entradas + ", '" + fecha_creacion + "')");   System.out.println("OK-EVENTO AGREGADO");
			return true;  
		} catch (Exception e) {   
			System.out.println("Error when adding event");   
			return false;  
		}
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Devuelve un resultset con el evento dado
	 * un titulo.
	 */
	public ResultSet lookForEvent(String titulo) {
		ResultSet rs = null;
		try {
			// Create statement
			st = con.createStatement();
			// Execute statement
			rs = st.executeQuery("SELECT * FROM eventos WHERE titulo = " + titulo);
		} catch (Exception e) {
			System.out.println("Error when opening table");
		}
		return rs;
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Inserta un pedido determinado en la bd.
	 */
	public boolean insertOrder(int id_usuario, int precio, String num_tarjeta, int cv2_tarjeta, java.sql.Date caducidad,
			int pagado) {
		try {
			// Create statement
			st = con.createStatement();
			// Execute statement
			java.sql.Date fechaCreacion = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			java.sql.Date fechaModificacion = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			
			st.executeUpdate(
					"INSERT INTO pedidos (id_usuario, precio, num_tarjeta, cv2_tarjeta, caducidad_tarjeta, pagado, created, modified)VALUES (" 
							+ id_usuario +  ", " + precio + ", '" + num_tarjeta + "', " + cv2_tarjeta + ", '" + caducidad
							+ "', " + pagado + ", '" + fechaCreacion+ "', '" + fechaModificacion + "')");
			return true;
		} catch (Exception e) {
			System.out.println("Error when opening table: " + e);
			return false;
		}
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Devuelve un resultset con el pedido dado
	 * un id.
	 */
	public ResultSet lookForOrder(int id) {
		ResultSet rs = null;
		try {
			// Create statement
			st = con.createStatement();
			// Execute statement
			rs = st.executeQuery("SELECT * FROM pedidos WHERE id = " + id);
		} catch (Exception e) {
			System.out.println("Error when opening table");
		}
		return rs;
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Devuelve un ArrayList con objetos de tipo
	 * usuario dado el resultado de una query.
	 */
	public ArrayList<Usuario> retrieveUserData(ResultSet rs) {
		ArrayList<Usuario> resultados = new ArrayList<Usuario>();
		try {
			while (rs.next()) {
				resultados.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("tipo"), rs.getString("email"), rs.getString("password")));
			}
		} catch (Exception e) {
			System.out.println("Error when visualizing information");
		}
		return resultados;
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Devuelve un ArrayList con objetos de tipo
	 * evento dado el resultado de una query.
	 */
	public ArrayList<Evento> retrieveEventData(ResultSet rs) {
		ArrayList<Evento> resultados = new ArrayList<Evento>();
		try {
			while (rs.next()) {
				resultados.add(new Evento(rs.getInt("id"), rs.getInt("id_usuario"), rs.getString("titulo"),
						rs.getString("estado"), rs.getString("categoria"), rs.getString("foto"),
						rs.getInt("precio_entrada"), rs.getDate("fecha"), rs.getString("lugar"),
						rs.getString("descripcion"), rs.getInt("numero_entradas"),
						rs.getInt("numero_entradas_vendidas")));
			}
		} catch (Exception e) {
			System.out.println("Error when visualizing information");
		}
		return resultados;
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Devuelve un ArrayList con objetos de tipo
	 * evento dado el resultado de una query.
	 */
	public ArrayList<Pedido> retrieveOrderData(ResultSet rs) {
		ArrayList<Pedido> resultados = new ArrayList<Pedido>();
		try {
			while (rs.next()) {
				resultados.add(new Pedido(rs.getInt("id"), rs.getInt("id_usuario"), rs.getInt("precio"),
						rs.getString("num_tarjeta"), rs.getInt("cv2_tarjeta"), rs.getDate("caducidad_tarjeta"),
						rs.getInt("pagado")));
			}
		} catch (Exception e) {
			System.out.println("Error when visualizing information");
		}
		return resultados;
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Devuelve un ArrayList con objetos de tipo
	 * eventopedido dado el resultado de una query.
	 */
	public ArrayList<Eventopedido> retrieveEventoPedidoData(ResultSet rs) {
		ArrayList<Eventopedido> resultados = new ArrayList<Eventopedido>();
		try {
			while (rs.next()) {
				resultados.add(new Eventopedido(rs.getInt("id"), rs.getInt("id_evento"), rs.getInt("id_pedido"),
						rs.getInt("id_usuario"), rs.getInt("num_entradas_compradas"), rs.getInt("precio"), 
						rs.getString("nombre"), rs.getString("foto"), rs.getInt("precio_entrada")));
			}
		} catch (Exception e) {
			System.out.println("Error when visualizing information");
		}
		return resultados;
	}

	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Cierra la conexión con la bd
	 */
	public boolean closeConnection() {
		try {
			con.close();
			System.out.println("Connection closed");
			return true;
		} catch (Exception e) {
			System.out.println("Error when closing connection");
			return false;
		}
	}

	public void modifyEvent(Evento modifiedEvent) {
		try {
			//Create statement
			st=con.createStatement();
			System.out.println("OK-ANTES DE ACTUALIZAR");

			//Execute statement
			//st.executeUpdate("UPDATE masterticket.eventos SET titulo='" + modifiedEvent.getTitulo() + "' WHERE id = " + modifiedEvent.getId());
			st.executeUpdate("UPDATE masterticket.eventos SET titulo='" + modifiedEvent.getTitulo() + "', estado='" + modifiedEvent.getEstado() +"', categoria='" + modifiedEvent.getCategoria() +"', foto='" + modifiedEvent.getFoto() +"', precio_entrada=" + modifiedEvent.getPrecioEntradas() +", fecha='" + modifiedEvent.getFecha() +" 22:22:22', lugar='" + modifiedEvent.getLugar() +"', descripcion='" + modifiedEvent.getDescripcion() +"', numero_entradas=" + modifiedEvent.getNumeroEntradas() +" WHERE id = " + modifiedEvent.getId());
			System.out.println("OK-EVENTO MODIFICADO");
		}catch(SQLException e){
			System.out.println("ERROR-when adding event");
			System.out.println("Raz�n: " + e.getMessage());
		}
		
	}
	
	/*
	 * AUTOR: @LCabreroG DESCRIPCIÓN: Sube imagen
	 */
	public int uploadImg(byte[] data, String id) {
		try {
			//Create statement
			st=con.createStatement();
			System.out.println("OK-ANTES DE ACTUALIZAR");

			PreparedStatement ps = con.prepareStatement("UPDATE eventos SET foto = ? WHERE titulo=?");
			ps.setObject(1, data);
			ps.setObject(2, id);
			int rowCount = ps.executeUpdate();
			return rowCount;
		} catch (Exception e) {
			System.out.println("Error when connecting to the database ");
			System.out.println(e.toString());
			return 0;
		}
	}
}
