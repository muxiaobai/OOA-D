package DaoImpl;

import java.util.List;

import Dao.ProfessorDao;
import Model.Page;
import Model.Professor;

/** 
 * 
 * @author zhang
 * @Date  2016年6月21日 下午3:33:11
 * @doing 
 */

public class ProfessorDaoImpl extends BaseDaoImpl<Professor> implements ProfessorDao{

	@Override
	public List<Professor> findByPage(Page page) {
		return findByPage(" from Professor ", page.getPage(), page.getRows());
	}

	@Override
	public void deleteById(Integer professorId) {
		delete(findById(professorId));
	}
	
	
}
