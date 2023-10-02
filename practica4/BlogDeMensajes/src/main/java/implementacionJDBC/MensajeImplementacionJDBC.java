package implementacionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.MensajeDAO;
import dataSource.MiDataSource;
import models.Mensaje;


public class MensajeImplementacionJDBC implements MensajeDAO {

	@Override
	public Object[] mensajesYusuarios() {
		return null;
	}

	@Override
	public void guardarMensaje(Mensaje men, String nom) {
		
	}
	@Override
	public void altaMensaje(String men,Long usuID) {
	
		try {
			
			//obtengo una conexion del pool de conexiones 
			//el método getConnection() no está definido en la clase MiDataSource. Es parte de la interfaz DataSource
			Connection con = MiDataSource.getDataSource().getConnection();
			
            String sql = "INSERT INTO mensajes (mensaje,usuarioId) VALUES (?, ?)";
            System.out.println("-------3 ------ Implementacion de msj. Datos: " + men +"      " + usuID);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, men);
            preparedStatement.setLong(2, usuID);
            
            int filasAfectadas = preparedStatement.executeUpdate();

            System.out.println("Filas afectadas: " + filasAfectadas);

		} catch (SQLException e) {
			//capturar excepcion
			System.out.println(e);
		}
	}
}
