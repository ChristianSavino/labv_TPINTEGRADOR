package web.daoImp;

import java.util.List;

import web.entidades.Biblioteca;

public interface IdaoBiblioteca {
	public List<Biblioteca> listarBibliotecas();
	public List<Object[]> listarBibliotecasTabla(String fechaAlta,int estado, int isbn);
	public boolean agregarBiblioteca(Biblioteca b);
	public boolean modificarBiblioteca(Biblioteca b);
	public boolean eliminarBiblioteca(Biblioteca b);
	public Biblioteca obtenerBiblioteca(int id);
}
