package cilicili.jz2.service.impl;

import cilicili.jz2.dao.CommentMapper;
import cilicili.jz2.dao.MyCommentMapper;
import cilicili.jz2.pojo.Comment;
import cilicili.jz2.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements ICommentService {
	private final CommentMapper commentMapper;
	private final MyCommentMapper myCommentMapper;
	
	@Autowired
	public CommentServiceImpl(CommentMapper commentMapper, MyCommentMapper myCommentMapper) {
		this.commentMapper = commentMapper;
		this.myCommentMapper = myCommentMapper;
	}
	
	@Override
	public Comment findCommentById(Integer id) {
		return myCommentMapper.findById(id);
	}
	
	@Override
	public void addComment(Comment comment) {
		commentMapper.insert(comment);
	}
	
	@Override
	public void deleteComment(Integer id) {
		commentMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void updateComment(Comment comment) {
		commentMapper.updateByPrimaryKeySelective(comment);
	}
	
	@Override
	public List<Comment> showComments(Integer videoId) {
		return myCommentMapper.showComments(videoId);
	}
}
