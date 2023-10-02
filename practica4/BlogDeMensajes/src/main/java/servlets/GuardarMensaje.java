package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MensajeDAO;
import DAO.UsuarioDAO;
import factory.FactoryDAO;

/**
 * Servlet implementation class GuardarMensaje
 */
@WebServlet("/GuardarMensaje")
public class GuardarMensaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarMensaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--- 1 Servlet --- Nombre: " + (String) request.getParameter("nombre") + " msj:  " +(String) request.getParameter("mensaje"));
		UsuarioDAO uDAO = FactoryDAO.getUsuarioDAO();
		//uDAO.altaUsuario((String) request.getParameter("nombre"));
		
		Long uID = uDAO.getID((String) request.getParameter("nombre"));
		System.out.println("----Volvi al servler ---- El user ID:  " + uID);
		MensajeDAO mDAO = FactoryDAO.getMensajeDAO();
		mDAO.altaMensaje((String) request.getParameter("mensaje"),(Long) uID);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
