package web.daoImp;

import java.util.List;

import web.entidades.*;

public interface IdaoAutor {
	public List<Autor> listarAutores();
	public boolean agregarAutor(Autor a);
	public boolean modificarAutor(Autor a);
	public boolean eliminarAutor(Autor a);
	public Autor obtenerAutor(int idAutor);
	public Autor obtenerAutorNombreYApellido(String nombre,String apellido);
	List<Object[]> listarAutorTabla(String nacionalidad, String nombre, String apellido);
}
