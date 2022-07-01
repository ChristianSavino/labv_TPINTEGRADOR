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
	public List<Object[]> listarBibliotecasTabla(String fechaAlta,String estado,String isbn) {
		String newFecha = "";
		if (fechaAlta.length() > 0) {
			String[] datos = fechaAlta.split("/");
			newFecha = datos[2] + "-" +datos[1] + "-" + datos[0];
		}

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
		return daoBiblioteca.listarBibliotecasTabla(newFecha,est,isbnAux);
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
