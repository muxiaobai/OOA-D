package ooad.trad;

import java.util.List;
import java.util.Map;
public class TableModelDaoImpl implements TableModelDao {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager<Object> findData(Map searchData) {
		//System.out.println(SqlUtil.doSelect(searchModel));
		 List<Object> result= new ResultUtil().findResult(SqlUtil.doSelect(searchData)); 
		 Pager<Object> pager=new Pager<Object>((int)searchData.get("pageNum"), (int)searchData.get("pageSize"), result);
		return pager;   
	}

}
