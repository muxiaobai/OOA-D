package ooad.trad;
/**
 * 吉他model
 * @author zhang
 * @date  2016年5月15日 下午7:15:33
 * @doing TODO模型类
 */
public class Guitar {
	private Integer id;//
	private Double price;//价格
	private String backwood;//
	private String topwood;//
	private String type;//类型
	private String builder;//建造者
	private String guitarmodel;//模型
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
	public String getBackwood() {
		return backwood;
	}
	public void setBackwood(String backwood) {
		this.backwood = backwood;
	}
	public String getTopwood() {
		return topwood;
	}
	public void setTopwood(String topwood) {
		this.topwood = topwood;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getGuitarmodel() {
		return guitarmodel;
	}
	public void setGuitarmodel(String guitarmodel) {
		this.guitarmodel = guitarmodel;
	}
	@Override
	public String toString() {
		return "Guitar [id=" + id + ", price=" + price + ", backwood=" + backwood + ", topwood=" + topwood + ", type="
				+ type + ", builder=" + builder + ", guitarmodel=" + guitarmodel + "]";
	}
	
}
