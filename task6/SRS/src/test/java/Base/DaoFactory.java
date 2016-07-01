package Base;

import Dao.CourseDao;
import Dao.ProfessorDao;
import Dao.SectionDao;
import Dao.StudentDao;

public class DaoFactory {
	public static StudentDao getStudentDaoInstance(){
		return (StudentDao) BaseClass.LoadXML().getBean("studentDaoImpl");
	}
	public static ProfessorDao getProfessorDaoInstance(){
		return (ProfessorDao) BaseClass.LoadXML().getBean("professorDaoImpl");
	}
	public static SectionDao getSectionDaoInstance(){
		return (SectionDao) BaseClass.LoadXML().getBean("sectionDaoImpl");
	}
	public static CourseDao getCourseDaoInstance(){
		return (CourseDao) BaseClass.LoadXML().getBean("courseDaoImpl");
	}
	
}
