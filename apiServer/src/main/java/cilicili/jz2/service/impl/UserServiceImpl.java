package cilicili.jz2.service.impl;

import cilicili.jz2.dao.UserMapper;
import cilicili.jz2.pojo.User;
import cilicili.jz2.pojo.UserExample;
import cilicili.jz2.service.IUserService;
import cilicili.jz2.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service ("userService")
public class UserServiceImpl implements IUserService {
	private final UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public User findUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public User findUserByUsername(String username) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		return userMapper.selectByExample(userExample).get(0);
	}
	
	@Override
	public User findUserByUsernamePassword(String username, String password) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(PasswordUtil.getHashedPassword(password));
		List<User> userList = userMapper.selectByExample(userExample);
		if (userList.size() == 0) {
			return null;
		} else {
			return userList.get(0);
		}
	}
	
	@Override
	public void addUser(User user) {
		user.setPassword(PasswordUtil.getHashedPassword(user.getPassword()));
		userMapper.insert(user);
	}
	
	@Override
	public void updateUser(User user) {
		user.setPassword(PasswordUtil.getHashedPassword(user.getPassword()));
		userMapper.updateByPrimaryKeySelective(user);
	}
	
}
