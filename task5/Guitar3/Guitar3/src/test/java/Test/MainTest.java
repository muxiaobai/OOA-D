package Test;

import java.util.HashMap;
import java.util.Map;

import Model.Guitar;
import Model.Inventory;

/** 
 * 
 * @author zhang
 * @Date  2016年6月3日 下午5:56:41
 * @doing 
 */

public class MainTest {

	public static void main(String[] args) {
		Inventory inventory=new Inventory();
		System.out.println("初始化："+inventory.getAllData());
		Map<String, String> guitarSpec3Map=new HashMap<String, String>();
		guitarSpec3Map.put("backwood", "木头3");
		guitarSpec3Map.put("topwood",  "塑料3");
		guitarSpec3Map.put("type",  "铁3");
		guitarSpec3Map.put("builder",  "zhang3");
		guitarSpec3Map.put("guitarmodel",  "modelzhang3");
		Guitar guitar3=new Guitar(3,2.3D,guitarSpec3Map);
		inventory.addGuitar(guitar3);
		System.out.println("addGuitar后:"+inventory.getAllData());
		Map<String, String> guitarSpec4Map=new HashMap<String, String>();
		guitarSpec4Map.put("backwood", "木头4");
		guitarSpec4Map.put("topwood",  "塑料4");
		guitarSpec4Map.put("type",  "铁4");
		guitarSpec4Map.put("builder",  "zhang4");
		guitarSpec4Map.put("guitarmodel",  "modelzhang3");
		Guitar guitar4=new Guitar(4,23.3D,guitarSpec4Map);
		inventory.addGuitar(guitar4);
		Map<String, String> searchMap=new HashMap<String, String>();
		searchMap.put("guitarmodel",  "modelzhang3");
		Guitar search=new Guitar(4,23.3D,searchMap);
		System.out.println("serarch:"+inventory.serarch(search));
		
	}

}
