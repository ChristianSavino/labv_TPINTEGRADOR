package web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.daoImp.IdaoPrestamo;
import web.entidades.Cliente;
import web.entidades.Prestamo;

@Repository("daoPrestamo")
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
		Prestamo p = new Prestamo();
		try {
			p = (Prestamo)conexion.ObtenerObjeto(Prestamo.class, idPrestamo);
		} catch (Exception e) {
			p = null;
		}
		conexion.cerrarSession();
		return p;
	}
	
	@Override
	public List<Object[]> listarPrestamosTabla(String fechaAlta, int isbn, String titulo, String nombreAutor, String apellidoAutor, String nombreCliente, String apellidoCliente, int dniCliente) {
		String condiciones = "";
		int cantCondiciones = 0;
		
		if (fechaAlta.length() > 0) {
			condiciones = " and DATE(p.fechaDePrestamo) = '" + fechaAlta + "'";
			cantCondiciones++;
		}
		
		
		
		if(isbn > 0) {
			if(cantCondiciones == 0) {
				condiciones = " and l.id = " + isbn;
				cantCondiciones++;
			}
			else
				condiciones += " AND l.id = " + isbn;
		}
		
		if(titulo.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " and l.titulo = '" + titulo + "'";
				cantCondiciones++;
			}
			else
				condiciones = " AND l.titulo = '" + titulo + "'";
		}
		
		if(nombreAutor.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " and a.nombre = '" + nombreAutor + "'";
				cantCondiciones++;
			}
			else
				condiciones = " AND a.nombre = '" + nombreAutor + "'";
		}
		
		if(apellidoAutor.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " and a.apellido = '" + apellidoAutor + "'";
				cantCondiciones++;
			}
			else
				condiciones = " AND a.apellido = '" + apellidoAutor + "'";
		}
		
		if(nombreCliente.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " and c.nombre = '" + nombreCliente + "'";
				cantCondiciones++;
			}
			else
				condiciones = " AND c.nombre = '" + nombreCliente + "'";
		}
		
		if(apellidoCliente.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " and c.apellido = '" + apellidoCliente + "'";
				cantCondiciones++;
			}
			else
				condiciones = " AND c.apellido = '" + apellidoCliente + "'";
		}
		
		
		if(dniCliente > 0) {
			if(cantCondiciones == 0) {
				condiciones = " and c.dni = " + dniCliente;
				cantCondiciones++;
			}
			else
				condiciones += " AND c.dni = " + dniCliente;
		}
		
		conexion.abrirConexion();
		List<Object[]> listaPrestamos= conexion.ObtenerListaPorQuery("SELECT " + 
				"p.id as idPrestamo, l.titulo as tituloLibro, " + 
				"a.nombre as nombreAutor, " + 
				"a.apellido as apellidoAutor, " + 
				"p.CantidadDias as cantidadDiasPrestamo, DATE_FORMAT(p.fechaDePrestamo, '%d-%m-%Y') as fechaPrestamo, c.nombre as nombreCliente, c.apellido as apellidoCliente, c.dni as dniCliente, c.idCliente as idCliente " + 
				"from prestamo as p " + 
				"join cliente c on p.idCliente = c.idCliente " + 
				"join biblioteca as b on p.idBiblioteca = b.id " + 
				"join libro as l on b.idLibro = l.id " + 
				"join autor as a on l.idAutor = a.idAutor " + 
				"where b.estado = 2 " + condiciones+";");
		conexion.cerrarSession();

		return listaPrestamos;
	}
}
