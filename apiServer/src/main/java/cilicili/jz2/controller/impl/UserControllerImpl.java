package cilicili.jz2.controller.impl;

import cilicili.jz2.controller.IUserController;
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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping ("/user")
public class UserControllerImpl implements IUserController {
	private final UserServiceImpl userService;
	
	@Autowired
	public UserControllerImpl(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@RequestMapping (value = "/findId", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Map<String, Serializable> findUserById(Integer id, String token) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		try {
			Token tokenCheck = TokenUtil.checkToken(token, TokenUtil.TokenUssage.DEFAULT);
		} catch (TokenUtil.TokenExpired | TokenUtil.TokenNotFound | TokenUtil.TokenOverAuthed | TokenUtil.TokenUssageNotMatched tokenError) {
			result.put("msg", tokenError.getMessage());
			return result;
		}
		User user = userService.findUserById(id);
		if (user == null) {
			result.put("msg", "找不到该用户");
		} else {
			user.setPassword(null);
			result.put("status", "success");
			result.put("user", user);
		}
		return result;
	}
	
	@RequestMapping (value = "/findUsername", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Map<String, Serializable> findUserByUsername(String username, String token) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		try {
			Token tokenCheck = TokenUtil.checkToken(token, TokenUtil.TokenUssage.DEFAULT);
		} catch (TokenUtil.TokenExpired | TokenUtil.TokenNotFound | TokenUtil.TokenOverAuthed | TokenUtil.TokenUssageNotMatched tokenError) {
			result.put("msg", tokenError.getMessage());
			return result;
		}
		User user = userService.findUserByUsername(username);
		if (user == null) {
			result.put("msg", "找不到该用户");
		} else {
			user.setPassword(null);
			result.put("status", "success");
			result.put("user", user);
		}
		return result;
	}
	
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Map<String, Serializable> addUser(User user) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		do {
			if (user.getUsername() == null) {
				result.put("msg", "用户名为空");
				break;
			} else if (user.getUsername().length() == 0 || user.getUsername().length() >= 20) {
				result.put("msg", "用户名为空或超过20长度限制");
				break;
			}
			if (user.getPassword() == null) {
				result.put("msg", "密码为空");
				break;
			} else if (user.getPassword().length() == 0 || user.getPassword().length() >= 20) {
				result.put("msg", "密码为空或超过20长度限制");
				break;
			}
			user.setId(null);
			user.setIdentity("普通会员");
			try {
				userService.addUser(user);
				result.put("status", "success");
			} catch (Exception e) {
				result.put("msg", user.getUsername() + " 已被注册");
			}
		} while (false);
		return result;
	}
	
	@RequestMapping (value = "/update", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public Map<String, Serializable> updateUser(User user, String token, String apply) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		try {
			do {
				Token tokenApply = TokenUtil.checkToken(apply, TokenUtil.TokenUssage.MODIFY_USER_SETTINGS);
				Token tokenDefault = TokenUtil.checkToken(token, TokenUtil.TokenUssage.DEFAULT);
				if (!tokenApply.getUserId().equals(tokenDefault.getUserId())) {
					throw new TokenUtil.TokenNotFound("非本人操作，拒绝授权");
				}
				TokenUtil.destoryToken(token);
				TokenUtil.destoryToken(apply);
				User userCheck = userService.findUserById(tokenApply.getUserId());
				if (userCheck == null) {
					throw new TokenUtil.TokenNotFound("用户不存在");
				}
				if (user.getUsername() == null) {
					result.put("msg", "用户名为空");
					break;
				} else if (user.getUsername().length() == 0 || user.getUsername().length() > 20) {
					result.put("msg", "用户名为空或超过20长度限制");
					break;
				}
				if (user.getPassword() == null) {
					result.put("msg", "密码为空");
					break;
				} else if (user.getPassword().length() == 0 || user.getPassword().length() > 20) {
					result.put("msg", "密码为空或超过20长度限制");
					break;
				}
				user.setId(userCheck.getId());
				try {
					userService.updateUser(user);
					result.put("status", "success");
				} catch (Exception e) {
					result.put("msg", user.getUsername() + " 已被注册");
				}
			} while (false);
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
