package Service;

import java.util.List;

import Model.Section;
import Model.Student;
import Model.TranscriptEntry;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:11:30
 * @doing 
 */

public interface TranscriptEntryService {
		public List<TranscriptEntry> findByStudent(Student student);
		public List<TranscriptEntry> findBySection(Section section);
		public void deleteSection(TranscriptEntry transcriptEntry) ;
		public void deleteSection(Integer transcriptEntryId) ;
}	
