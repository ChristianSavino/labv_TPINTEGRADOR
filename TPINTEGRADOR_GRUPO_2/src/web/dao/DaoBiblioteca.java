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
	public Biblioteca obtenerLibro(int id) {
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
