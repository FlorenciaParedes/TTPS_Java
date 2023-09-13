package ttps.clasificados;
import entity.SitioClasificado;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encabezado
 */
@WebServlet("/Encabezado")
public class Encabezado extends HttpServlet {
	private SitioClasificado sitio;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	public void init() {
		// Obtener los datos del contexto de la aplicación
		sitio = (SitioClasificado) getServletContext().getAttribute("sitio");
	
	}
	public Encabezado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.setContentType("text/html"); //establece que tipo de contenido que se enviará como respuesta al navegador web.
        
        PrintWriter out = response.getWriter(); // obtener una instancia de PrintWriter que permite escribir datos en la respuesta que se enviará al navegador web. 
        out.println("<h1>Datos del Sitio Web</h1>");
        out.println("<p>Nombre del Sitio: " + sitio.getNombre() + "</p>");

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
