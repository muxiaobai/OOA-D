package Interceptor;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class FirstInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		System.out.println("====进入FirstInterceptor==========:"+new Date()+System.currentTimeMillis());
		System.out.println("Action:"+invocation.getAction());
		ActionContext ctx=invocation.getInvocationContext();
		System.out.println("Root:"+invocation.getStack().getRoot());
		String result=invocation.invoke();
		long end =System.currentTimeMillis();
		System.out.println("====执行完FirstInterceptor=========:"+new Date()+System.currentTimeMillis());
		System.out.println("====执行Action时间=============:"+(end-start)+"ms");
		return result;
	}
	
}
