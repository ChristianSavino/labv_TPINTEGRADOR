package negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daoImp.IdaoPrestamo;
import entidades.Prestamo;
import negocio.InegPrestamo;

@Service("servicioPrestamo")
public class NegPrestamo implements InegPrestamo{
	
	@Autowired
	private IdaoPrestamo daoPrestamo;
	
	@Override
	public List<Prestamo> listarPrestamos() {
		return daoPrestamo.listarPrestamos();
	}

	@Override
	public boolean agregarPrestamo(Prestamo p) {
		return daoPrestamo.agregarPrestamo(p);
	}
	
	@Override
	public boolean modificarPrestamo(Prestamo p) {
		return daoPrestamo.modificarPrestamo(p);
	}
	
	@Override
	 public Prestamo obtenerPrestamo(int idPrestamo) {
		 return daoPrestamo.obtenerPrestamo(idPrestamo);
	 }
}
