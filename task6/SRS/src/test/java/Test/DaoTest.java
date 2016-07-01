package Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Base.BaseClass;
import Enum.EnrollmentStatus;
import MergeUtil.MergeUtil;
import Model.Many;
import Model.One;

/** 
 * 
 * @author zhang
 * @Date  2016年6月4日 上午10:20:46
 * @doing 
 */

public class DaoTest {
	public static void main(String[] args) {
		Merge();
	}

	 public static void save(){
		SessionFactory sessionFactory=(SessionFactory) BaseClass.LoadXML().getBean("sessionFactory");
		 Session session=sessionFactory.getCurrentSession();
		Transaction transaction= session.beginTransaction();
//		System.out.println("==================save==========================");
		 One saveperson =new One();
		 saveperson.setId(4);
		 saveperson.setName("zqewqweqew1g");
		 saveperson.setStatus(EnrollmentStatus.prereq);
		 //saveperson.setPassword("zqweewqweqaa");
		 System.out.println("saveperson:"+saveperson);
		One tmp=session.get(One.class, 4);
		System.out.println("数据库中的tmp："+tmp);
		tmp=MergeUtil.mergeField(saveperson, tmp);
		System.out.println("修改过的tmp："+tmp);
	  // session.update(tmp);
		transaction.commit();
	}
	 public static void Merge(){
		 One save=new One();
		 save.setId(1);
//		 save.setName("zh1g");
//		 save.setPassword("zhangpa");
		// save.setDate(new Date());
		 
//			 Many manyone=new Many();
//			 manyone.setName("zxzsmanyone");
//			 save.setMany(manyone);
			 
//		 List<String> strings=new ArrayList<>();
//		 strings.add("zhang3");
//		 strings.add("zhan4");
//		 save.setStrings(strings);
		 
		 List<Many> manies=new ArrayList<>();
			 Many many1= new Many();
			 many1.setId(1);
			 many1.setName("many1");
			 many1.setPassword("many1");
			 manies.add(many1);
			 Many many2= new Many();
			 many2.setId(2);
			 many2.setName("many2");
			 many2.setPassword("many2");
			 manies.add(many2);
		save.setManies(manies);
		 System.out.println("===========前台的数据：===================");
		 System.out.println("save:"+save);
		 
		 
		 One tmp=new One();
		 tmp.setId(1);
//		 tmp.setName("zh1g");
//		 tmp.setPassword("zhangpa");
		 
//		 Many tmpmanyone=new Many();
//		 tmpmanyone.setName("zxzsmne");
//		 tmpmanyone.setPassword("asdasasd");
//		 tmp.setMany(tmpmanyone);
////		 
//		 List<String> tmpstrings=new ArrayList<>();
//		 tmpstrings.add("zhang3");
//		 tmpstrings.add("zhan2");
//		 tmp.setStrings(tmpstrings);
		 
		 List<Many> tmpmanies=new ArrayList<>();
		 Many tmpmany1= new Many();
		 tmpmany1.setId(1);
		 tmpmany1. setName("tmpmany1"); 
		 tmpmany1.setPassword("tmpmany1");
		 tmpmanies.add(tmpmany1);
		 Many tmpmany2= new Many();
		 tmpmany2.setId(2);
		 tmpmany2.setName("tmpmany2");
		 tmpmany2.setPassword("tmpmany2");
		 tmpmanies.add(tmpmany2);
		 Many tmpmany3= new Many();
		 tmpmany3.setId(3);
		 tmpmany3.setName("tmpmany3");
		 tmpmany3.setPassword("tmpmany3");
		 tmpmanies.add(tmpmany3);
		 tmp.setManies(tmpmanies);
		 
		 System.out.println("===========数据库的数据：===================");
		 System.out.println("tmp:"+tmp);
		 
		 
		 System.out.println("==========处理中的数据变化：===================");
		// tmp= (Person) save.merge(tmp);
		// MergeUtil.merge(save, tmp);
		 tmp= MergeUtil.mergeField(save, tmp);
		 System.out.println("==========处理后的数据：===================");
		 System.out.println("merge："+tmp);
	 }

}
