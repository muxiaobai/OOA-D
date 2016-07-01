package Base;

import Service.SectionService;
import Service.StudentService;

public class ServiceFactory {
	public static StudentService getStudentServiceInstance(){
		return (StudentService) BaseClass.LoadXML().getBean("studentServiceImpl");
	}
	public static SectionService getSectionServiceInstance(){
		return (SectionService) BaseClass.LoadXML().getBean("sectionServiceImpl");
	}
}
