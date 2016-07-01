package Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Course;
import Model.Page;
import Model.Professor;
import Model.Section;
import Model.Student;
import Service.CourseService;
import Service.SectionService;
import Service.StudentService;

/**
 * 查询得到返回值
 * @author zhang
 * @date  2016年5月15日 下午7:59:06
 * @doing TODO
 */
public class CourseAction extends BaseAction<Course> {
	private static final long serialVersionUID = 1L;
	private CourseService courseService; 	
	private String ids;
	private Map<String, Object> jsonMap=new HashMap<>();
	private List<Course> courses=new ArrayList<>();
	
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getIds() {
		return ids;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Course> getCourses() {
		return courses;
	}
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	public String  query(){
		courses=courseService.findAll();
		System.out.println(pageData);
		jsonMap.put("rows", courses);
		jsonMap.put("total",courses);
		return "query";
	}
	public String  queryList(){
		courses=courseService.findAll();
		return "queryList";
	}

}