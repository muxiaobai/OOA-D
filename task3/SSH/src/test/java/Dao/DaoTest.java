package Dao;

import java.util.List;

import Model.Person;

public class DaoTest {
	public static void main(String[] args) {
		PersonDao personDao = PersonDaoImplTest.getPersonDaoInstance();
		List<Person> result=personDao.findBySql("select * from person ");
		List<Person> result2=personDao.findByHql(" from Person ");
		System.out.println(result);
		for (int i = 0; i < result2.size(); i++) {
			System.out.print(result2.get(i).getId());
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i).getId());
		}
	}
}
