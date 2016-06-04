package Model;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
/**
 * Guitar类，包含一个GuitarSpacMap属性
 * 
 * @author zhang
 * @date 2016年5月26日 下午3:18:57
 * @doing TODO
 */
@Entity
public class Guitar {
	public Guitar() {
	}

	public Guitar(Integer id, Double price, Map<String, String> guitarSpecMap) {
		this.id = id;
		this.price = price;
		this.guitarSpecMap = guitarSpecMap;
	}
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="spec",joinColumns=@JoinColumn(name="id"))
	@MapKeyColumn(name="spec")
	@MapKeyClass(String.class)
	@Column(name="val")
	private Map<String, String> guitarSpecMap;
	
	public void setGuitarSpecMap(Map<String, String> guitarSpecMap) {
		this.guitarSpecMap = guitarSpecMap;
	}
	public Map<String, String> getGuitarSpecMap() {
		return guitarSpecMap;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	 * 比较方法（重写equals()方法）序列化
	 */
	@Override
	public boolean equals(Object obj) {
		Guitar guitar=(Guitar)obj;
		Map<String, String> ObjGuitarSpecMap=guitar.getGuitarSpecMap();
		Iterator<String> iterator=ObjGuitarSpecMap.keySet().iterator();
			while (iterator.hasNext()) {
				String iter = iterator.next();
				String value=guitarSpecMap.get(iter);
				if(value==null||value.equals("")){
					continue;
				}
				if(!ObjGuitarSpecMap.get(iter).equals(value)){
					System.out.println(iter+":"+ObjGuitarSpecMap.get(iter));
					return false;
				}
		}
		return true;
	}
	//正常情况下
//	@Override
//	public boolean equals(Object obj) {
//		Guitar guitar=(Guitar)obj;
//		Map<String, String> ObjGuitarSpecMap=guitar.getGuitarSpecMap();
//		Iterator<String> iterator=ObjGuitarSpecMap.keySet().iterator();
//			while (iterator.hasNext()) {
//				String iter = iterator.next();
//				String value=(String) guitarSpecMap.get(iter);
//				
//				if(value==null||value.equals("")||value.equals("[]")){
//					continue;
//				}
//				if(!(ObjGuitarSpecMap.get(iter)).equals(value)){
//					return false;
//				}
//		}
//		return true;
//	}
	@Override
	public String toString() {
		return "Guitar [guitarSpecMap=" + guitarSpecMap + ", id=" + id + ", price=" + price + "]";
	}
	
}
