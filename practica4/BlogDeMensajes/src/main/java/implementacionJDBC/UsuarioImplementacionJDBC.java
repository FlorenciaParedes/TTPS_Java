package implementacionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import DAO.UsuarioDAO;
import dataSource.MiDataSource;
import models.Usuario;


public class UsuarioImplementacionJDBC implements UsuarioDAO{

	@Override
	public void altaUsuario(String nom) {
	
		
		try {
			
			//obtengo una conexion del pool de conexiones 
			//el método getConnection() no está definido en la clase MiDataSource. Es parte de la interfaz DataSource
			Connection con = MiDataSource.getDataSource().getConnection();
			// Crear un objeto Statement
			//Statement st = con.createStatement();		
			
            String sql = "INSERT INTO usuarios (NOMBRE) VALUES (?)";
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, nom);
            
            //int filasAfectadas = st.executeUpdate(sql);
            int filasAfectadas = preparedStatement.executeUpdate();

            System.out.println("Filas afectadas: " + filasAfectadas);

		} catch (SQLException e) {
			//capturar excepcion
			System.out.println(e);
		}
	}

	@Override
	public Long getID(String nom) {
		try{
			System.out.println("----- 2 ---- Soy implementacion de usuARIO en get id ");

			Connection con = MiDataSource.getDataSource().getConnection();
			
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM practica4.usuarios WHERE nombre=?");
			ps.setString(1, nom);
			System.out.println(ps);
			ResultSet resul = ps.executeQuery();
            //System.out.println("El result me trajo: "+resul.next() + " el id es: " +  resul.getLong("usuarioId"));
            if (resul.next()) {
            
            	// Crear un objeto Usuario con los datos del resultado
    			System.out.println("Entre al RESULT:  " + resul.getLong("usuarioId") + " " + resul.getString("nombre"));

                Usuario usuario = new Usuario();
                usuario.setUsuarioId(resul.getLong("usuarioId")); // Suponiendo que tienes una columna "id" en tu tabla
                usuario.setNombre(resul.getString("nombre"));
                
                // Cerrar la conexión y el ResultSet
                resul.close();
                ps.close();
                con.close();
        		System.out.println("usuario ID: " + usuario.getUsuarioId());

                return usuario.getUsuarioId();
            }
		} catch (SQLException e) {
			//capturar excepcion
			System.out.println("eeeeeeeeeeeeeo exception ");
			System.out.println(e);
		}
		return null;
	}

}
