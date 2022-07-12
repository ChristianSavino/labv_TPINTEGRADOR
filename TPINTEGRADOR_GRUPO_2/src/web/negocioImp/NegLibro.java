package web.negocioImp;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoLibro;
import web.entidades.Libro;
import web.negocio.InegLibro;

@Service("servicioLibro")
public class NegLibro implements InegLibro {

	@Autowired
	private DaoLibro daoLibro;
	
	@Autowired
	private Libro libro;
	
	@Autowired
	private NegAutor iNegAutor;
	
	@Autowired
	private NegComplementos iNegComplementos;
	
	@Override
	public Libro BuscarLibroNuevaBiblioteca(String isbn, String nombre) {
		int isbnAux = 0;
		if (isbn.length() > 0) {
			isbnAux = Integer.parseInt(isbn);
		}
		
		return daoLibro.obtenerLibroFiltroNuevaBiblioteca(isbnAux,nombre);
	}

	@Override
	public Libro obtenerLibro(int isbn) {
		return daoLibro.obtenerLibro(isbn);
	}

	@Override
	public void AgregarLibro(Libro l) {
		daoLibro.agregarLibro(l);		
	}

	public boolean AgregarLibro(String isbn, String titulo, String fechaLanzamiento, String idAutor, String descripcion,
			String idioma, String generos, String cantidadPaginas) {
		try {
			libro.setIsbn(Integer.parseInt(isbn));
			libro.setTitulo(titulo);
			libro.setFechaLanzamiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaLanzamiento));
			libro.setAutor(iNegAutor.obtenerAutor(Integer.parseInt(idAutor)));
			libro.setDescripcion(descripcion);
			libro.setIdioma(idioma);
			
			String[] genero = generos.split("-");
			for (String g : genero) {
				libro.getGeneros().add(iNegComplementos.obtenerGenero(Integer.parseInt(g)));
			}
			
			libro.setCantidadPaginas(Integer.parseInt(cantidadPaginas));
			
			AgregarLibro(libro);
			
			return true;
		} catch (Exception e) {
			return false;
		}	
	}

	
}
