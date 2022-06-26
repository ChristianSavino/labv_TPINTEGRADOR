package web.negocio;

import java.util.List;

import web.entidades.Prestamo;

public interface InegPrestamo {
	public List<Prestamo> listarPrestamos();
	public boolean agregarPrestamo(Prestamo p);
	public boolean modificarPrestamo(Prestamo p);
	public Prestamo obtenerPrestamo(int idPrestamo);
}
