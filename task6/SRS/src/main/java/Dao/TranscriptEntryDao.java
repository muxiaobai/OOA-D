package Dao;

import java.util.List;

import Model.Section;
import Model.Student;
import Model.TranscriptEntry;

/** 
 * 
 * @author zhang
 * @Date  2016年6月21日 下午3:32:19
 * @doing 
 */

public interface TranscriptEntryDao extends BaseDao<TranscriptEntry>{
	public List<TranscriptEntry> findBySection(Section section);
	public List<TranscriptEntry> findByStudent(Student student);
}
