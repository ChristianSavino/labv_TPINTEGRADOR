package frgp.utn.edu.ar.negocio;

import java.util.List;

import entidades.Prestamo;

public interface InegPrestamo {
	public List<Prestamo> listarPrestamos();
	public boolean agregarPrestamo(Prestamo p);
	public boolean modificarPrestamo(Prestamo p);
	public Prestamo obtenerPrestamo(int idPrestamo);
}
