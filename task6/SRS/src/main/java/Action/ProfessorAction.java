package Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Professor;
import Service.ProfessorService;

/**
 * 查询得到返回值
 * @author zhang
 * @date  2016年5月15日 下午7:59:06
 * @doing TODO
 */
public class ProfessorAction extends BaseAction<Professor> {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> jsonMap=new HashMap<>();
	private List<Professor> professors=new ArrayList<>();
	
	private ProfessorService professorService;
	 private String ids;
	public void setProfessorService(ProfessorService professorService) {
		this.professorService = professorService;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getIds() {
		return ids;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	public List<Professor> getProfessors() {
		return professors;
	}
	public String  query(){
		List<Professor> professors=professorService.findAll();
		jsonMap.put("rows", professors);
		jsonMap.put("total",professors.size());
		return "query";
	}
	public String  queryList(){
		//List<Professor> professors=professorService.findAll();
		professors.addAll(professorService.findAll());
		//jsonMap.put("rows", professors);
		return "queryList";
	}
	public String  delete(){
		System.out.println(ids);
		for (int i = 0; i < ids.split(",").length; i++) {
			professorService.deleteProfessor(Integer.parseInt(ids.split(",")[i]));
		}
		jsonMap.put("message",true);
		return "delete";
	}
	public String  save(){
		professorService.saveProfessor(model);
		jsonMap.put("message",true);
		return "save";
	}
	public String  update(){
		professorService.updateProfessor(model);
		jsonMap.put("message",true);
		return "update";
	}
}