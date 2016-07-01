package Service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import Base.DaoFactory;
import Base.ServiceFactory;
import Dao.CourseDao;
import Dao.ProfessorDao;
import Dao.SectionDao;
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

public class SectionServiceImplTest {
	private static SectionService sectionService;
	private static CourseDao courseDao;
	private static ProfessorDao professorDao;
	private static SectionDao sectionDao;
	private static StudentDao studentDao;
	private static StudentService studentService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sectionService=ServiceFactory.getSectionServiceInstance();
		courseDao=DaoFactory.getCourseDaoInstance();
		professorDao=DaoFactory.getProfessorDaoInstance();
		sectionDao=DaoFactory.getSectionDaoInstance();
		studentDao=DaoFactory.getStudentDaoInstance();
		studentService=ServiceFactory.getStudentServiceInstance();
	}
	@Test
	public void testSave() {
		Course c1, c2, c3, c4, c5;
		Professor p1, p2, p3;
		c1=courseDao.findById(7);
		c2=courseDao.findById(8);
		c3=courseDao.findById(9);
		c4=courseDao.findById(10);
		c5=courseDao.findById(11);
		p1=professorDao.findById(4);
		p2=professorDao.findById(5);
		p3=professorDao.findById(6);
		
		Section sec1, sec2, sec3, sec4, sec5, sec6, sec7;
		sec1 = c1.scheduleSection('M', "8:10 - 10:00 PM", "GOVT101", 30);

		sec2 = c1.scheduleSection('W', "6:10 - 8:00 PM", "GOVT202", 30);

		sec3 = c2.scheduleSection('R', "4:10 - 6:00 PM", "GOVT105", 25);

		sec4 = c2.scheduleSection('T', "6:10 - 8:00 PM", "SCI330", 25);

		sec5 = c3.scheduleSection('M', "6:10 - 8:00 PM", "GOVT101", 20);

		sec6 = c4.scheduleSection('R', "4:10 - 6:00 PM", "SCI241", 15);
		
		sec7 = c5.scheduleSection('M', "4:10 - 6:00 PM", "ARTS25", 40);
		
		p3.agreeToTeach(sec1);
		p2.agreeToTeach(sec2);
		p1.agreeToTeach(sec3);
		p3.agreeToTeach(sec4);
		p1.agreeToTeach(sec5);
		p2.agreeToTeach(sec6);
		p3.agreeToTeach(sec7);

		sectionService.saveSection(sec1);
		sectionService.saveSection(sec2);
		sectionService.saveSection(sec3);
		sectionService.saveSection(sec4);
		sectionService.saveSection(sec5);
		sectionService.saveSection(sec6);
		sectionService.saveSection(sec7);
		
	}

	@Test
	public void testFindById() {
		System.out.println(sectionDao.findById(25));
	}

	@Test
	public void testFindAll() {
		System.out.println(sectionDao.findAll());
	}
	@Test
	public void testEnroll() {
		Student student=new Student();
		student.setId(3);
		Section section=new Section();
		section.setId(12);
//		Section section=sectionDao.findById(12);
//		Student student=studentDao.findById(1);
		studentService.enroll(section, student);
		
	}

}
