package ServiceImpl;

import java.lang.reflect.ParameterizedType;
import Dao.BaseDao;
import Service.BaseService;
@SuppressWarnings({ "rawtypes" ,"unused"})
public class BaseServiceImpl<T> implements BaseService<T> {
	protected BaseDao baseDao;
	private Class clazz;
	public BaseServiceImpl() {
		this.clazz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println("==clazz：BaseServiceImpl父类构造方法执行了==");
	}
}
