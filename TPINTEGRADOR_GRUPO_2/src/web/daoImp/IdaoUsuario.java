package web.daoImp;

import org.springframework.stereotype.Repository;

import web.entidades.Usuario;

public interface IdaoUsuario {
	public Usuario obtenerUsuario(int id);
	public Boolean agregarUsuario(Usuario u);
	public Usuario obtenerUsuarioConPass(String username, String password);
}
