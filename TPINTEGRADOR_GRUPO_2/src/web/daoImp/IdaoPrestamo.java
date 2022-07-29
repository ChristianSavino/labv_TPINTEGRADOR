package web.daoImp;

import java.util.List;

import web.entidades.Prestamo;

public interface IdaoPrestamo {
	public List<Prestamo> listarPrestamos();
	public boolean agregarPrestamo(Prestamo p);
	public boolean modificarPrestamo(Prestamo p);
	public Prestamo obtenerPrestamo(int idPrestamo);
	List<Object[]> listarPrestamosTabla(String fechaAlta, int isbn, String titulo, String nombreAutor,
			String apellidoAutor, String nombreCliente, String apellidoCliente, int dniCliente, String estado);
	boolean eliminarPrestamo(Prestamo p);
}
