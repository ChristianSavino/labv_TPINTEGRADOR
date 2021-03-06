package web.negocio;

import java.util.List;

import web.entidades.Biblioteca;


public interface InegBiblioteca {
	public List<Biblioteca> listarBibliotecas();
	public List<Object[]> listarBibliotecasTabla(String fechaAlta,String estado, String isbn,String titulo);
	public boolean agregarBiblioteca(int isbn,String fechaAlta);
	public boolean modificarBiblioteca(Biblioteca b);
	public boolean modificarBiblioteca(int id, int estado, String fechaAlta);
	public boolean eliminarBiblioteca(Biblioteca b);
	public Biblioteca obtenerBiblioteca(int id);
}
