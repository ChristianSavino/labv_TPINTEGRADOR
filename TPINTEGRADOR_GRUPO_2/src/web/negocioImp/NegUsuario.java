package web.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import web.dao.DaoUsuario;
import web.entidades.Usuario;
import web.negocio.InegUsuario;

@Service("servicioUsuario")
public class NegUsuario implements InegUsuario{

	@Autowired
	private DaoUsuario daoUsuario;
	
	@Override
	public Usuario obtenerUsuario(int id) {
		return daoUsuario.obtenerUsuario(id);
	}
	
	@Override
	public Boolean AgregarUsuario(Usuario u) {
		return daoUsuario.agregarUsuario(u);
	}
	
	@Override
	public Usuario obtenerUsuarioConPass(String username, String password) {
		return daoUsuario.obtenerUsuarioConPass(username, password);
	}
}
