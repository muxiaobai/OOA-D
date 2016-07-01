package Service;

import java.util.List;

import Model.Section;
import Model.Student;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:11:30
 * @doing 
 */

public interface SectionService {

	public void saveSection(Section section);
	public void deleteSection(Section section);
	public void deleteSection(Integer  sectionId);
	public void updateSection(Section section);
	public List<Section> findAll();
	public List<Section> findOldSection();
	public List<Student> findStudent(Section section);
	public void dropStudent(Section section,Student student);
	
}
