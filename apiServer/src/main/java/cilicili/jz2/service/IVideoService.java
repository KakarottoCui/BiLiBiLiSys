package cilicili.jz2.service;

import cilicili.jz2.pojo.Video;

import java.util.List;

public interface IVideoService {
	Video findVideoById(Integer id);
	
	Video findVideoByUrl(String url);
	
	void addVideo(Video video);
	
	void updateVideo(Video video);
	
	List<Video> showVideos();
	
	List<Video> queryVideos(String keyword);
}
