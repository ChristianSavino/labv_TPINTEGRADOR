package web.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoLibro;
import web.entidades.Libro;
import web.negocio.InegLibro;

@Service("servicioLibro")
public class NegLibro implements InegLibro {

	@Autowired
	private DaoLibro daoLibro;
	
	@Override
	public Libro BuscarLibroNuevaBiblioteca(int isbn, String nombre) {
		return daoLibro.obtenerLibroFiltroNuevaBiblioteca(isbn,nombre);
	}

	@Override
	public Libro obtenerLibro(int isbn) {
		return daoLibro.obtenerLibro(isbn);
	}

	@Override
	public void AgregarLibro(Libro l) {
		daoLibro.agregarLibro(l);		
	}

	
}
