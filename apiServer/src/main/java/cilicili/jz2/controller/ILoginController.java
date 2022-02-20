package cilicili.jz2.controller;

import java.io.Serializable;
import java.util.Map;

public interface ILoginController {
	Map<String, Serializable> login(String username, String password);
	
	Map<String, Serializable> logout(String token);
	
	Map<String, Serializable> now(String token);
	
	Map<String, Serializable> apply(String token, String ussage);
}
