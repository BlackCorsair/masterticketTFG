package masterticket.adminjms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadMessageQueueServlet
 */
@WebServlet({ "/readMessage" })
public class readMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
 
	@Resource(mappedName="jms/masterticket")
	ConnectionFactory tiwconnectionfactory;
	@Resource(mappedName="jms/queue")
	Queue queue;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readMessage() {
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

		// TODO Auto-generated method stub

		try {
					//Create the connection
					javax.jms.Connection con = tiwconnectionfactory.createConnection();

					//Create he session (no trasactions)
					javax.jms.Session ses = con.createSession(false, Session.AUTO_ACKNOWLEDGE);

					//Initi connection
					con.start();

					//Create a consumer
					javax.jms.MessageConsumer mc= ses.createConsumer(queue);
					

					ArrayList<String> mensajesRecibidos = new ArrayList<String>();
					Message mensaje = null;
					while (true) {
						mensaje = mc.receive(1000);
						if (mensaje != null) {
							
							if (mensaje instanceof TextMessage) {
								
								TextMessage m = (TextMessage) mensaje;
								mensajesRecibidos.add(m.getText());
							} else {
								// JHC ************ Not the right type
								break;

							}
						} else // there are no messages
							{
							break;
						}

					}

					//Close the session
					ses.close();

					//Close the connection
					con.close();
					
					request.setAttribute("mensajesRecibidos", mensajesRecibidos);
			    	RequestDispatcher disp = context.getRequestDispatcher("/viewcomunications.jsp");
			    	disp.forward(request, response);

				} catch (Exception e) {
					System.out.println(
						"JHC *************************************** Error in doPost: "
							+ e);
				}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Nothing to do here */
			
	}

}
