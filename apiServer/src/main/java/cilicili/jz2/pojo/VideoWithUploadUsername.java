package cilicili.jz2.pojo;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class VideoWithUploadUsername extends Video implements Serializable {
	private String uploadUsername;
	
	public VideoWithUploadUsername(Integer id, String title, String url, Integer uploadUserid, ZonedDateTime uploadTime, Integer countPlay, Integer countLike, String picUrl, String description) {
		super(id, title, url, uploadUserid, uploadTime, countPlay, countLike, picUrl, description);
	}
	
	public VideoWithUploadUsername() {
		super();
	}
	
	public String getUploadUsername() {
		return uploadUsername;
	}
	
	public void setUploadUsername(String uploadUsername) {
		this.uploadUsername = uploadUsername;
	}
}
