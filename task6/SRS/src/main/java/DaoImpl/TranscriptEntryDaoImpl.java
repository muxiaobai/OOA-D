package DaoImpl;

import java.util.List;

import Dao.TranscriptEntryDao;
import Model.Section;
import Model.Student;
import Model.TranscriptEntry;

/** 
 * 
 * @author zhang
 * @Date  2016年6月21日 下午3:33:11
 * @doing 
 */

public class TranscriptEntryDaoImpl extends BaseDaoImpl<TranscriptEntry> implements TranscriptEntryDao{

	@Override
	public List<TranscriptEntry> findBySection(Section section) {
		return findByHql(" from  TranscriptEntry where section_id="+section.getId());
	}

	@Override
	public List<TranscriptEntry> findByStudent(Student student) {
		return findByHql(" from  TranscriptEntry where student_id= "+student.getId());
	}

}
