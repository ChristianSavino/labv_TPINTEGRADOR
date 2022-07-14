package web.negocio;

import java.util.List;

import web.entidades.Biblioteca;
import web.entidades.Cliente;
import web.entidades.Prestamo;

public interface InegPrestamo {
	public List<Prestamo> listarPrestamos();
	public boolean agregarPrestamo(Biblioteca b,Cliente c,int cantidadDias,String fecha);
	public boolean modificarPrestamo(Prestamo p);
	public Prestamo obtenerPrestamo(int idPrestamo);
	List<Object[]> listarPrestamosTabla(String fechaAlta, String isbn, String titulo, String nombreAutor,
			String apellidoAutor, String nombreCliente, String apellidoCliente, String dniCliente);
	boolean eliminarPrestamo(Prestamo p);
}
