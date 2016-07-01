package Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.TranscriptEntry;
import Service.TranscriptEntryService;

/** 
 * 
 * @author zhang
 * @Date  2016年6月29日 下午7:53:43
 * @doing 
 */

public class TranscriptEntryAction extends BaseAction<TranscriptEntry>{
	private TranscriptEntryService transcriptEntryService;
	private Map<String, Object> jsonMap=new HashMap<>();
	public void setTranscriptEntryService(TranscriptEntryService transcriptEntryService) {
		this.transcriptEntryService = transcriptEntryService;
	}
	public TranscriptEntryService getTranscriptEntryService() {
		return transcriptEntryService;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
}
