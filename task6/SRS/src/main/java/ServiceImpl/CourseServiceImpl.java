package ServiceImpl;

import java.util.List;

import Dao.CourseDao;
import Model.Course;
import Service.CourseService;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午9:11:44
 * @doing 
 */

public class CourseServiceImpl implements CourseService{
	private CourseDao courseDao;
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}
	
}
