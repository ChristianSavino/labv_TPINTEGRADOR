package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import daoImp.IdaoAutor;
import entidades.Autor;

public class DaoAutor implements IdaoAutor {

	@Autowired
	private Conexion conexion;

	@Override
	public List<Autor> listarAutores() {
		conexion.abrirConexion();
		List<Autor> listaAutores= (List<Autor>)conexion.getSession().createQuery("FROM Autor a ORDER BY idAutor asc").list();
		conexion.cerrarSession();

		return listaAutores;
	}

	@Override
	public boolean agregarAutor(Autor a) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(a);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean modificarAutor(Autor a) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(a);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean eliminarAutor(Autor a){
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.BorrarObjeto(a);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}
	
	@Override
	public Autor obtenerAutor(int idAutor){
		conexion.abrirConexion();
		Autor a = new Autor();
		try {
			a = (Autor)conexion.ObtenerObjeto(Autor.class, idAutor);
		} catch (Exception e) {
			a = null;
		}
		conexion.cerrarSession();
		return a;
	}
}
