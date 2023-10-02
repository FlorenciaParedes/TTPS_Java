package DAO;
import models.Mensaje;

// Tienen las operaciones CRUD 
//metodos candidatos que luego seran implementados por las implementaciones.
//
public interface MensajeDAO {
	//a TODOS los mensajes publicados y el	usuario que lo publicó
	Object[] mensajesYusuarios();
	//Permite ingresar el texto de un mensaje a publicar y el nombre de quien lo hace
	void guardarMensaje(Mensaje men,String nom);
	void altaMensaje(String men,Long usuID);
}
