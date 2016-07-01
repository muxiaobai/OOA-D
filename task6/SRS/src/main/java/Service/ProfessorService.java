package Service;

import java.util.List;

import Model.Page;
import Model.Professor;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:11:30
 * @doing 
 */

public interface ProfessorService {
	public List<Professor> findAll();
	public List<Professor> findByPage(Page page);
	public void saveProfessor(Professor professor);
	public void deleteProfessor(Professor  professor);
	public void deleteProfessor(Integer  professorId);
	public void updateProfessor(Professor professor);
	
	
}
