package web.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class Conexion {
	private SessionFactory sessionFactory;
	private Session session;
	ServiceRegistry serviceRegistry;
	Configuration configuration;

	public Conexion() {
		configuration = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void abrirConexion()	{
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session=sessionFactory.openSession();
	}

	public void cerrarSession()	{
		session.close();
		sessionFactory.close();
	}	

	public void cerrarSessionFactory()	{
		sessionFactory.close();
	}

	public void GuardarObjeto(Object object) throws HibernateException {
		session.save(object);
	}

	public Object ObtenerObjeto(Class<?> clase,int id) {
		return session.get(clase, id);
	}

	public List<Object[]> ObtenerListaPorQuery(String query){
	 	   List<Object[]> list = (List<Object[]>)session.createSQLQuery(query).list();
	 	   return list;
	}
	
	public Object obtenerDatoUnicoPorQuery(String query) {
		Object object = (Object)session.createSQLQuery(query).uniqueResult();
		return object;
	}
	
	public void ActualizarObjeto(Object object) {
		session.update(object);
	}

	public void BorrarObjeto(Object object) {
		session.delete(object);
	}

	public void IniciarTransaccion() {
		session.beginTransaction();
	}

	public void RollbackearTransaccion() {
		session.getTransaction().rollback();
	}

	public void CommitTransaccion() {
		session.getTransaction().commit();
	}

	public boolean isTranssacionActiva(){
		if (session.getTransaction() != null) {
			return session.getTransaction().isActive();
		}

		return false;
	}


	public boolean isConexionActiva() {
		if(session != null)
			return session.isOpen();

		return false;
	}
}
