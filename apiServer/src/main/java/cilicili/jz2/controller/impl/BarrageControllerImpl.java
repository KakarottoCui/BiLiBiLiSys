package cilicili.jz2.controller.impl;

import cilicili.jz2.controller.IBarrageController;
import cilicili.jz2.pojo.Barrage;
import cilicili.jz2.pojo.Token;
import cilicili.jz2.pojo.User;
import cilicili.jz2.pojo.Video;
import cilicili.jz2.service.impl.BarrageServiceImpl;
import cilicili.jz2.service.impl.UserServiceImpl;
import cilicili.jz2.service.impl.VideoServiceImpl;
import cilicili.jz2.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping ("/barrage")
public class BarrageControllerImpl implements IBarrageController {
	private final BarrageServiceImpl barrageService;
	private final UserServiceImpl userService;
	private final VideoServiceImpl videoService;
	
	@Autowired
	public BarrageControllerImpl(BarrageServiceImpl barrageService, UserServiceImpl userService, VideoServiceImpl videoService) {
		this.barrageService = barrageService;
		this.userService = userService;
		this.videoService = videoService;
	}
	
	@RequestMapping ("/findId")
	@ResponseBody
	@Override
	public Map<String, Serializable> showBarrages(@RequestParam ("id") Integer videoId) {
		Map<String, Serializable> result = new HashMap<>();
		ArrayList<Barrage> barrages = (ArrayList<Barrage>) barrageService.showBarrages(videoId);
		result.put("barrages", barrages);
		return result;
	}
	
	@RequestMapping ("/add")
	@ResponseBody
	@Override
	public Map<String, Serializable> addBarrage(Barrage barrage, String token) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		try {
			do {
				Token tokenCheck = TokenUtil.checkToken(token, TokenUtil.TokenUssage.DEFAULT);
				User user = userService.findUserById(tokenCheck.getUserId());
				if (user == null) {
					throw new TokenUtil.TokenNotFound("用户不存在");
				}
				if (barrage.getVideoId() == null) {
					result.put("msg", "视频 id 为空");
					break;
				} else {
					Video video = videoService.findVideoById(barrage.getVideoId());
					if (video == null) {
						result.put("msg", "视频 id 不正确");
						break;
					}
				}
				if (barrage.getContent() == null) {
					result.put("msg", "弹幕内容为空");
					break;
				} else if (barrage.getContent().length() == 0 || barrage.getContent().length() > 250) {
					result.put("msg", "弹幕内容为空或超过250长度限制");
					break;
				}
				if (barrage.getColor() == null || barrage.getColor().length() == 0 || barrage.getColor().length() > 10) {
					barrage.setColor("#ffffff");
					break;
				}
				if (barrage.getOfftime() == null || barrage.getOfftime() < 0) {
					barrage.setOfftime(0);
					break;
				}
				if (barrage.getPosition() == null || barrage.getPosition() < 0) {
					barrage.setPosition(Byte.valueOf("0"));
					break;
				}
				barrage.setUserId(user.getId());
				barrage.setId(null);
				barrage.setSendtime(ZonedDateTime.now());
				try {
					barrageService.addBarrage(barrage);
					result.put("status", "success");
				} catch (Exception e) {
					result.put("msg", "未知错误");
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
