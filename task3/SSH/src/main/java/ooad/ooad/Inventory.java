package ooad.ooad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Guitar的全部数据
 * @author zhang
 * @date  2016年5月26日 下午7:05:24
 * @doing 初始化数据
 */
public class Inventory {
	private  List<Guitar> allData=new ArrayList<Guitar>();
	private DaoImpl daoImpl;
	public void setDaoImpl(DaoImpl daoImpl) {
		this.daoImpl = daoImpl;
		addGuitar();
	}
	public List<Guitar> getAllData() {
		return allData;
	}
	/**
	 * 实际上从数据库中取数据（初始化数据）
	 */
	private void addGuitar(){
		allData.addAll(daoImpl.getData());
//		Map<String, Object> guitarSpec1Map=new HashMap<String, Object>();
//		guitarSpec1Map.put("backwood", "木头");
//		guitarSpec1Map.put("topwood",  "木头");
//		guitarSpec1Map.put("type",  "铁");
//		guitarSpec1Map.put("builder",  "zhang");
//		guitarSpec1Map.put("guitarmodel",  "modelzhang");
//		Guitar guitar1=new Guitar(1,23D,guitarSpec1Map);
//		this.allData.add(guitar1);
//		
//		Map<String, Object> guitarSpec2Map=new HashMap<String, Object>();
//		guitarSpec2Map.put("backwood", "木头");
//		guitarSpec2Map.put("topwood",  "塑料");
//		guitarSpec2Map.put("type",  "铁");
//		guitarSpec2Map.put("builder",  "zhang");
//		guitarSpec2Map.put("guitarmodel",  "modelzhang");
//		Guitar guitar2=new Guitar(1,23D,guitarSpec2Map);
//		this.allData.add(guitar2);
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
