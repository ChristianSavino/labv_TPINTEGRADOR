package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import daoImp.IdaoPrestamo;
import entidades.Cliente;
import entidades.Prestamo;

public class DaoPrestamo implements IdaoPrestamo{
	@Autowired
	private Conexion conexion;

	@Override
	public List<Prestamo> listarPrestamos() {
		conexion.abrirConexion();
		List<Prestamo> listaPrestamos= (List<Prestamo>)conexion.getSession().createQuery("FROM Prestamo p ORDER BY p.id asc").list();
		conexion.cerrarSession();

		return listaPrestamos;
	}

	@Override
	public boolean agregarPrestamo(Prestamo p) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(p);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean modificarPrestamo(Prestamo p) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(p);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}
	
	@Override
	public Prestamo obtenerPrestamo(int idPrestamo){
		conexion.abrirConexion();
		Prestamo a = new Prestamo();
		try {
			a = (Prestamo)conexion.ObtenerObjeto(Prestamo.class, idPrestamo);
		} catch (Exception e) {
			a = null;
		}
		conexion.cerrarSession();
		return a;
	}
}
