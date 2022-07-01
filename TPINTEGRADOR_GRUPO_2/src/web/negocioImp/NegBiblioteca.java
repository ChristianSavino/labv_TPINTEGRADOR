package web.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoBiblioteca;
import web.entidades.Biblioteca;
import web.negocio.InegBiblioteca;

@Service("servicioBiblioteca")
public class NegBiblioteca implements InegBiblioteca{

	@Autowired
	private DaoBiblioteca daoBiblioteca;
	
	@Override
	public List<Biblioteca> listarBibliotecas(){
		return daoBiblioteca.listarBibliotecas();
	}
	
	@Override
	public List<Object[]> listarBibliotecasTabla(){
		return daoBiblioteca.listarBibliotecasTabla();
	}
	
	@Override
	public boolean agregarBiblioteca(Biblioteca b) {
		return daoBiblioteca.agregarBiblioteca(b);
	}
	
	@Override
	public boolean modificarBiblioteca(Biblioteca b) {
		return daoBiblioteca.modificarBiblioteca(b);
	}
	
	@Override
	public boolean eliminarBiblioteca(Biblioteca b) {
		return daoBiblioteca.eliminarBiblioteca(b);
	}
	
	@Override
	public Biblioteca obtenerLibro(int id) {
		return daoBiblioteca.obtenerLibro(id);
	}
	
}
