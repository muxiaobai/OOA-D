package BaseDaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Dao.IGuitarDao;
import Model.Guitar;

/** 
 * 
 * @author zhang
 * @Date  2016年6月3日 下午8:11:15
 * @doing 
 */

public class GuitarDaoImpl implements IGuitarDao {
	protected SessionFactory sessionFactory;
	private Session session;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		session=sessionFactory.openSession();
	}
	public Session getSession() {
		return session;
	}
	@Override
	public void save(Guitar guitar) {
		session.beginTransaction();
		session.save(guitar);
		session.getTransaction().commit();
		
	}

	@Override
	public void delete(Integer id) {
		session.beginTransaction();
		Guitar entity=(Guitar)this.getSession().get(Guitar.class, id);
		if(entity!=null){
			this.getSession().delete(entity);
		}
		session.getTransaction().commit();
	}

	@Override
	public List<Guitar> findAll() {
		List<Guitar> results=new ArrayList<Guitar>();
		try {
			session.beginTransaction();
			results= session.createQuery("FROM Guitar").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return results;
	
	}

}
