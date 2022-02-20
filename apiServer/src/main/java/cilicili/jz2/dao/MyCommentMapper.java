package cilicili.jz2.dao;

import cilicili.jz2.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyCommentMapper {
	Comment findById(@Param ("id") Integer id);
	
	List<Comment> showComments(@Param ("id") int videoId);
}
