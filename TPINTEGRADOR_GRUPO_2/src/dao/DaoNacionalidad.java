package dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import daoImp.IdaoNacionalidad;
import entidades.Nacionalidad;

public class DaoNacionalidad implements IdaoNacionalidad {
	@Autowired
	private Conexion conexion;

	@Override
	public List<Nacionalidad> listarNacionalidades() {
		conexion.abrirConexion();
		List<Nacionalidad> listaNacionalidades= (List<Nacionalidad>)conexion.getSession().createQuery("FROM Nacionalidad n ORDER BY idNacionalidad asc").list();
		conexion.cerrarSession();

		return listaNacionalidades;
	}

	@Override
	public boolean agregarNacionalidad(Nacionalidad n) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(n);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean modificarNacionalidad(Nacionalidad n) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(n);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean eliminarNacionalidad(Nacionalidad n) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.BorrarObjeto(n);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public Nacionalidad obtenerNacionalidad(int idNacionalidad) {
		conexion.abrirConexion();
		Nacionalidad n = new Nacionalidad();
		try {
			n = (Nacionalidad)conexion.ObtenerObjeto(Nacionalidad.class, idNacionalidad);
		} catch (Exception e) {
			n = null;
		}
		conexion.cerrarSession();
		return n;
	}
}
