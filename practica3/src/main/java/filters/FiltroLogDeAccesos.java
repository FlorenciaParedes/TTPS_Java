package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
@WebFilter("/*")
public class FiltroLogDeAccesos implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLogDeAccesos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String ip = req.getRemoteAddr();
		
		String metodo = req.getMethod();
		String recurso = req.getRequestURI();
		String user_agent = req.getHeader("User-Agent");
		String protocolo = req.getProtocol();
		
		/**  Obteniendo la fecha    */
		//String fecha = req.getHeader("Date");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String dateHeader = httpResponse.getHeader("Date");


		
		String log = ( " --- Ip: "+ip + " --- Fecha: " + dateHeader + " --- Metodo: " + metodo + "--- Recurso: " + recurso + "--- Protocolo: " + protocolo + "--- user agent: " + user_agent);
		//System.out.println(log);
		
		//System.out.println("Soy el log de accesos");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
