package Dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import Base.DaoFactory;
import Dao.StudentDao;
import Model.Course;
import Model.Professor;
import Model.Section;
import Model.Student;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:19:39
 * @doing 
 */

public class SectionDaoImplTest {
	private static SectionDao sectionDao;
	private static 	CourseDao courseDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sectionDao=DaoFactory.getSectionDaoInstance();
		courseDao=DaoFactory.getCourseDaoInstance();
	}
	@Test
	public void testSave() {
		
	}

	@Test
	public void testFindById() {
		System.out.println(sectionDao.findById(16));
	}

	@Test
	public void testFindAll() {
		System.out.println(sectionDao.findAll());
	}

}
