package Dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import Base.DaoFactory;
import Dao.StudentDao;
import Model.Professor;
import Model.Student;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:19:39
 * @doing 
 */

public class ProfessorDaoImplTest {
	private static ProfessorDao professorDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		professorDao=DaoFactory.getProfessorDaoInstance();
	}
	@Test
	public void testSave() {
		Professor p1, p2, p3;
		p1 = new Professor("Jacquie Barker", "123-45-6789", 
				   "Adjunct Professor", "Information Technology");		

		p2 = new Professor("John Smith", "567-81-2345",
				   "Full Professor", "Chemistry");		

		p3 = new Professor("Snidely Whiplash", "987-65-4321",
				   "Full Professor", "Physical Education");		
		professorDao.save(p1);
		professorDao.save(p2);
		professorDao.save(p3);
		
	}

	@Test
	public void testFindById() {
		System.out.println(professorDao.findById(16));
	}

	@Test
	public void testFindAll() {
		System.out.println(professorDao.findAll());
	}

}
