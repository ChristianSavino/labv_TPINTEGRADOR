package web.negocioImp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoCliente;
import web.entidades.Cliente;
import web.entidades.Nacionalidad;
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
	public boolean modificarCliente(int id, int dni,String nombre,String apellido,String sexo, int nacionalidad,String fechaNacimiento,String localidad,String direccion,String email,String telefono) {
		try {
			Cliente cliente = daoCliente.obtenerCliente(id);
			cliente.setId(id);
			cliente.setApellido(apellido);
			cliente.setDireccion(direccion);
			cliente.setDni(dni);
			cliente.setEmail(email);
			cliente.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento));
			cliente.setLocalidad(localidad);
			cliente.setNombre(nombre);		
			cliente.setSexo(sexo);
			cliente.setTelefono(telefono);
			cliente.setNacionalidad(iNegComplementos.obtenerNacionalidad(nacionalidad));			
			boolean estado =  daoCliente.modificarCliente(cliente);
			return estado;
		}catch(Exception e){
			return false;
		}
	}
	
	@Override
	public boolean eliminarCliente(Cliente c) {
		return daoCliente.eliminarCliente(c);
	}
	
	@Override
	public Cliente obtenerCliente(int idCliente) {
		return daoCliente.obtenerCliente(idCliente);
	}

}
