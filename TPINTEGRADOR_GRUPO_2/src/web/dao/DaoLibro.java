package web.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.daoImp.IdaoLibro;
import web.entidades.Libro;

@Repository("daoLibro")
public class DaoLibro implements IdaoLibro {
	@Autowired
	private Conexion conexion;

	@Override
	public List<Libro> listarLibros() throws Exception {
		try {
			conexion.abrirConexion();
			List<Libro> listaLibros= (List<Libro>)conexion.getSession().createQuery("FROM Libro l ORDER BY l.isbn asc").list();
			conexion.cerrarSession();

			return listaLibros;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

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

	@Override
	public Libro obtenerLibroFiltroNuevaBiblioteca(int isbn, String nombre) {
		conexion.abrirConexion();
		
		String condicion="";
		if(isbn > 0)
			condicion= " AND l.id = " + isbn;
		if(nombre.length() > 0) 
			condicion += " AND l.titulo= '"+nombre+"'";
		int libro = (int)conexion.obtenerDatoUnicoPorQuery("select l.id from libro l left join biblioteca b on l.id = b.idlibro WHERE b.id is null"+condicion);
		
		Libro l = (Libro)conexion.ObtenerObjeto(Libro.class, libro);
		conexion.cerrarSession();
		return l;
	}
}
