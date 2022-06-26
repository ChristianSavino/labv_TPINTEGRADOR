package web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.daoImp.IdaoCliente;
import web.entidades.Cliente;

@Repository("daoCliente")
public class DaoCliente implements IdaoCliente{

	@Autowired
	private Conexion conexion;

	@Override
	public List<Cliente> listarClientes() {
		conexion.abrirConexion();
		List<Cliente> listaAutores= (List<Cliente>)conexion.getSession().createQuery("FROM Autor a ORDER BY idAutor asc").list();
		conexion.cerrarSession();

		return listaAutores;
	}

	@Override
	public boolean agregarCliente(Cliente c) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.GuardarObjeto(c);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean modificarCliente(Cliente c) {
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.ActualizarObjeto(c);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}

	@Override
	public boolean eliminarCliente(Cliente c){
		conexion.abrirConexion();
		boolean exito = true;
		try {
			conexion.IniciarTransaccion();
			conexion.BorrarObjeto(c);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackearTransaccion();
			exito = false;
		}
		conexion.cerrarSession();
		return exito;
	}
	
	@Override
	public Cliente obtenerCliente(int idCliente){
		conexion.abrirConexion();
		Cliente a = new Cliente();
		try {
			a = (Cliente)conexion.ObtenerObjeto(Cliente.class, idCliente);
		} catch (Exception e) {
			a = null;
		}
		conexion.cerrarSession();
		return a;
	}
}
