package DaoImpl;

import Dao.SectionDao;
import Model.Section;

/** 
 * 
 * @author zhang
 * @Date  2016年6月21日 下午3:33:11
 * @doing 
 */

public class SectionDaoImpl extends BaseDaoImpl<Section> implements SectionDao{
	@Override
	public void deleteById(Integer sectionId) {
		delete(findById(sectionId));
	}
}
