package DaoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import Dao.BaseDao;

/**
 * BaseDaoImpl:基类实现类,implements BaseDao
 * 
 * @author zhang
 * @date 2016年5月21日 下午7:03:54
 * @doing 基本的方法实现CRUD
 * @param <T>Model泛型
 */
@SuppressWarnings({ "unchecked", "rawtypes" ,"unused"})
public class BaseDaoImpl<T> implements BaseDao<T> {
	// DAO组件进行持久化操作底层依赖的SessionFactory组件
	protected SessionFactory sessionFactory;
	private Class clazz;
	private String hql;
	public BaseDaoImpl() {
		// 获取子类对象
		// System.out.println(this);
		// 获取子类类信息
		// System.out.println(this.getClass());
		// 获取子类的直接父类,如果父类有参数类型可以同时获取到父类的参数类型
		// System.out.println(this.getClass().getGenericSuperclass());
		// 获取参数类型的参数,返回参数类型的数组
		// System.out.println(((ParameterizedType)
		// this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		// 把参数类型转化为具体的Class类型
		this.clazz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.hql = "from " + this.clazz.getName();
	}

	/**
	 * 依赖注入SessionFactory所需的setter方法
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
	}

	/**
	 * 取得Session.
	 * 
	 * @return CurrentSession
	 */
	public Session getSession() {
		try {
		  return this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		   return sessionFactory.openSession();
		}
		//return this.sessionFactory.getCurrentSession();
	}
	public void flush(){
		this.getSession().flush();
	}
	public void clear(){
		this.getSession().clear();
	}
	
	@Override
	public Serializable save(T entity) {
		// Transaction transaction=this.getSession().beginTransaction();
		return this.getSession().save(entity);
		// transaction.commit();
	}

	@Override
	public void delete(Integer id) {
		this.getSession().delete(id);
	}

	@Override
	public void update(T entity) {
		this.getSession().update(entity);
	}

	@Override
	public T findById(Integer id) {
		return (T) this.getSession().get(clazz, id);
	}

	@Override
	public List<T> findAll() {
		List<T> result = this.getSession().createQuery("FROM " + clazz.getName()).list();
		return result;
	}
	/**
	 * 获取实体总数
	 * @param entityClazz
	 * @return long 该表中的数量
	 */
	@Override
	public long findCount(Class<T> entityClazz) {
		List<?> l = findByHql("select count(*) from " + entityClazz.getSimpleName());
		// 返回查询得到的实体总数
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}
	/**
	 * 根据HQL语句查询实体(不带参数)
	 * 
	 * @param hql语句
	 * @return List集合包括要显示的数据
	 */
	@Override
	public List<T> findByHql(String hql) {
		return (List<T>) this.getSession().createQuery(hql).list();
	}

	/**
	 * 根据带占位符参数HQL语句查询实体(带参数的)
	 * 
	 * @param hql
	 * @param params
	 * @return List集合包括要显示的数据
	 */
	@Override
	public List<T> findByHql(String hql, Object... params) {
		// 创建查询
		Query query = this.getSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.list();
	}
	/**
	 * 根据SQL语句查询实体(不带参数)
	 * 
	 * @param sql语句
	 * @return List集合包括要显示的数据
	 */
	@Override
	public List<T> findBySql(String sql) {
		return (List<T>) this.getSession().createSQLQuery(sql).list();
	}

	/**
	 * 根据带占位符参数SQL语句查询实体(带参数的)
	 * 
	 * @param sql
	 * @param params
	 * @return List集合包括要显示的数据
	 */
	@Override
	public List<T> findBySql(String sql, Object... params) {
		// 创建查询
		Query query = this.getSession().createSQLQuery(sql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.list();
	}
	/**
	 * 根据HQL语句分页查询实体(不带参数)
	 * @param hql
	 * @param pageNo当前第几页数据
	 * @param pageSize每页显示多少条记录
	 * @return List集合包括要显示的数据
	 */
	public List<T> findByPage(String hql, int pageNo, int pageSize) {
		return this.getSession().createQuery(hql).setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}
	/**
	 * 根据带占位符参数HQL语句分页查询实体(带参数的)
	 * @param hql
	 * @param pageNo当前第几页数据
	 * @param pageSize每页显示多少条记录
	 * @return List集合包括要显示的数据
	 */
	@Override
	public List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		Query query = this.getSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
}
