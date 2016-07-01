package Action;

import java.lang.reflect.ParameterizedType;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Model.Page;

//所有Action的父类
public class BaseAction<T> extends ActionSupport
		implements ApplicationContextAware,ServletRequestAware, ServletResponseAware, ServletContextAware,ModelDriven<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;// 请求对象
	protected HttpServletResponse response;// 响应对象
	protected HttpSession session;// 会话对象
	protected ServletContext application;// 全局对象
	protected ApplicationContext ctx;
	protected T model = null;
	protected Page pageData;
	protected Integer page;
	protected Integer rows;
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public Integer getPage() {
		return page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = this.request.getSession();
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx=applicationContext;
		//System.out.println(ActionContext.getContext().getValueStack());
		//System.out.println("===============================");
		//System.out.println(ActionContext.getContext().getValueStack().getRoot());
	}
	// 在拦截器执行此方法的时候Action的构造方法已经创建,所以Model中有值
	public T getModel() {
		return model;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
			System.out.println(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
