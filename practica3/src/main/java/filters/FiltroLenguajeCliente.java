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

/**
 * Servlet Filter implementation class FiltroLenguajeCliente
 */
@WebFilter("/*")
public class FiltroLenguajeCliente implements Filter {
	 //private FilterConfig config;

    /**
     * Default constructor. 
     */
    public FiltroLenguajeCliente() {
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
		//String idioma = req.getHeader("Accept-Language").substring(0, 2);
			
		String idioma = (String) req.getLocale().getLanguage();
		System.out.println("Filtro de lenguajes   " + idioma );

		String lenguaje;
		if(idioma == "es") {
			 System.out.println("soy es");
			  lenguaje = "textos_es.properties";
		}else {
			
			  lenguaje = "textos_en.properties";
		}
		//config.getServletContext().setAttribute("lenguaje", lenguaje);

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
