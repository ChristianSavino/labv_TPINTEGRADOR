package web.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoAutor;
import web.dao.DaoCliente;
import web.entidades.Autor;
import web.entidades.Cliente;
import web.negocio.InegAutor;

@Service("servicioAutor")
public class NegAutor implements InegAutor{

	@Autowired
	private DaoAutor daoAutor;
	
	@Override
	public List<Autor> listarAutores() {
		return daoAutor.listarAutores();
	}

	@Override
	public boolean agregarAutor(Autor a) {
		return daoAutor.agregarAutor(a);
	}
	
	@Override
	public boolean modificarAutor(Autor a) {
		return daoAutor.modificarAutor(a);
	}
		
	@Override
	public boolean eliminarAutor(Autor a) {
		return daoAutor.eliminarAutor(a);
	}
	
	@Override
	public Autor obtenerAutor(int id) {
		return daoAutor.obtenerAutor(id);
	}
}
