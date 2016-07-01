package Dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import Base.DaoFactory;
import Dao.StudentDao;
import Model.Course;
import Model.Professor;
import Model.Student;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:19:39
 * @doing 
 */

public class CourseDaoImplTest {
	private static CourseDao courseDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseDao=DaoFactory.getCourseDaoInstance();
	}
	@Test
	public void testSave() {
		Course c1, c2, c3, c4, c5;
		c1 = new Course("CMP101",
				"Beginning Computer Technology", 3.0);

		c2 = new Course("OBJ101", 
				"Object Methods for Software Development", 3.0);

		c3 = new Course("CMP283", 
				"Higher Level Languages (Java)", 3.0);

		c4 = new Course("CMP999",
				"Living Brain Computers", 3.0);

		c5 = new Course("ART101",
				"Beginning Basketweaving", 3.0);
		courseDao.save(c1);
		courseDao.save(c2);
		courseDao.save(c3);
		courseDao.save(c4);
		courseDao.save(c5);
		
		
	}

	@Test
	public void testFindById() {
		System.out.println(courseDao.findById(1));
	}

	@Test
	public void testFindAll() {
		System.out.println(courseDao.findAll());
	}

}
