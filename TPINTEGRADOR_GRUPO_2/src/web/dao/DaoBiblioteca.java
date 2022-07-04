package web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.daoImp.IdaoBiblioteca;
import web.entidades.Biblioteca;

@Repository("daoBiblioteca")
public class DaoBiblioteca implements IdaoBiblioteca {
	@Autowired
	private Conexion conexion;

	@Override
	public List<Biblioteca> listarBibliotecas() {
		conexion.abrirConexion();
		List<Biblioteca> listaBibliotecas= (List<Biblioteca>)conexion.getSession().createQuery("FROM Biblioteca b ORDER BY b.id asc").list();
		conexion.cerrarSession();

		return listaBibliotecas;
	}
	
	@Override
	public List<Object[]> listarBibliotecasTabla(String fechaAlta, int estado, int isbn,String titulo) {
		String condiciones = "";
		int cantCondiciones = 0;
		
		if (fechaAlta.length() > 0) {
			condiciones = " WHERE DATE(b.fechaDeAlta) = '" + fechaAlta + "'";
			cantCondiciones++;
		}
		
		if(estado > 0) {
			if(cantCondiciones == 0) {
				condiciones = " WHERE b.estado = " + estado;
				cantCondiciones++;
			}
			else
				condiciones += " AND b.estado = " + estado;
		}
		
		if(isbn > 0) {
			if(cantCondiciones == 0) {
				condiciones = " WHERE l.id = " + isbn;
				cantCondiciones++;
			}
			else
				condiciones += " AND l.id = " + isbn;
		}
		
		if(titulo.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " WHERE l.titulo = '" + titulo + "'";
				cantCondiciones++;
			}
			else
				condiciones = " AND l.titulo = '" + titulo + "'";
		}
		
		conexion.abrirConexion();
		List<Object[]> listaBibliotecas= conexion.ObtenerListaPorQuery("SELECT b.id as Codigo, l.id as ISBN, l.titulo as Titulo, DATE_FORMAT(b.fechaDeAlta,'%d/%m/%Y') as 'Fecha Alta', CASE WHEN b.estado = 1 THEN 'Disponible' ELSE 'Prestado' END as Estado "
				+ "FROM biblioteca b INNER JOIN libro l ON b.idlibro = l.id" + condiciones+";");
		conexion.cerrarSession();

		return listaBibliotecas;
	}

	@Override
	public boolean agregarBiblioteca(Biblioteca b) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(b);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean modificarBiblioteca(Biblioteca b) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(b);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean eliminarBiblioteca(Biblioteca b) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.BorrarObjeto(b);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public Biblioteca obtenerBiblioteca(int id) {
		conexion.abrirConexion();
		Biblioteca b = new Biblioteca();
		try {
			b = (Biblioteca)conexion.ObtenerObjeto(Biblioteca.class, id);
		} catch (Exception e) {
			b = null;
		}
		conexion.cerrarSession();
		return b;
	}
}
