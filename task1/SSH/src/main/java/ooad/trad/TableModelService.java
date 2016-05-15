package ooad.trad;

import java.util.Map;


public interface TableModelService {
	public Pager<Object> findData(Map searchData);

}
