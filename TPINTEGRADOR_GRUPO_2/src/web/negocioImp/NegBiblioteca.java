package web.negocioImp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	@Autowired
	private NegLibro iNegLibro;
	
	@Autowired
	private Biblioteca biblioteca;

	@Override
	public List<Biblioteca> listarBibliotecas(){
		return daoBiblioteca.listarBibliotecas();
	}

	@Override
	public List<Object[]> listarBibliotecasTabla(String fechaAlta, String estado, String isbn, String titulo) {
		int est = 0;
		if(estado.length() > 1) {
			if(estado.equals("Disponible"))
				est = 1;
			else
				est = 2;
		}
		int isbnAux = 0;
		if (isbn.length() > 0)
			isbnAux = Integer.parseInt(isbn);
		return daoBiblioteca.listarBibliotecasTabla(fechaAlta,est,isbnAux,titulo);
	}

	@Override
	public boolean agregarBiblioteca(int isbn, String fechaAlta) {
		try {
			biblioteca.setLibro(iNegLibro.obtenerLibro(isbn)); 
			biblioteca.setEstado(1);
			biblioteca.setFechaLanzamiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaAlta));
			return daoBiblioteca.agregarBiblioteca(biblioteca);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean modificarBiblioteca(int id, int estado, String fechaAlta){
		Biblioteca biblioteca = daoBiblioteca.obtenerBiblioteca(id);
		biblioteca.setId(id);
		biblioteca.setEstado(estado);
		try {
			biblioteca.setFechaLanzamiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaAlta));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return daoBiblioteca.modificarBiblioteca(biblioteca);
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
	public Biblioteca obtenerBiblioteca(int id) {
		return daoBiblioteca.obtenerBiblioteca(id);
	}


}
