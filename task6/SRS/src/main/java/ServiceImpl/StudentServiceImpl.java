package ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Dao.SectionDao;
import Dao.StudentDao;
import Dao.TranscriptEntryDao;
import Enum.EnrollmentStatus;
import Model.Section;
import Model.Student;
import Model.Transcript;
import Model.TranscriptEntry;
import Service.StudentService;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:11:44
 * @doing 
 */

public class StudentServiceImpl implements StudentService{
	private StudentDao studentDao;
	private SectionDao sectionDao;
	private TranscriptEntryDao transcriptEntryDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public void setSectionDao(SectionDao sectionDao) {
		this.sectionDao = sectionDao;
	}
	public void setTranscriptEntryDao(TranscriptEntryDao transcriptEntryDao) {
		this.transcriptEntryDao = transcriptEntryDao;
	}
	@Override
	public Boolean login(Student student) {
		return studentDao.findBySsn(student).getPassword().equals(student.getPassword());
	}
	@Override
	public Student findBySsn(Student student) {
		return studentDao.findBySsn(student);
	}
	@Override
	public EnrollmentStatus enroll(Section section,Student student) {
		Transcript transcript =new Transcript();
		transcript.setTranscriptEntries(transcriptEntryDao.findBySection(section));
		student=studentDao.findById(student.getId());
		section=sectionDao.findById(section.getId());
		List<Student> students=new ArrayList<>();
		List<TranscriptEntry> transcriptEntries=transcriptEntryDao.findBySection(section);
		Map<String, Student> enrollStudents=new HashMap<>();
		for (Iterator iterator = transcriptEntries.iterator(); iterator.hasNext();) {
			TranscriptEntry transcriptEntry = (TranscriptEntry) iterator.next();
			students.add(transcriptEntry.getStudent());
		}
		for (Iterator iterator = students.iterator(); iterator.hasNext();) {
			Student student2 = (Student) iterator.next();
			enrollStudents.put(student2.getSsn(),student2);
		}
		
		section.setEnrolledStudents(enrollStudents);
	//	section.setTranscriptEntries(transcriptEntryDao.findBySection(section));
		EnrollmentStatus enrollmentStatus=section.enroll(student);
//		EnrollmentStatus enrollmentStatus=EnrollmentStatus.success;
	//	student.addSection(section);
		if(enrollmentStatus.equals(EnrollmentStatus.success)){
			TranscriptEntry transcriptEntry=new TranscriptEntry();
			transcriptEntry.setStudent(student);
			transcriptEntry.setSection(section);
			transcriptEntryDao.save(transcriptEntry);
		}
		return enrollmentStatus;
	}
	
	@Override
	public Transcript findTranscript(Student student) {
		return student.getTranscript();
	}
	
}
