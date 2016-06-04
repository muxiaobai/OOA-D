package Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import Dao.IGuitarDao;
/**
 * Guitar的全部数据
 * @author zhang
 * @date  2016年5月26日 下午7:05:24
 * @doing 初始化数据
 */
public class Inventory {
	public Inventory() {
		System.out.println("===初始化仓库==========");
	}
	private  List<Guitar> allData=new ArrayList<Guitar>();
	private IGuitarDao guitarDao;
	public void setGuitarDao(IGuitarDao guitarDao) {
		this.guitarDao = guitarDao;
	}

	public List<Guitar> getAllData() {
		return allData;
	}
	public void init() {
	//	Guitar guitar=new Guitar();
		Map<String, String> guitarSpec1Map=new HashMap<String, String>();
		guitarSpec1Map.put("backwood", "木头1");
		guitarSpec1Map.put("topwood",  "木头1");
		guitarSpec1Map.put("type",  "铁1");
		guitarSpec1Map.put("builder",  "zhang1");
		guitarSpec1Map.put("guitarmodel",  "modelzhang1");
		Guitar guitar1=new Guitar(1,23D,guitarSpec1Map);
		//this.allData.add(guitar1);
		Map<String, String> guitarSpec2Map=new HashMap<String, String>();
		guitarSpec2Map.put("backwood", "木头2");
		guitarSpec2Map.put("topwood",  "塑料2");
		guitarSpec2Map.put("type",  "铁2");
		guitarSpec2Map.put("builder",  "zhang2");
		guitarSpec2Map.put("guitarmodel",  "modelzhang2");
		Guitar guitar2=new Guitar(2,23D,guitarSpec2Map);
		//this.allData.add(guitar2);
		allData.addAll(guitarDao.findAll());
		System.out.println("init:"+allData);
	}
	/**
	 * 实际上从数据库中取数据（初始化数据）
	 */
	public void addGuitar(Guitar guitar){
		Map<String, String> guitarSpec1Map=new HashMap<String, String>();
		guitarSpec1Map.put("backwood", "木头");
		guitarSpec1Map.put("topwood",  "木头");
		guitarSpec1Map.put("type",  "铁");
		guitarSpec1Map.put("builder",  "zhang");
		guitarSpec1Map.put("guitarmodel",  "modelzhang");
		Guitar guitar1=new Guitar(1,23D,guitarSpec1Map);
		this.allData.add(guitar);
		guitarDao.save(guitar);

	}
	public void delGuitar(Guitar guitar){
		for (int i = 0; i < allData.size(); i++) {
			Guitar guitar2=(Guitar)allData.get(i);
			if(guitar2.getId()==guitar.getId()){
				allData.remove(i);
				guitarDao.delete(guitar.getId());
			}
		}
	}
	/**
	 * 查询Guitar
	 * @param searchguitar前台的数据
	 * @return 返回通过Guitar判断的Guitar
	 */
	public List<Guitar> serarch(Guitar searchGuitar){
		List<Guitar> result=new ArrayList<Guitar>();
		Iterator<Guitar> iterator=allData.iterator();
		while (iterator.hasNext()) {
			Guitar guitar = (Guitar) iterator.next();
			if(searchGuitar.equals(guitar)){
				result.add(guitar);
			}
		}
		return  result;
	}
}
