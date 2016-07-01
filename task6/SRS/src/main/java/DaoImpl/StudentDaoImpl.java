package DaoImpl;

import Dao.StudentDao;
import Model.Student;

/** 
 * 
 * @author zhang
 * @Date  2016年6月21日 下午3:33:11
 * @doing 
 */

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{

	@Override
	public Student findBySsn(Student student) {
		return findByHql(" from Student  where ssn like '"+student.getSsn()+"'").get(0);
	}

}
