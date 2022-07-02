package web.negocio;

import web.entidades.Libro;

public interface InegLibro {
		public Libro BuscarLibroNuevaBiblioteca(int isbn, String nombre);
		public Libro obtenerLibro(int isbn);
		public void AgregarLibro(Libro l);
}
