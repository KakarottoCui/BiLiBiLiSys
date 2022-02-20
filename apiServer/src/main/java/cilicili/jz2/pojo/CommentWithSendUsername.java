package cilicili.jz2.pojo;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class CommentWithSendUsername extends Comment implements Serializable {
	private String sendUsername;
	
	public CommentWithSendUsername(Integer id, Integer videoId, Integer userId, String content, ZonedDateTime sendtime, Integer countLike) {
		super(id, videoId, userId, content, sendtime, countLike);
	}
	
	public CommentWithSendUsername() {
		super();
	}
	
	public String getUploadUsername() {
		return sendUsername;
	}
	
	public void setUploadUsername(String sendUsername) {
		this.sendUsername = sendUsername;
	}
}
