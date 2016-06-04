package Dao;

import java.util.List;
import Model.Guitar;

/** 
 * 
 * @author zhang
 * @Date  2016年6月3日 下午5:29:21
 * @doing 
 */

public interface IGuitarDao {
	public void save(Guitar guitar);
	public void delete(Integer id);
	public List<Guitar> findAll();
}
