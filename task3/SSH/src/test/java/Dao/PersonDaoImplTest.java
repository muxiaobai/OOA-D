package Dao;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import Base.BaseClass;
import Model.Person;

public class PersonDaoImplTest {
	public static PersonDao getPersonDaoInstance(){
		return	(PersonDao) BaseClass.LoadXML().getBean("personDaoImpl");
	}
	@Test
	public void testSave(){
		Person person =new Person();
		person.setDate(new Date());
		person.setName("test");
		person.setPassword("password");
		PersonDaoImplTest.getPersonDaoInstance().save(person);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByHqlString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByHqlStringObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBySqlString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBySqlStringObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPageStringIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPageStringIntIntObjectArray() {
		fail("Not yet implemented");
	}

}
