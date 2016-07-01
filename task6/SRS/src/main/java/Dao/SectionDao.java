package Dao;

import Model.Section;

/** 
 * 
 * @author zhang
 * @Date  2016年6月21日 下午3:32:19
 * @doing 
 */

public interface SectionDao extends BaseDao<Section>{
	public void deleteById(Integer sectionId);
}	
