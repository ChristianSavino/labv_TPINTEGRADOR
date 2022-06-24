package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IdaoPersona;
import dao.IdaoPrestamo;
import entidades.Persona;
import entidades.Prestamo;
import frgp.utn.edu.ar.negocio.InegPrestamo;

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
}
