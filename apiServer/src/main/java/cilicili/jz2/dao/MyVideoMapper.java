package cilicili.jz2.dao;

import cilicili.jz2.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyVideoMapper {
	Video findById(@Param ("id") Integer id);
	
	Video findByUrl(@Param ("url") String url);
	
	List<Video> findAllVideos();
	
	List<Video> queryVideo(@Param ("keyword") String keyword);
}
