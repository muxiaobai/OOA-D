package ooad.ooad;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
/**
 * Guitar类，包含一个GuitarSpacMap属性
 * 
 * @author zhang
 * @date 2016年5月26日 下午3:18:57
 * @doing TODO
 */
public class Guitar {
	public Guitar() {
	}

	public Guitar(Integer id, Double price, Map<String, Object> guitarSpecMap) {
		this.id = id;
		this.price = price;
		this.guitarSpecMap = guitarSpecMap;
	}
	private Map<String,Object> guitarSpecMap;
	public void setGuitarSpecMap(Map<String, Object> guitarSpecMap) {
		this.guitarSpecMap = guitarSpecMap;
	}
	public Map<String, Object> getGuitarSpecMap() {
		return guitarSpecMap;
	}
	private Integer id;//
	private Double price;// 价格

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 比较方法（重写equals()方法）
	 */
	@Override
	public boolean equals(Object obj) {
		Guitar guitar=(Guitar)obj;
		Map<String, Object> ObjGuitarSpecMap=guitar.getGuitarSpecMap();
		Iterator<String> iterator=ObjGuitarSpecMap.keySet().iterator();
			while (iterator.hasNext()) {
				String iter = iterator.next();
				String value=Arrays.toString((Object[])guitarSpecMap.get(iter));
				
				if(value==null||value.equals("")||value.equals("[]")){
					continue;
				}
				System.out.println("ObjGuitarSpecMap:"+ObjGuitarSpecMap.get(iter)+",value:"+value);
				System.out.println(("["+ObjGuitarSpecMap.get(iter)+"]").equals(value));
				if(!("["+ObjGuitarSpecMap.get(iter)+"]").equals(value)){
					System.out.println(iter+":"+ObjGuitarSpecMap.get(iter));
					return false;
				}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Guitar [guitarSpecMap=" + guitarSpecMap + ", id=" + id + ", price=" + price + "]";
	}
	
}
