package web.negocioImp;

import java.text.SimpleDateFormat;
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
	
	@Autowired
	private Cliente cliente;
	
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
	public boolean agregarCliente(String sexo, String localidad, String direccion, String nombre, String apellido, String
			correo, String telefono, String fecha) {
		try {						
			cliente.setSexo(sexo);
			cliente.setLocalidad(localidad);
			cliente.setDireccion(direccion);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setEmail(correo);
			cliente.setTelefono(telefono);
			cliente.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			
			return daoCliente.agregarCliente(cliente);
		}
		catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean modificarCliente(int dni, String nombre, String apellido, Nacionalidad nacionalidad,
			String sexo, String fechaNacimiento, String direccion, String telefono, String localidad, String email) {
		try {
			Cliente cliente = iNegCliente.obtenerCliente(dni);
			cliente.setDni(dni);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setNacionalidad(nacionalidad);
			cliente.setSexo(sexo);
			cliente.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento));
			cliente.setDireccion(direccion);
			cliente.setTelefono(telefono);
			cliente.setLocalidad(localidad);
			cliente.setEmail(email);

			return daoCliente.modificarCliente(cliente);
			/*iNegCliente.modificarCliente(cliente); 
			 * Funcion estaba como string	*/
		}catch(Exception e){		
		}		
		return "redirect:/listadoClientes.html";
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
