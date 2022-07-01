package web.negocio;

import java.util.List;

import web.entidades.Biblioteca;


public interface InegBiblioteca {
	public List<Biblioteca> listarBibliotecas();
	public List<Object[]> listarBibliotecasTabla();
	public boolean agregarBiblioteca(Biblioteca b);
	public boolean modificarBiblioteca(Biblioteca b);
	public boolean eliminarBiblioteca(Biblioteca b);
	public Biblioteca obtenerLibro(int id);
}
