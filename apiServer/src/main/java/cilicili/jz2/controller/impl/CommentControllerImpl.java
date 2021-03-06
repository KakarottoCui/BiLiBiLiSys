package cilicili.jz2.controller.impl;

import cilicili.jz2.controller.ICommentController;
import cilicili.jz2.pojo.Comment;
import cilicili.jz2.pojo.Token;
import cilicili.jz2.pojo.User;
import cilicili.jz2.pojo.Video;
import cilicili.jz2.service.impl.CommentServiceImpl;
import cilicili.jz2.service.impl.UserServiceImpl;
import cilicili.jz2.service.impl.VideoServiceImpl;
import cilicili.jz2.utils.TokenUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
@RequestMapping ("/comment")
public class CommentControllerImpl implements ICommentController {
	private final CommentServiceImpl commentService;
	private final UserServiceImpl userService;
	private final VideoServiceImpl videoService;
	
	@Autowired
	public CommentControllerImpl(CommentServiceImpl commentService, UserServiceImpl userService, VideoServiceImpl videoService) {
		this.commentService = commentService;
		this.userService = userService;
		this.videoService = videoService;
	}
	
	@RequestMapping ("/findId")
	@ResponseBody
	@Override
	public Map<String, Serializable> showComments(@RequestParam ("id") Integer videoId, Integer offset) {
		Map<String, Serializable> result = new HashMap<>();
		if (offset == null) {
			offset = 0;
		}
		PageHelper.startPage(offset, 10);
		ArrayList<Comment> comments = (ArrayList<Comment>) commentService.showComments(videoId);
		PageInfo<Comment> pageInfo = new PageInfo<>(comments);
		result.put("page", pageInfo);
		return result;
	}
	
	@RequestMapping ("/add")
	@ResponseBody
	@Override
	public Map<String, Serializable> addComment(Comment comment, String token) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		try {
			do {
				Token tokenCheck = TokenUtil.checkToken(token, TokenUtil.TokenUssage.DEFAULT);
				User user = userService.findUserById(tokenCheck.getUserId());
				if (user == null) {
					throw new TokenUtil.TokenNotFound("???????????????");
				}
				if (comment.getVideoId() == null) {
					result.put("msg", "?????? id ??????");
					break;
				} else {
					Video video = videoService.findVideoById(comment.getVideoId());
					if (video == null) {
						result.put("msg", "?????? id ?????????");
						break;
					}
				}
				if (comment.getContent() == null) {
					result.put("msg", "??????????????????");
					break;
				} else if (comment.getContent().length() == 0 || comment.getContent().length() > 250) {
					result.put("msg", "???????????????????????????250????????????");
					break;
				}
				comment.setUserId(user.getId());
				comment.setId(null);
				comment.setSendtime(ZonedDateTime.now());
				comment.setCountLike(0);
				try {
					commentService.addComment(comment);
					result.put("status", "success");
				} catch (Exception e) {
					result.put("msg", "????????????");
				}
			} while (false);
		} catch (TokenUtil.TokenExpired | TokenUtil.TokenNotFound | TokenUtil.TokenOverAuthed | TokenUtil.TokenUssageNotMatched tokenError) {
			result.put("msg", tokenError.getMessage());
		}
		return result;
	}
	
	@RequestMapping ("/delete")
	@ResponseBody
	@Override
	public Map<String, Serializable> deleteComment(Integer id, String token) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		try {
			Token tokenCheck = TokenUtil.checkToken(token, TokenUtil.TokenUssage.DEFAULT);
			User user = userService.findUserById(tokenCheck.getUserId());
			Comment comment = commentService.findCommentById(id);
			do {
				if (comment == null) {
					result.put("msg", "???????????????");
					break;
				} else if (user == null) {
					throw new TokenUtil.TokenNotFound("???????????????");
				} else if (!user.getId().equals(comment.getUserId())) {
					throw new TokenUtil.TokenNotFound("??????????????????????????????");
				}
				try {
					commentService.deleteComment(id);
					result.put("status", "success");
				} catch (Exception e) {
					result.put("msg", "????????????");
				}
			} while (false);
		} catch (TokenUtil.TokenExpired | TokenUtil.TokenNotFound | TokenUtil.TokenOverAuthed | TokenUtil.TokenUssageNotMatched tokenError) {
			result.put("msg", tokenError.getMessage());
		}
		return result;
	}
	
	@RequestMapping ("/like")
	@ResponseBody
	@Override
	public Map<String, Serializable> likeComment(Integer id) {
		Map<String, Serializable> result = new HashMap<>();
		Comment comment = commentService.findCommentById(id);
		try {
			comment.setCountLike(comment.getCountLike() + 1);
			commentService.updateComment(comment);
			result.put("status", "success");
			result.put("count_like", comment.getCountLike());
		} catch (Exception e) {
			result.put("status", "failure");
			result.put("msg", "????????????");
		}
		return result;
	}
	
	@ResponseBody
	@ExceptionHandler ({Exception.class})
	public Map<String, Serializable> exceptionHandle(Exception e) {
		Map<String, Serializable> result = new HashMap<>();
		result.put("status", "failure");
		result.put("msg", "????????????");
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.error(e.getMessage());
		logger.error(e.getLocalizedMessage());
		return result;
	}
}
