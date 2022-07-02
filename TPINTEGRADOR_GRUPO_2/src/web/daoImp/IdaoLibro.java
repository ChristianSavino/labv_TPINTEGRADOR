package web.daoImp;

import java.util.List;

import web.entidades.Libro;;

public interface IdaoLibro {
	public List<Libro> listarLibros() throws Exception;
	public boolean agregarLibro(Libro l);
	public boolean modificarLibro(Libro l);
	public boolean eliminarLibro(Libro l);
	public Libro obtenerLibro(int isbn);
	public Libro obtenerLibroFiltroNuevaBiblioteca(int isbn,String nombre);
}
