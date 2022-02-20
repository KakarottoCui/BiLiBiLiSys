package cilicili.jz2.service.impl;

import cilicili.jz2.dao.BarrageMapper;
import cilicili.jz2.pojo.Barrage;
import cilicili.jz2.pojo.BarrageExample;
import cilicili.jz2.service.IBarrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service ("barrageService")
public class BarrageServiceImpl implements IBarrageService {
	private final BarrageMapper barrageMapper;
	
	@Autowired
	public BarrageServiceImpl(BarrageMapper barrageMapper) {
		this.barrageMapper = barrageMapper;
	}
	
	@Override
	public void addBarrage(Barrage barrage) {
		barrageMapper.insert(barrage);
	}
	
	@Override
	public List<Barrage> showBarrages(Integer videoId) {
		BarrageExample barrageExample = new BarrageExample();
		BarrageExample.Criteria criteria = barrageExample.createCriteria();
		criteria.andVideoIdEqualTo(videoId);
		return barrageMapper.selectByExample(barrageExample);
	}
}
