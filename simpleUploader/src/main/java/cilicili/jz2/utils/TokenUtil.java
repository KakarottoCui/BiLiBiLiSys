package cilicili.jz2.utils;

import cilicili.jz2.pojo.Token;
import cilicili.jz2.service.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Period;
import java.time.ZonedDateTime;

@Component
public class TokenUtil {
	public static final Integer DEFAULT_MAX_COUNT_AUTH = 1000;
	
	public static class TokenUssage {
		public static final String DEFAULT = "default";
		public static final String UPLOAD_FILE = "upload_file";
		public static final String MODIFY_USER_SETTINGS = "modify_user_settings";
		public static final String UPDATE_VIDEO_INFO = "update_video_info";
	}
	
	public static class TokenExpired extends Error {
		public TokenExpired(String message) {
			super(message);
		}
	}
	
	public static class TokenNotFound extends Error {
		public TokenNotFound(String message) {
			super(message);
		}
	}
	
	public static class TokenOverAuthed extends Error {
		public TokenOverAuthed(String message) {
			super(message);
		}
	}
	
	public static class TokenUssageNotMatched extends Error {
		public TokenUssageNotMatched(String message) {
			super(message);
		}
	}
	
	private static TokenServiceImpl tokenService;
	
	@Autowired
	public TokenUtil(TokenServiceImpl tokenService) {
		TokenUtil.tokenService = tokenService;
	}
	
	public static Token checkToken(String tokenString, String ussage) throws TokenExpired, TokenNotFound, TokenOverAuthed, TokenUssageNotMatched {
		Token token = tokenService.findToken(tokenString);
		if (token == null) {
			throw new TokenNotFound("找不到该 token： " + tokenString + " ，无法授权");
		}
		if (token.getExpiretime().compareTo(ZonedDateTime.now()) < 0) {
			throw new TokenExpired("该 token： " + tokenString + " 已失效，无法授权");
		}
		if (token.getCountAuth() >= token.getMaxCountAuth()) {
			throw new TokenOverAuthed("该 token： " + tokenString + " 已超过最大授权次数，无法授权");
		}
		if (!ussage.equals(token.getUssage())) {
			throw new TokenUssageNotMatched("该 token： " + tokenString + " 无法用于 ussage: " + ussage + "，无法授权");
		}
		token.setCountAuth(token.getCountAuth() + 1);
		tokenService.updateToken(token);
		token = tokenService.findToken(tokenString);
		return token;
	}
	
	public static Token createToken(Integer userId, String tokenUssage, Integer maxCountAuth, Period validPeriod) {
		Token token = new Token();
		token.setUserId(userId);
		token.setToken(RandomUtil.getRandomToken(userId));
		token.setApplytime(ZonedDateTime.now());
		token.setExpiretime(ZonedDateTime.now().plus(validPeriod));
		token.setCountAuth(0);
		token.setMaxCountAuth(maxCountAuth);
		token.setUssage(tokenUssage);
		tokenService.addToken(token);
		token = tokenService.findToken(token.getToken());
		return token;
	}
	
	public static void destoryToken(String tokenString) throws TokenNotFound {
		Token token = tokenService.findToken(tokenString);
		if (token == null) {
			throw new TokenNotFound("找不到该 token： " + tokenString);
		}
		token.setExpiretime(ZonedDateTime.now());
		tokenService.updateToken(token);
	}
	
	public static void destoryOldTokens(Integer userId) {
		tokenService.deleteTokens(userId);
	}
}
