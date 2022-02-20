package cilicili.jz2.service.impl;

import cilicili.jz2.dao.TokenMapper;
import cilicili.jz2.pojo.Token;
import cilicili.jz2.pojo.TokenExample;
import cilicili.jz2.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service ("tokenService")
public class TokenServiceImpl implements ITokenService {
	private final TokenMapper tokenMapper;
	
	@Autowired
	public TokenServiceImpl(TokenMapper tokenMapper) {
		this.tokenMapper = tokenMapper;
	}
	
	@Override
	public Token findToken(String token) {
		TokenExample tokenExample = new TokenExample();
		TokenExample.Criteria criteria = tokenExample.createCriteria();
		criteria.andTokenEqualTo(token);
		List<Token> tokenList = tokenMapper.selectByExample(tokenExample);
		if (tokenList.size() == 0) {
			return null;
		} else {
			return tokenList.get(0);
		}
	}
	
	@Override
	public void addToken(Token token) {
		tokenMapper.insert(token);
	}
	
	@Override
	public void updateToken(Token token) {
		tokenMapper.updateByPrimaryKeySelective(token);
	}
	
	@Override
	public void deleteTokens(Integer userId) {
		TokenExample tokenExample = new TokenExample();
		TokenExample.Criteria criteria = tokenExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		tokenMapper.deleteByExample(tokenExample);
	}
}
