package models;

public class Mensaje {

	private long mensajeId;
	private String mensaje;
	private long usuarioId;
	
	public Mensaje(long mensajeId, String mensaje) {
		super();
		this.mensajeId = mensajeId;
		this.mensaje = mensaje;
	}
	public long getMensajeId() {
		return mensajeId;
	}
	public void setMensajeId(long mensajeId) {
		this.mensajeId = mensajeId;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

}
