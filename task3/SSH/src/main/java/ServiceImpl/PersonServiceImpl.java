package ServiceImpl;

import Dao.PersonDao;
import Model.Person;
import Service.PersonService;
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
	private PersonDao personDao;
	/**
	 * 子类实例化的时候会调用父类的构造方法
	 */
	public PersonServiceImpl() {
		super();
		System.out.println("==clazz：PersonServiceImpl执行父类构造方法==");
	}
	/**
	 * 注入personDao对象
	 * @param personDao,一般使用personDao的Impl类对象
	 */
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
		System.out.println("===注入personDao========");
	}

	@Override
	public void tran() {
		//personDao.save(new Person());
		Person person =personDao.findById(1);
		//person.setName("tran");
		//personDao.save(person);
		System.out.println(personDao.findById(2));
		// int a=1/0;
		System.out.println(personDao.findAll());
	}
}
