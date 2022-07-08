package web.negocio;

import java.util.List;

import web.entidades.Autor;

public interface InegAutor {
	public List<Autor> listarAutores();	
	public boolean agregarAutor(Autor a);
	public boolean modificarAutor(Autor a);
	public boolean eliminarAutor(Autor a);
	public Autor obtenerAutor(int id);
}
