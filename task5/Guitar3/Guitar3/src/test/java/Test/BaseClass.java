package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseClass {
	public static ApplicationContext LoadXML(){
		//ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext-hibernate.xml", "applicationContext-struts2.xml","applicationContext.xml", "applicationContext-prop.xml" });
		return new ClassPathXmlApplicationContext(new String[] { "applicationContext-hibernate.xml", "applicationContext-struts2.xml","applicationContext.xml", "applicationContext-prop.xml" });
	}
	
}
