package Model;

/** 
 * 
 * @author zhang
 * @Date  2016年6月28日 下午10:11:43
 * @doing 
 */

public class Page {
	private Integer page;
	private Integer rows;
	public Page(Integer page,Integer rows) {
		this.page=page;
		this.rows=rows;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + "]";
	}
	
}
