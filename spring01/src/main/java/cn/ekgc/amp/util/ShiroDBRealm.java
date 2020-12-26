package cn.ekgc.amp.util;

import cn.ekgc.amp.base.enums.AuditStatusEnum;
import cn.ekgc.amp.base.enums.StatusEnum;
import cn.ekgc.amp.pojo.entity.Role;
import cn.ekgc.amp.pojo.entity.User;
import cn.ekgc.amp.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * <b>Shiro 框架进行用户登录认证组件</b>
 * @author Arthur
 * @version 1.0.0
 */
@Component("shiroDBRealm")
public class ShiroDBRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;

	/**
	 * <b>登录之后的授权</b>
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

	/**
	 * <b>进行用户登录认证</b>
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 为了获得用户登录时所提交的用户名和密码，需要将默认的 AuthenticationToken 强制类型转换为 UsernamePasswordToken
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		// 通过 UsernamePasswordToken 获得用户提交的用户名
		String cellphone = token.getUsername();
		// 获得用户密码信息
		char[] passwords = token.getPassword();
		if (cellphone != null && !"".equals(cellphone.trim()) && passwords != null && passwords.length > 0) {
			try {
				// 通过手机号码在数据库中查询对应的用户信息
				User user = userService.getUserByCellphone(cellphone);
				// 判断经过手机号码是否能够获得该用户
				if (user != null) {
					// 获得此时用户角色
					Role role = user.getRole();
					boolean isCanLogin = (role.getId() != 3 && user.getStatus() == StatusEnum.STATUS_ENABLE.getCode())
							|| (role.getId() == 3 && user.getAuditStatus() == AuditStatusEnum.AUDIT_STATUS_SUCCESS.getCode()
							&& user.getStatus() == StatusEnum.STATUS_ENABLE.getCode());
					if (isCanLogin) {
						// 允许用户登录
						// 将密码变为 String
						String password = new String(passwords);
						// 对密码进行加密
						password = MD5Util.encrypt(password);
						// 将完成加密的密码重新设定到 UsernamePasswordToken
						token.setPassword(password.toCharArray());
						// 完成对密码的更新之后，交给 Shiro 进行比对
						SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
								user.getCellphone(), user.getPassword(), getName());
						// 默认登录成功，绑定 session
						session.setAttribute("user", user);
						return info;
					} else {
						throw new AuthenticationException("该用户禁止登录！");
					}
				} else {
					// 根据手机号码为查询到用户信息
					throw new AuthenticationException("该用户为注册！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new AuthenticationException("登录异常！");
			}
		} else {
			throw new AuthenticationException("未填写有效的登录信息！");
		}
	}
}
