package cilicili.jz2.service;

import cilicili.jz2.pojo.Comment;

import java.util.List;

public interface ICommentService {
	Comment findCommentById(Integer id);
	
	void addComment(Comment comment);
	
	void deleteComment(Integer id);
	
	void updateComment(Comment comment);
	
	List<Comment> showComments(Integer videoId);
}
