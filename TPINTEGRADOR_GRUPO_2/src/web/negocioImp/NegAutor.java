package web.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoAutor;
import web.entidades.Autor;
import web.entidades.Nacionalidad;
import web.negocio.InegAutor;

@Service("servicioAutor")
public class NegAutor implements InegAutor{

	@Autowired
	private DaoAutor daoAutor;
	
	@Autowired
	private NegComplementos iNegComplementos;
	
	@Autowired
	private Autor autor;
	
	@Override
	public List<Autor> listarAutores() {
		return daoAutor.listarAutores();
	}

	@Override
	public boolean agregarAutor(String nombre, String apellido, int nacionalidad, String email) {
		try {
			autor.setApellido(apellido);
			autor.setEmail(email);
			autor.setNombre(nombre);
			autor.setNacionalidad(iNegComplementos.obtenerNacionalidad(nacionalidad));	
			return daoAutor.agregarAutor(autor);
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean modificarAutor(Autor a) {
		return daoAutor.modificarAutor(a);
	}
		
	@Override
	public boolean eliminarAutor(Autor a) {
		return daoAutor.eliminarAutor(a);
	}
	
	@Override
	public Autor obtenerAutor(int id) {
		return daoAutor.obtenerAutor(id);
	}

	@Override
	public Autor obtenerAutorNombreYApellido(String nombre, String apellido) {
		return daoAutor.obtenerAutorNombreYApellido(nombre,apellido);
	}
	
	@Override
	public List<Object[]> listarAutorTabla(String nacionalidad, String nombre, String apellido) {
		String newNacionalidad = "";
		String newApellido = "";
		String newNombre = "";
		
		if(nacionalidad.length() > 0)
			newNacionalidad = nacionalidad;				
		
		if(nombre.length() > 0)
			newNombre = nombre;
				
		if(apellido.length() > 0)
			newApellido = apellido;
		
		return daoAutor.listarAutorTabla(newNacionalidad, newNombre, newApellido);
	}
}
