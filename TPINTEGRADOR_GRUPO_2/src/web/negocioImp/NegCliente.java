package web.negocioImp;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoCliente;
import web.dao.DaoNacionalidad;
import web.entidades.Biblioteca;
import web.entidades.Cliente;
import web.negocio.InegCliente;

@Service("servicioCliente")
public class NegCliente implements InegCliente {

	@Autowired
	private DaoCliente daoCliente;
	
	@Autowired
	private NegComplementos iNegComplementos;
	
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
	public boolean agregarCliente(String dni,String nombre,String apellido,String sexo, int nacionalidad,String fechaNacimiento,String localidad,String direccion,String email,String telefono){
		try {
			int dniInt;
			cliente.setApellido(apellido);
			cliente.setDireccion(direccion);
			dniInt = Integer.parseInt(dni);
			cliente.setDni(dniInt);
			cliente.setEmail(email);
			cliente.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento));
			cliente.setLocalidad(localidad);
			cliente.setNombre(nombre);		
			cliente.setSexo(sexo);
			cliente.setTelefono(telefono);
			cliente.setNacionalidad(iNegComplementos.obtenerNacionalidad(nacionalidad));
			return daoCliente.agregarCliente(cliente);
		}
		catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean modificarCliente(int dni, String nombre, String apellido, String nacionalidad,
			String sexo, String fechaNacimiento, String direccion, String telefono, String localidad, String email) {
		try {
			Cliente cliente = daoCliente.obtenerCliente(dni);
			cliente.setDni(dni);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setNacionalidad(iNegComplementos.obtenerNacionalidad(Integer.parseInt(nacionalidad)));
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
		return true;
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
