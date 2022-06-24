package daoImp;

import java.util.List;

import entidades.Genero;

public interface IdaoGenero {
	public List<Genero> listarGeneros();
	public boolean agregarGenero(Genero g);
	public boolean modificarGenero(Genero g);
	public boolean eliminarGenero(Genero g);
	public Genero obtenerGenero(int idGenero);
}
