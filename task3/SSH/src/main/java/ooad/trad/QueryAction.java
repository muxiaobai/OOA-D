package ooad.trad;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.opensymphony.xwork2.ActionContext;
/**
 * 查询得到返回值
 * @author zhang
 * @date  2016年5月15日 下午7:59:06
 * @doing TODO
 */
public class QueryAction extends BaseAction<Guitar> {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageNum() {
		return pageNum;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(ActionContext.getContext().getValueStack());
		System.out.println("===============================");
		System.out.println(ActionContext.getContext().getValueStack().getRoot());
		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(application);
		TableModelService userService=(TableModelService)ctx.getBean("tableModelServiceImpl");
		Map<String,Object> searchData=new HashMap<String, Object>();
		System.out.println("page："+getPageNum());
		searchData.put("pageNum",getPageNum()==null?1:getPageNum());
		setPageNum(1);
		searchData.put("pageSize",15); 
		searchData.put("searchModel", model);
		Pager<Object> result = userService.findData(searchData);
		request.setAttribute("result", result);
		return SUCCESS;
	}
}
