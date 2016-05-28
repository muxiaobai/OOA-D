package ooad.trad;

import java.util.Map;
public interface TableModelDao {
	public Pager<Object> findData(Map searchModel);
}
