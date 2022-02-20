package cilicili.jz2.controller.impl;

import cilicili.jz2.controller.ILoginController;
import cilicili.jz2.pojo.Token;
import cilicili.jz2.pojo.User;
import cilicili.jz2.service.impl.UserServiceImpl;
import cilicili.jz2.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginControllerImpl implements ILoginController {
	private final UserServiceImpl userService;
	
	@Autowired
	public LoginControllerImpl(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Map<String, Serializable> login(String username, String password) {
		Map<String, Serializable> result = new HashMap<>();
		User user = userService.findUserByUsernamePassword(username, password);
		result.put("status", "failure");
		if (user == null) {
			result.put("msg", "用户名或密码错误");
		} else {
			TokenUtil.destoryOldTokens(user.getId());
			Token newToken = TokenUtil.createToken(user.getId(), TokenUtil.TokenUssage.DEFAULT, TokenUtil.DEFAULT_MAX_COUNT_AUTH, Period.of(0, 1, 0));
			result.put("status", "success");
			result.put("token", newToken.getToken());
		}
		return result;
	}
	
	@RequestMapping (value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Map<String, Serializable> logout(String token) {
		Map<String, Serializable> result = new HashMap<>();
		TokenUtil.destoryToken(token);
		result.put("status", "success");
		return result;
	}
	
	@RequestMapping (value = "/now", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Map<String, Serializable> now(String token) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", false);
		try {
			Token tokenCheck = TokenUtil.checkToken(token, TokenUtil.TokenUssage.DEFAULT);
			User user = userService.findUserById(tokenCheck.getUserId());
			if (user == null) {
				throw new TokenUtil.TokenNotFound("用户不存在");
			}
			user.setPassword(null);
			result.put("user", user);
			result.put("status", true);
		} catch (TokenUtil.TokenExpired | TokenUtil.TokenNotFound | TokenUtil.TokenOverAuthed | TokenUtil.TokenUssageNotMatched tokenError) {
			result.put("msg", tokenError.getMessage());
		}
		return result;
	}
	
	@RequestMapping (value = "/apply", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Map<String, Serializable> apply(String token, String ussage) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		User user;
		try {
			Token tokenCheck = TokenUtil.checkToken(token, TokenUtil.TokenUssage.DEFAULT);
			user = userService.findUserById(tokenCheck.getUserId());
			if (user == null) {
				throw new TokenUtil.TokenNotFound("用户不存在");
			}
			if (ussage.equals(TokenUtil.TokenUssage.UPLOAD_FILE) || ussage.equals(TokenUtil.TokenUssage.UPDATE_VIDEO_INFO) || ussage.equals(TokenUtil.TokenUssage.MODIFY_USER_SETTINGS)) {
				Token newToken = TokenUtil.createToken(user.getId(), ussage, 1, Period.of(0, 0, 1));
				result.put("status", "success");
				result.put("token", newToken.getToken());
			} else {
				result.put("msg", "非法获取权限");
			}
		} catch (TokenUtil.TokenExpired | TokenUtil.TokenNotFound | TokenUtil.TokenOverAuthed | TokenUtil.TokenUssageNotMatched tokenError) {
			result.put("msg", tokenError.getMessage());
		}
		return result;
	}
	
	@ResponseBody
	@ExceptionHandler ({Exception.class})
	public Map<String, Serializable> exceptionHandle(Exception e) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		result.put("msg", "参数错误");
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.error(e.getMessage());
		logger.error(e.getLocalizedMessage());
		return result;
	}
}
