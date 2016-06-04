package Test;

import java.util.HashMap;
import java.util.Map;

import Model.Guitar;
import Model.Inventory;
import Test.BaseClass;
/** 
 * 
 * @author zhang
 * @Date  2016年6月4日 上午10:20:46
 * @doing 
 */

public class DaoTest {
	public static void main(String[] args) {
//		IGuitarDao guitarDao=(IGuitarDao)BaseClass.LoadXML().getBean("guitarDaoImpl");
//		System.out.println(guitarDao.findAll());
		Inventory inventory=(Inventory)BaseClass.LoadXML().getBean("inventory");
		Guitar guitar=new Guitar();
		guitar.setId(4);
		//inventory.delGuitar(guitar);
		Map<String, String> guitarSpec2Map=new HashMap<String, String>();
		guitarSpec2Map.put("backwood", "木头2");
		guitarSpec2Map.put("topwood",  "塑料2");
		guitarSpec2Map.put("type",  "铁2");
		guitarSpec2Map.put("builder",  "zhang2");
		guitarSpec2Map.put("guitarmodel",  "modelzhang2");
		Guitar guitar2=new Guitar();
		guitar2.setGuitarSpecMap(guitarSpec2Map);
		inventory.addGuitar(guitar2);
		System.out.println(inventory.getAllData());
	}

}
