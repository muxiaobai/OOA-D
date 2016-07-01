package Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enum.EnrollmentStatus;
import Model.Section;
import Model.Student;
import Model.Transcript;
import Model.TranscriptEntry;
import Service.StudentService;
import Service.TranscriptEntryService;

/**
 * 查询得到返回值
 * @author zhang
 * @date  2016年5月15日 下午7:59:06
 * @doing TODO
 */
public class StudentAction extends BaseAction<Student> {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	private TranscriptEntryService transcriptEntryService;
	private Map<String, Object> jsonMap=new HashMap<>();
	private Integer sectionId;
	private String ids;
	public void setTranscriptEntryService(TranscriptEntryService transcriptEntryService) {
		this.transcriptEntryService = transcriptEntryService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	public Integer getSectionId() {
		return sectionId;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getIds() {
		return ids;
	}
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	public String  login(){
		Boolean value=studentService.login(model);
		System.out.println(value);
		if(value){
			session.setAttribute("student", studentService.findBySsn(model));
		}
		System.out.println(session.getAttribute("student"));
	//	jsonMap.put("massage", value);
		return "login";
	}
	public String enroll() {
		System.out.println("session================="+(Student) session.getAttribute("student"));
		Student student =(Student) session.getAttribute("student");
//		Student student=new Student();
//		student.setId(1);
		Section section=new Section();
		section.setId(sectionId);
//		System.out.println(sectionId);
		EnrollmentStatus enrollmentStatus=studentService.enroll(section, student);
		System.out.println("===================enrollmentStatus:"+enrollmentStatus);
		jsonMap.put("message",enrollmentStatus);
		return "enroll";
	}
	public String queryTranscript() {
		//Transcript transcript=transcriptEntryService.findByStudent(model);
		Student student=new Student();
		student.setId(1);
		List<TranscriptEntry> transcriptEntries=transcriptEntryService.findByStudent(student);
//		System.out.println("=============transcript=======");
//		System.out.println(transcriptEntries);
		jsonMap.put("rows", transcriptEntries);
		jsonMap.put("total",transcriptEntries.size());
		return "queryTranscript";
	}
	public String deleteTranscript() {
//		System.out.println(ids);
		for (int i = 0; i < ids.split(",").length; i++) {
			transcriptEntryService.deleteSection(Integer.parseInt(ids.split(",")[i]));
		}
		jsonMap.put("message",true);
		return "queryTranscript";
	}
}