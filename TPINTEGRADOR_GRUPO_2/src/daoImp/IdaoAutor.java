package daoImp;

import java.util.List;

import entidades.*;

public interface IdaoAutor {
	public List<Autor> listarAutores();
	public boolean agregarAutor(Autor a);
	public boolean modificarAutor(Autor a);
	public boolean eliminarAutor(Autor a);
	public Autor obtenerAutor(int idAutor);
}
