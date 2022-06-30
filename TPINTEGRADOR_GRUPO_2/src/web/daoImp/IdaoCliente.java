package web.daoImp;

import java.util.List;

import web.entidades.Cliente;

public interface IdaoCliente {
	public List<Cliente> listarClientes();
	public boolean agregarCliente(Cliente c);
	public boolean modificarCliente(Cliente c);
	public boolean eliminarCliente(Cliente c);
	public Cliente obtenerCliente(int idCliente);
}