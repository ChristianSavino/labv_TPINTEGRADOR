package web.negocio;

import web.entidades.Usuario;


public interface InegUsuario {
	public Usuario obtenerUsuario(int id);
	public Boolean AgregarUsuario(Usuario u);
	public Usuario obtenerUsuarioConPass(String username, String password);
}
