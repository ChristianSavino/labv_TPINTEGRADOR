package web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.daoImp.IdaoAutor;
import web.entidades.Autor;

@Repository("daoAutor")
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

	@Override
	public Autor obtenerAutorNombreYApellido(String nombre, String apellido) {
		conexion.abrirConexion();
		Autor autor= (Autor)conexion.getSession().createQuery("FROM Autor a WHERE a.nombre= '"+nombre+"' AND a.apellido= '"+apellido+"'").uniqueResult();
		conexion.cerrarSession();

		return autor;
	}
	
	@Override
	public List<Object[]> listarAutorTabla(String nacionalidad, String nombre, String apellido) {
		String condiciones = "";
		int cantCondiciones = 0;
		
		if (nacionalidad.length() > 0) {
			condiciones = " WHERE n.descripcion= '" + nacionalidad + "'";
			cantCondiciones++;
		}
		
		if(nombre.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " WHERE a.nombre = '" + nombre + "'";
				cantCondiciones++;
			}
			else
				condiciones += " AND a.nombre = '" + nombre + "'";
		}
		
		if(apellido.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " WHERE a.apellido = '" + apellido + "'";
				cantCondiciones++;
			}
			else
				condiciones += " AND a.apellido = '" + apellido + "'";
		}
		
		conexion.abrirConexion();
		List<Object[]> listaAutores= conexion.ObtenerListaPorQuery("select a.idAutor as idAutor, a.nombre as nombre, a.apellido as apellido, n.descripcion as nacionalidad,"
				+"a.email as email from autor as a join nacionalidad as n on n.idNacionalidad = a.idNacionalidad" + condiciones+";");
		conexion.cerrarSession();

		return listaAutores;
	}
}
