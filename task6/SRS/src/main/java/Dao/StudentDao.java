package Dao;

import Model.Student;

/** 
 * 
 * @author zhang
 * @Date  2016年6月21日 下午3:32:19
 * @doing 
 */

public interface StudentDao extends BaseDao<Student>{
	public Student findBySsn(Student student);
	
}
