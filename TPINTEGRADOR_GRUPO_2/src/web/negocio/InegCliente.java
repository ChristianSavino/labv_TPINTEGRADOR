package web.negocio;

import java.util.List;

import web.entidades.Biblioteca;
import web.entidades.Cliente;

public interface InegCliente {

	public List<Cliente> listarClientes();
	public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido);
	public boolean agregarCliente(String sexo, String localidad, String direccion, String nombre, String apellido, String
			correo, String telefono, String fecha, String nacionalidad);
	public boolean modificarCliente(int dni, String nombre, String apellido, String nacionalidad, String sexo, String fechaNacimiento, String direccion, String telefono, String localidad, String email);
	public boolean eliminarCliente(Cliente c);
	public Cliente obtenerCliente(int dni);
}
