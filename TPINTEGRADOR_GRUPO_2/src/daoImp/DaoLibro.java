package daoImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.IdaoLibro;
import entidades.Libro;

public class DaoLibro implements IdaoLibro {
	@Autowired
	private Conexion conexion;

	@Override
	public List<Libro> listarLibros() {
		conexion.abrirConexion();
		List<Libro> listaLibros= (List<Libro>)conexion.getSession().createQuery("FROM Libro l ORDER BY l.id asc").list();
		conexion.cerrarSession();

		return listaLibros;
	}

	@Override
	public boolean agregarLibro(Libro l) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(l);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean modificarLibro(Libro l) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(l);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean eliminarLibro(Libro l) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.BorrarObjeto(l);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public Libro obtenerLibro(int isbn) {
		conexion.abrirConexion();
		Libro l = new Libro();
		try {
			l = (Libro)conexion.ObtenerObjeto(Libro.class, isbn);
		} catch (Exception e) {
			l = null;
		}
		conexion.cerrarSession();
		return l;
	}
}
