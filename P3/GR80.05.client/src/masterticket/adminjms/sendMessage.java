package masterticket.adminjms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;


/**
 * Servlet implementation class SendMessageQueueServlet
 */
@WebServlet(urlPatterns = {"/sendMessage"})
public class sendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;

	@Resource(mappedName="jms/masterticket")
	ConnectionFactory tiwconnectionfactory;
	@Resource(mappedName="jms/queue2")
	Queue queue;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendMessage() {
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
			
			public void doPost(
					javax.servlet.http.HttpServletRequest request,
					javax.servlet.http.HttpServletResponse response)
					throws javax.servlet.ServletException, java.io.IOException {
					
					String quehaocurrido = null;
					try {

						// First create a conection
						 //javax.jms.QueueConnection Qcon = null; //... COMPLETE ....
						 
						 Connection connection = tiwconnectionfactory.createConnection();
					      
					      
						// Next create the session. Indicate that transaction will not be supported
						 //javax.jms.QueueSession QSes = null; //... COMPLETE ....

						 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

							
							// Assign the Queue to the session to create the sender
							 javax.jms.QueueSender Qsen =  null; //... COMPLETE ....
							 
						 MessageProducer messageProducer = session.createProducer(queue);

							// Create a text message
						 javax.jms.TextMessage men = null; //... COMPLETE ....

						 
						 TextMessage textMessage = session.createTextMessage();



						//  We retrieve the message from the parameter and assign in to the one of the queue
						 //men.setText(request.getParameter("message"));
						 textMessage.setText(request.getParameter("message"));

						// Send the message through the sender
						messageProducer.send(textMessage);


						// Close the producer
						// ... COMPLETE ...
						messageProducer.close();	
						
						// Close the session 
						// ... COMPLETE ...
						session.close();
						
						// Close the connection 
						// ... COMPLETE ...
						connection.close();
						
						quehaocurrido = "true";

					} catch (javax.jms.JMSException e) {
				
						
					}catch (Exception e) {
						System.out.println(
							"JHC *************************************** Error in doPost: "
								+ e.toString());
						
					}
					
					request.setAttribute("quehaocurrido", quehaocurrido);
			    	RequestDispatcher disp = context.getRequestDispatcher("/comunications.jsp");
			    	disp.forward(request, response);
				}

				public void doGet(
					javax.servlet.http.HttpServletRequest request,
					javax.servlet.http.HttpServletResponse response)
					throws javax.servlet.ServletException, java.io.IOException {

					try {
						//Llamamos al m�todo doPost con los parametros que recibe este m�todo
						doPost(request, response);
					} catch (Exception e) {
						System.out.println(
							"JHC ***************************************Error in doGet: "
								+ e);
					}

				}

}
