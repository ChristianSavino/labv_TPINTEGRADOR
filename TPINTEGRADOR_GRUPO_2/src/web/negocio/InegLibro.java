package web.negocio;

import web.entidades.Libro;

public interface InegLibro {
		public Libro BuscarLibroNuevaBiblioteca(String isbn, String nombre);
		public Libro obtenerLibro(int isbn);
		public void AgregarLibro(Libro l);
		public boolean AgregarLibro(String isbn, String titulo, String fechaLanzamiento, String idAutor, String descripcion,String idioma, String generos, String cantidadPaginas);
}
