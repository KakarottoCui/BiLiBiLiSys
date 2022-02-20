package cilicili.jz2.controller;

import cilicili.jz2.pojo.Video;

import java.io.Serializable;
import java.util.Map;

public interface IVideoController {
	Map<String, Serializable> findVideoById(Integer id);
	
	Map<String, Serializable> addVideo(Video video, String token);
	
	Map<String, Serializable> playVideo(Integer id);
	
	Map<String, Serializable> likeVideo(Integer id);
	
	Map<String, Serializable> showVideos(Integer offset);
	
	Map<String, Serializable> findVideos(Integer offset, String q);
}
