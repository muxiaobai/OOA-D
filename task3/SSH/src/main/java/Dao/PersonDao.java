package Dao;

import Model.Person;

/**
 * PersonDao:接口 [extends BaseDao]
 * @author zhang
 * @date 2016年5月21日 下午7:14:44
 * @doing 对外提供方法的标准,当调用Person下面的方法的时候,建议定义为此接口。
 */
public interface PersonDao extends BaseDao<Person> {

}
