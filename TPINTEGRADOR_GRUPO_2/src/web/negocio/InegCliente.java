package web.negocio;

import java.util.List;

import web.entidades.Biblioteca;
import web.entidades.Cliente;

public interface InegCliente {

	public List<Cliente> listarClientes();
	public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido);
	public boolean agregarCliente(String sexo, String localidad, String direccion, String nombre, String apellido, String
			correo, String telefono, String fecha);
	public boolean modificarCliente(Cliente c);
	public boolean eliminarCliente(Cliente c);
	public Cliente obtenerCliente(int dni);
}
