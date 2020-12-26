package cn.ekgc.amp.service.impl;

import cn.ekgc.amp.dao.UserDao;
import cn.ekgc.amp.pojo.entity.User;
import cn.ekgc.amp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>用户信息功能业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@Override
	public User getUserByCellphone(String cellphone) throws Exception {
		// 封装查询对象
		User query = new User();
		// 将手机号码设定到查询对象中
		query.setCellphone(cellphone);
		// 进行查询
		List<User> userList = userDao.findListByQuery(query);
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}
}
