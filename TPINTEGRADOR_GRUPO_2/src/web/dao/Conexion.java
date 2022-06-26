package web.dao;

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

	public Conexion() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void abrirConexion()	{
		session=sessionFactory.openSession();
	}

	public void cerrarSession()	{
		session.close();
	}	

	public void cerrarSessionFactory()	{
		sessionFactory.close();
	}

	public void GuardarObjeto(Object object) {
		session.save(object);
	}

	public Object ObtenerObjeto(Class<?> clase,int id) {
		return session.get(clase, id);
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
