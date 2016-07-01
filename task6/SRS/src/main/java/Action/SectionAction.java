package Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Page;
import Model.Section;
import Model.Student;
import Model.TranscriptEntry;
import Service.SectionService;
import Service.StudentService;
import Service.TranscriptEntryService;

/**
 * 查询得到返回值
 * @author zhang
 * @date  2016年5月15日 下午7:59:06
 * @doing TODO
 */
public class SectionAction extends BaseAction<Section> {
	private static final long serialVersionUID = 1L;
	private SectionService sectionService;
	private TranscriptEntryService transcriptEntryService;
	private String ids;
	private Map<String, Object> jsonMap=new HashMap<>();
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}
	public void setTranscriptEntryService(TranscriptEntryService transcriptEntryService) {
		this.transcriptEntryService = transcriptEntryService;
	}
	public SectionService getSectionService() {
		return sectionService;
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
	private void init() {
		pageData=new Page(page, rows);
	}
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	public String  query(){
		List<Section> sections = sectionService.findAll();
		System.out.println(pageData);
		jsonMap.put("rows", sections);
		jsonMap.put("total",sections.size());
		return "query";
	}
	public String  oldSection(){
		List<Section> sections = sectionService.findAll();
		System.out.println("============================="+sections);
		jsonMap.put("rows", sections);
		jsonMap.put("total",sections.size());
		System.out.println("=============================================="+sections);    
		System.out.println("page:" + page + ",rows:" + rows);
		return "oldSection";
	}
	public String  delete(){
		System.out.println(ids);
		for (int i = 0; i < ids.split(",").length; i++) {
			sectionService.deleteSection(Integer.parseInt(ids.split(",")[i]));
		}
		jsonMap.put("message",true);
		return "delete";
	}
	public String  save(){
		sectionService.saveSection(model);
		System.out.println(model);
		jsonMap.put("message",true);
		return "delete";
	}
	public String  update(){
		sectionService.updateSection(model);
		System.out.println(model);
		jsonMap.put("mamege",true);
		return "update";
	}
	public String  studentTranscript(){
		List<TranscriptEntry> transcriptEntries =transcriptEntryService.findBySection(model);
		System.out.println(model);
		jsonMap.put("rows", transcriptEntries);
		jsonMap.put("total",transcriptEntries.size());
		return "studentTranscript";
	}
	
}