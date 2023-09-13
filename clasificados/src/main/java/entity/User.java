package entity;

public class User {

	private String name;
	private String pass;
	private String perfil;
	
	public User(String name, String pass, String perfil) {
		super();
		this.name = name;
		this.pass = pass;
		this.perfil = perfil;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}


