package ServiceImpl;

import java.util.List;
import Dao.ProfessorDao;
import Model.Page;
import Model.Professor;
import Service.ProfessorService;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:11:44
 * @doing 
 */

public class ProfessorServiceImpl implements ProfessorService{
	private ProfessorDao professorDao;
	public void setProfessorDao(ProfessorDao professorDao) {
		this.professorDao = professorDao;
	}
	@Override
	public void saveProfessor(Professor professor) {
		professorDao.save(professor);
	}
	@Override
	public void deleteProfessor(Professor professor) {
		professorDao.delete(professor);
	}
	@Override
	public void deleteProfessor(Integer professorId) {
		professorDao.deleteById(professorId);
	}
	@Override
	public void updateProfessor(Professor professor) {
		professorDao.update(professor);
		
	}
	@Override
	public List<Professor> findAll() {
		return professorDao.findAll();
	}
	@Override
	public List<Professor> findByPage(Page page) {
		return professorDao.findByPage(page);
	}
	
}
