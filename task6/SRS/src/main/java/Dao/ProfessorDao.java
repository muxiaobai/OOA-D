package Dao;

import java.util.List;

import Model.Page;
import Model.Professor;

/** 
 * 
 * @author zhang
 * @Date  2016年6月21日 下午3:32:19
 * @doing 
 */

public interface ProfessorDao extends BaseDao<Professor>{
	public List<Professor> findByPage(Page page);
	public void deleteById(Integer professorId);
	
	
}
