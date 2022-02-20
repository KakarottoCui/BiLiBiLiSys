package cilicili.jz2.service;

import cilicili.jz2.pojo.Barrage;

import java.util.List;

public interface IBarrageService {
	void addBarrage (Barrage barrage);
	
	List<Barrage> showBarrages(Integer videoId);
}
