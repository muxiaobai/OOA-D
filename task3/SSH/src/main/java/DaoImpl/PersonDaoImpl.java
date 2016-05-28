package DaoImpl;

import Dao.PersonDao;
import Model.Person;

/**
 * Person的实现类 extends BaseDaoImpl<Person> implements PersonDao,
 * 该实现类既包含Base方法又包含Person方法
 * @author zhang
 * @date 2016年5月21日 下午7:13:02
 * @doing Person特有的方法，对Service层提供支持
 */
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {
	/**
	 * 子类实例化的时候会调用父类的构造方法
	 */
	public PersonDaoImpl() {
		super();
	}
}