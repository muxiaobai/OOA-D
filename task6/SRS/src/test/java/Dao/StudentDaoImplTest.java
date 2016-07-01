package Dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Base.DaoFactory;
import Dao.StudentDao;
import Model.Student;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:19:39
 * @doing 
 */

public class StudentDaoImplTest {
	private static StudentDao studentDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentDao=DaoFactory.getStudentDaoInstance();
	}
	@Test
	public void testFindById() {
		System.out.println(studentDao.findById(13));
	}
	@Test
	public void testSave() {
		Student s1, s2, s3;
		s1 = new Student("Joe Blow", "111-11-1111", "Math", "M.S.");

		s2 = new Student("Fred Schnurd", "222-22-2222", 
				 "Information Technology", "Ph. D.");

		s3 = new Student("Mary Smith", "333-33-3333", "Physics", "B.S.");
		studentDao.save(s1);
		studentDao.save(s2);
		studentDao.save(s3);
	}

	@Test
	public void testFindAll() {
	System.out.println(studentDao.findAll());
	}

}
