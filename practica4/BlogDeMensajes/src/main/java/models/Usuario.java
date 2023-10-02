package models;

public class Usuario {
	private long usuarioId;
	public long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private String nombre;
	public Usuario(long usuarioId, String nombre) {
		super();
		this.usuarioId = usuarioId;
		this.nombre = nombre;
	}
	public Usuario() {
	}
	
}
