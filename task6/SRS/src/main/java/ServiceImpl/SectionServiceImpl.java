package ServiceImpl;

import java.util.List;

import Dao.SectionDao;
import Dao.TranscriptEntryDao;
import Model.Section;
import Model.Student;
import Model.TranscriptEntry;
import Service.SectionService;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:11:44
 * @doing 
 */

public class SectionServiceImpl implements SectionService{
	private SectionDao sectionDao;
	private TranscriptEntryDao transcriptEntryDao;
	public void setSectionDao(SectionDao sectionDao) {
		this.sectionDao = sectionDao;
	}
	public void setTranscriptEntryDao(TranscriptEntryDao transcriptEntryDao) {
		this.transcriptEntryDao = transcriptEntryDao;
	}
	@Override
	public List<Section> findAll() {
		return sectionDao.findAll();
	}
	@Override
	public void saveSection(Section section) {
		sectionDao.save(section);
	}
	@Override
	public void deleteSection(Section section) {
		sectionDao.delete(section);
	}
	@Override
	public void deleteSection(Integer professorId) {
		sectionDao.deleteById(professorId);
	}
	@Override
	public void updateSection(Section section) {
		sectionDao.update(section);
	}
	@Override
	public void dropStudent(Section section,Student student) {
		section.drop(student);
	//	transcriptEntryDao.delete();
	}
	@Override
	public List<Student> findStudent(Section section) {
		
		////return (List<Student>) section.getTranscriptEntries();
	
		return null;
	}
	@Override
	public List<Section> findOldSection() {
		return null;
	}
}
