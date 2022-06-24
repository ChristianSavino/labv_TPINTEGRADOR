package frgp.utn.edu.ar.negocio;

import java.util.List;

import entidades.Biblioteca;


public interface InegBiblioteca {
	public List<Biblioteca> listarBibliotecas();
	public boolean agregarBiblioteca(Biblioteca b);
	public boolean modificarBiblioteca(Biblioteca b);
	public boolean eliminarBiblioteca(Biblioteca b);
	public Biblioteca obtenerLibro(int id);
}
