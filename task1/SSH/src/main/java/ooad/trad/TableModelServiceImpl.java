package ooad.trad;

import java.util.Map;
public class TableModelServiceImpl implements TableModelService {
	private TableModelDao tableModelDao;
	public void setTableModelDao(TableModelDao tableModelDao) {
		this.tableModelDao = tableModelDao;
	}
	@Override
	public Pager<Object> findData(Map searchData) {
		Pager<Object> result = tableModelDao.findData(searchData);
		return result;
	}
}
