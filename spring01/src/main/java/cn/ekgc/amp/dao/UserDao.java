package cn.ekgc.amp.dao;

import cn.ekgc.amp.pojo.entity.User;

import java.util.List;

/**
 * <b>用户信息功能数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 */
public interface UserDao {
	/**
	 * <b>根据查询对象查询信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> findListByQuery(User query) throws Exception;

	/**
	 * <b>保存信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(User entity) throws Exception;

	/**
	 * <b>修改信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(User entity) throws Exception;
}
