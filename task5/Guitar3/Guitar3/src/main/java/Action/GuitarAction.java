package Action;

import java.util.List;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.opensymphony.xwork2.ActionContext;
import Model.Guitar;
import Model.Inventory;
import Model.Pager;
/**
 * 查询得到返回值
 * @author zhang
 * @date  2016年5月15日 下午7:59:06
 * @doing TODO
 */
public class GuitarAction extends SuperAction<Guitar> {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public String query() {
		System.out.println(ActionContext.getContext().getValueStack());
		System.out.println("===============================");
		System.out.println(ActionContext.getContext().getValueStack().getRoot());
		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(application);
		Inventory inventory=(Inventory)ctx.getBean("inventory");
		List<Guitar> sourceList =inventory.serarch(model);
		Pager<Guitar> result =new Pager<Guitar>(1, 15, sourceList);
		if(model!=null){
			request.setAttribute("query",model);
		}
		request.setAttribute("result", result);
		return "query";
	}
	public String delete() {
		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(application);
		Inventory inventory=(Inventory)ctx.getBean("inventory");
		inventory.delGuitar(model);
		List<Guitar> sourceList =inventory.getAllData();
		Pager<Guitar> result =new Pager<Guitar>(1, 15, sourceList);
		request.setAttribute("result", result);
		return "delete";
	}
	public String save()  {
		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(application);
		Inventory inventory=(Inventory)ctx.getBean("inventory");
		inventory.addGuitar(model);
		List<Guitar> sourceList =inventory.getAllData();
		Pager<Guitar> result =new Pager<Guitar>(1, 15, sourceList);
		request.setAttribute("result", result);
		return "save";
	}
}
