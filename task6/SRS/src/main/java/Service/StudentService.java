package Service;

import Enum.EnrollmentStatus;
import Model.Section;
import Model.Student;
import Model.Transcript;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:11:30
 * @doing 
 */

public interface StudentService {
	public Boolean login(Student student);
	public Student findBySsn(Student student);
	public EnrollmentStatus enroll(Section section,Student student);
	public Transcript findTranscript(Student student);
	
	
}
