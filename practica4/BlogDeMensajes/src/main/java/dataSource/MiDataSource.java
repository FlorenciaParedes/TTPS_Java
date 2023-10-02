package dataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MiDataSource {

	private static DataSource dataSource = null;

	// bloque estatico, se corre cuando se usa por primera vez la clase
	// Si se hace un new por primera vez de esa clase o nombreDeClase.metodoDeClase,
	// son cuando las clases en memoria.
	// Se corren esos bloques estaticos. Lo creamos una sola vez y lo invocamos de
	// todos lados
	static {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/practica4");
			//inicializa la variable dataSource utilizando el contexto inicial (InitialContext) 
			//y la función lookup. Esta línea busca una fuente de datos con el nombre "java:comp/env/jdbc/practica4" en el entorno de la aplicación.
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}
