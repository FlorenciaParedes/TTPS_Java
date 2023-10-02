package DAO;

import models.Usuario;

public interface UsuarioDAO {

	void altaUsuario(String nom);

	Long getID(String nom);
}
