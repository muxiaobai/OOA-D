package ooad.ooad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
		Inventory inventory=(Inventory)ctx.getBean("inventory");
		List<Guitar> sourceList =inventory.serarch(model);
		Pager<Guitar> result =new Pager<Guitar>(1, 15, sourceList);
		request.setAttribute("query",model);
		request.setAttribute("result", result);
		return SUCCESS;
	}
}
