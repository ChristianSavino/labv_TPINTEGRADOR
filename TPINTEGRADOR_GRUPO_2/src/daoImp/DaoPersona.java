package daoImp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.IdaoPersona;
import entidades.Persona;

@Repository("daoPersona")
public class DaoPersona implements IdaoPersona {
	
	@Autowired
	private Conexion conexion;
	
	@Override
	public List<Persona> listarPersonas() {
		//Session session = conexion.abrirConexion();
		
		//session.close();
		return null;
	}

	@Override
	public boolean agregarPersona(Persona p) {
		//Session session = conexion.abrirConexion();
		//Transaction tx= session.beginTransaction();
		boolean aux = true;
		try
		{
		//	session.save(p); 
		//	tx = session.getTransaction();
		//	tx.commit();
		}
		catch (Exception e) {
			aux=false;
		//	tx.rollback();
		}
		conexion.cerrarSession();
		return aux;
	}
}
