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
		List<Cliente> listaAutores= (List<Cliente>)conexion.getSession().createQuery("FROM Cliente a ORDER BY idCliente asc").list();
		conexion.cerrarSession();

		return listaAutores;
	}
	
	@Override
	public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido) {
		String condiciones = "";
		int cantCondiciones = 0;
		
		if (nacionalidad.length() > 0) {
			condiciones = " WHERE c.idNacionalidad = '" + nacionalidad + "'";
			cantCondiciones++;
		}
		
		if(nombre.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " WHERE c.Nombre = '" + nombre + "'";
				cantCondiciones++;
			}
			else
				condiciones += " AND c.Nombre = '" + nombre + "'";
		}
		
		if(apellido.length() > 0) {
			if(cantCondiciones == 0) {
				condiciones = " WHERE c.Apellido = '" + apellido + "'";
				cantCondiciones++;
			}
			else
				condiciones += " AND c.Apellido = '" + apellido + "'";
		}
		
		conexion.abrirConexion();
		List<Object[]> listaClientes= conexion.ObtenerListaPorQuery("SELECT c.Dni as DNI, c.Nombre as Nombre, c.Apellido as Apellido, c.idNacionalidad as Nacionalidad, c.Email as Email, c.Direccion as Direccion, c.Localidad as Localidad, c.Telefono as Teléfono, DATE_FORMAT(c.FechaNacimiento,'%d/%m/%Y') as 'Fecha Nacimiento', c.idCliente as idCliente "
				+ "FROM Cliente as c " + condiciones+";");
		conexion.cerrarSession();

		return listaClientes;
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
