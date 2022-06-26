package web.daoImp;

import java.util.List;

import web.entidades.Prestamo;

public interface IdaoPrestamo {
	public List<Prestamo> listarPrestamos();
	public boolean agregarPrestamo(Prestamo p);
	public boolean modificarPrestamo(Prestamo p);
	public Prestamo obtenerPrestamo(int idPrestamo);
}
