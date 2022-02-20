package cilicili.jz2.service;

import cilicili.jz2.pojo.Token;

public interface ITokenService {
	Token findToken(String token);
	
	void addToken(Token token);
	
	void updateToken(Token token);
	
	void deleteTokens(Integer userId);
}
