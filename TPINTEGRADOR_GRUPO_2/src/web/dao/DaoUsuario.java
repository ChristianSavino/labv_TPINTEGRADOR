package web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import web.daoImp.IdaoUsuario;
import web.entidades.Usuario;

@Repository("daoUsuario")
public class DaoUsuario implements IdaoUsuario {

	@Autowired
	private Conexion conexion;

	@Override
	public Usuario obtenerUsuario(int id) {
		conexion.abrirConexion();
		Usuario u = new Usuario();
		try {
			u = (Usuario)conexion.ObtenerObjeto(Usuario.class, id);
		} catch (Exception e) {
			u = null;
		}
		conexion.cerrarSession();
		return u;
	}

	@Override
	public Boolean agregarUsuario(Usuario u) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(u);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public Usuario obtenerUsuarioConPass(String username, String password) {
		conexion.abrirConexion();
		Usuario u = (Usuario)conexion.getSession().createQuery("FROM Usuario u WHERE username='" + username + "' AND password='" + password + "'").uniqueResult();
		conexion.cerrarSession();

		return u;
	}
}
