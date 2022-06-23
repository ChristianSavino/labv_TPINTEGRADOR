package dao;

import java.util.List;
import entidades.Libro;;

public interface IdaoLibro {
	public List<Libro> listarLibros();
	public boolean agregarLibro(Libro l);
	public boolean modificarLibro(Libro l);
	public boolean eliminarLibro(Libro l);
	public Libro obtenerLibro(int isbn);
}
