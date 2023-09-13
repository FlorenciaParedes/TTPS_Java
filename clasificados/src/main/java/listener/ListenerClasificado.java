package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import entity.SitioClasificado;

/**
 * Application Lifecycle Listener implementation class ListenerClasificado
 *
 */
@WebListener
public class ListenerClasificado implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerClasificado() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
       SitioClasificado sitio = new SitioClasificado();
       sitio.setNombre((String) sce.getServletContext().getInitParameter("nombreSitio"));
       sitio.setEmail((String) sce.getServletContext().getInitParameter("emailContacto"));
       sitio.setTelefono((String) sce.getServletContext().getInitParameter("telefonoContacto"));
       
       ServletContext contexto = sce.getServletContext(); //Creo una instancia para guardar contexto
	   
       contexto.setAttribute("sitio", sitio);
}
}