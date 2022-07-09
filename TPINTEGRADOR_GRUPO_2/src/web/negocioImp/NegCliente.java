package web.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoCliente;
import web.entidades.Biblioteca;
import web.entidades.Cliente;
import web.negocio.InegCliente;

@Service("servicioCliente")
public class NegCliente implements InegCliente {

	@Autowired
	private DaoCliente daoCliente;
	
	@Override
	public List<Cliente> listarClientes() {
		return daoCliente.listarClientes();
	}
	
	@Override
	public List<Object[]> listarClienteTabla(String nacionalidad, String nombre, String apellido) {
		String newNacionalidad = "";
		
		if(nacionalidad.length() > 0)
		{
			newNacionalidad = nacionalidad;
		}
		
		String newNombre = "";
		
		if(nombre.length() > 0)
		{
			newNombre = nombre;
		}
		
		String newApellido = "";
		
		if(apellido.length() > 0)
		{
			newApellido = apellido;
		}
		
		return daoCliente.listarClienteTabla(newNacionalidad, newNombre, newApellido);
	}

	@Override
	public boolean agregarCliente(int id, String sexo, String localidad, String direccion, String nombre, String apellido, String
			correo, String telefono, String fecha) {
		try {
		cliente.setId();
		cliente.setSexo();
		Cliente.setLocalidad();
		cliente.setDireccion();
		cliente.setNombre();
		cliente.setApellido();
		cliente.setEmail();
		cliente.setTelefono();
		cliente setFechaNacimiento
		
		return daoCliente.agregarCliente(c);
		}
		catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean modificarCliente(Cliente c) {
		return daoCliente.modificarCliente(c);
	}

	@Override
	public boolean eliminarCliente(Cliente c) {
		return daoCliente.eliminarCliente(c);
	}
	
	@Override
	public Cliente obtenerCliente(int dni) {
		return daoCliente.obtenerCliente(dni);
	}
}
