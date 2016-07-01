package ServiceImpl;

import java.util.List;

import Dao.SectionDao;
import Dao.StudentDao;
import Dao.TranscriptEntryDao;
import Model.Section;
import Model.Student;
import Model.TranscriptEntry;
import Service.TranscriptEntryService;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:11:44
 * @doing 
 */

public class TranscriptEntryServiceImpl implements TranscriptEntryService{
	private TranscriptEntryDao transcriptEntryDao;
	private SectionDao sectionDao;
	private StudentDao studentDao;
	public void setSectionDao(SectionDao sectionDao) {
		this.sectionDao = sectionDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public void setTranscriptEntryDao(TranscriptEntryDao transcriptEntryDao) {
		this.transcriptEntryDao = transcriptEntryDao;
	}
	@Override
	public List<TranscriptEntry> findByStudent(Student student) {
		return transcriptEntryDao.findByStudent(student);  
	}
	@Override
	public List<TranscriptEntry> findBySection(Section section) {
		return transcriptEntryDao.findBySection(section);
	}
	@Override
	public void deleteSection(TranscriptEntry transcriptEntry) {
		transcriptEntryDao.delete(transcriptEntry);
	}
	@Override
	public void deleteSection(Integer transcriptEntryId) {
		transcriptEntryDao.delete(transcriptEntryId);
		
	}
	
}
