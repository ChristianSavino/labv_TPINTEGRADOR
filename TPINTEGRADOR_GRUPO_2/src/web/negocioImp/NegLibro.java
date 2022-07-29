package web.negocioImp;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoLibro;
import web.entidades.Genero;
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
	public List<Object[]> listarLibroTabla(int isbn, String nombre) {
		int newIsbn = 0;
		
		if(isbn > 0)
		{
			newIsbn = isbn;
		}
		
		String newNombre = "";
		
		if(nombre.length() > 0)
		{
			newNombre = nombre;
		}
		
		return daoLibro.listarLibroTabla(newIsbn, newNombre);
	}
	
	@Override
	public List<Object[]> listarNuevoLibroTabla(int isbn, String nombre) {
		int newIsbn = 0;
		
		if(isbn > 0)
		{
			newIsbn = isbn;
		}
		
		String newNombre = "";
		
		if(nombre.length() > 0)
		{
			newNombre = nombre;
		}
		
		return daoLibro.listarNuevoLibroTabla(newIsbn, newNombre);
	}

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
	public boolean AgregarLibro(Libro l) {
		return daoLibro.agregarLibro(l);		
	}

	public boolean AgregarLibro(String isbn, String titulo, String fechaLanzamiento, String idAutor, String descripcion,
			String idioma, String generos, String cantidadPaginas) {
		try {
			libro = new Libro();
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
			
			return AgregarLibro(libro);
			
		} catch (Exception e) {
			return false;
		}	
	}

	
}
