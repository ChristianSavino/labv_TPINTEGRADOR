package dao;

import java.util.List;
import entidades.Prestamo;

public interface IdaoPrestamo {
	public List<Prestamo> listarPrestamos();
	public boolean agregarPrestamo(Prestamo p);
	public boolean modificarPrestamo(Prestamo p);
}