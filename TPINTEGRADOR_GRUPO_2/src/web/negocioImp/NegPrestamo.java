package web.negocioImp;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoPrestamo;
import web.daoImp.IdaoPrestamo;
import web.entidades.Biblioteca;
import web.entidades.Cliente;
import web.entidades.Prestamo;
import web.negocio.InegBiblioteca;
import web.negocio.InegPrestamo;

@Service("servicioPrestamo")
public class NegPrestamo implements InegPrestamo{
	
	@Autowired
	private DaoPrestamo daoPrestamo;
	
	@Autowired
	private Prestamo prestamo;
	
	@Autowired
	private NegBiblioteca iNegBiblioteca;
	
	@Override
	public List<Prestamo> listarPrestamos() {
		return daoPrestamo.listarPrestamos();
	}

	@Override
	public boolean modificarPrestamo(Prestamo p) {
		return daoPrestamo.modificarPrestamo(p);
	}
	
	@Override
	 public Prestamo obtenerPrestamo(int idPrestamo) {
		 return daoPrestamo.obtenerPrestamo(idPrestamo);
	 }

	@Override
	public boolean agregarPrestamo(Biblioteca b, Cliente c, int cantidadDias, String fecha) {	
		try {
			b.setEstado(2);
			
			prestamo.setBiblioteca(b);
			prestamo.setCliente(c);
			prestamo.setCantDias(cantidadDias);
			prestamo.setFechaPrestamo(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			if (daoPrestamo.agregarPrestamo(prestamo))
					iNegBiblioteca.modificarBiblioteca(b);		
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
