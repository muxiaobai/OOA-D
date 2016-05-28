package Action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 用来请求转发的Action
 * @author zhang
 *
 */
public class SendAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
