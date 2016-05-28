package Action;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.opensymphony.xwork2.ActionContext;
import Dao.PersonDao;
import Model.Person;

public class LoginAction extends SuperAction<Person> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println(ActionContext.getContext().getValueStack());
		System.out.println("===============================");
		System.out.println(ActionContext.getContext().getValueStack().getRoot());
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
		PersonDao personDaoImpl = (PersonDao) ctx.getBean("personDaoImpl");
		personDaoImpl.findAll();
		// personDaoImpl.save(model);
		return SUCCESS;
	}
}
