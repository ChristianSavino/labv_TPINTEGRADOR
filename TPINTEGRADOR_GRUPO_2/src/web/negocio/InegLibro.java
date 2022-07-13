package web.negocio;

import java.util.List;

import web.entidades.Libro;

public interface InegLibro {
		public Libro BuscarLibroNuevaBiblioteca(String isbn, String nombre);
		public Libro obtenerLibro(int isbn);
		public void AgregarLibro(Libro l);
		public boolean AgregarLibro(String isbn, String titulo, String fechaLanzamiento, String idAutor, String descripcion,String idioma, String generos, String cantidadPaginas);
		public List<Object[]> listarLibroTabla(int isbn, String nombre);
		List<Object[]> listarNuevoLibroTabla(int isbn, String nombre);
}
