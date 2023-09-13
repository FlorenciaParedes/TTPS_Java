package ttps.clasificados;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<User> users;

	/**
	 * Default constructor.
	 */

	public Login() {
		users = new ArrayList<User>();
		User user1 = new User("Florencia", "123", "Publicador");
		User user2 = new User("Juan", "123", "Publicador");
		User user3 = new User("María", "123", "Publicador");
		User user4 = new User("Pedro", "123", "Administrador");
		User user5 = new User("Morita", "123", "Administrador");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		for (User user : users) {
			if (user.getName().equals(request.getParameter("userName")) && user.getPass().equals(request.getParameter("clave"))) {
				if (user.getPerfil().equals("Publicador")) {
					response.sendRedirect("/clasificados/publicador.html");
					System.out.println("soy publi");
					return;
				} else if (user.getPerfil().equals("Administrador")) {
					System.out.println("soy admin");
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Menu"); 
					if (dispatcher != null) {
						request.setAttribute("usu", user.getName()); // configura un atributo en el objeto
																		// HttpServletRequest actual. El atributo tiene
																		// nombre del usuario que ha iniciado sesión.
						dispatcher.forward(request, response); // se llama al método forward() en el objeto
																// RequestDispatcher para transferir la solicitud actual
																// (request) y la respuesta (response) al servlet "Menu"
					}
					
					return;
				}
			}
		} 
		response.sendRedirect("/clasificados/error.html");
		
		// System.out.println("SALI POR ACA"+ HttpServletResponse.SC_UNAUTHORIZED );
	
	}

	/** private String publisherUsers() {
		StringBuilder usuarios = new StringBuilder();
		for (User u : users) {
			if (u.getPerfil().equals("Publicador")) {
				usuarios.append(u.getName() + ",");
			}
		}
		System.out.println(usuarios);
		return usuarios.toString();
	}**/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
