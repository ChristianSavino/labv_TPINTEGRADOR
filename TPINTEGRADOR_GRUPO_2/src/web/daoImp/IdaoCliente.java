package web.daoImp;

import java.util.List;

import web.entidades.Cliente;

public interface IdaoCliente {
	public List<Cliente> listarClientes();
	public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido);
	public boolean agregarCliente(String sexo, String localidad, String direccion, String nombre, String apellido, String
	correo, String telefono, String fecha);
	public boolean modificarCliente(Cliente cliente, int idCliente);
	public boolean eliminarCliente(Cliente c);
	public Cliente obtenerCliente(int idCliente);
}
