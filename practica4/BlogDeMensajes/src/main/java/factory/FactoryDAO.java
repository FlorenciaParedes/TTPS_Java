package factory;

import DAO.UsuarioDAO;
import DAO.MensajeDAO;

import implementacionJDBC.UsuarioImplementacionJDBC;
import implementacionJDBC.MensajeImplementacionJDBC;

public class FactoryDAO {
		public static UsuarioDAO getUsuarioDAO(){
			return (UsuarioDAO) new UsuarioImplementacionJDBC();
		}	
		
		public static MensajeDAO getMensajeDAO(){
			return (MensajeDAO) new MensajeImplementacionJDBC();
		}	
}
