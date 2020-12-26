package cn.ekgc.amp.controller;

import cn.ekgc.amp.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>用户信息功能控制层</b>
 * @author Arthur
 * @version 1.0.0
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * <b>转发到登录页面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/login")
	public String forwardLoginPage() throws Exception {
		return "user/user_login";
	}

	/**
	 * <b>当用户登录失败时执行</b>
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public String loginUserError() throws Exception {
		return "redirect:logout";
	}
}
