package cilicili.jz2.dao;

import cilicili.jz2.pojo.Barrage;
import cilicili.jz2.pojo.BarrageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BarrageMapper {
    long countByExample(BarrageExample example);

    int deleteByExample(BarrageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    List<Barrage> selectByExample(BarrageExample example);

    Barrage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param ("record") Barrage record, @Param ("example") BarrageExample example);

    int updateByExample(@Param ("record") Barrage record, @Param ("example") BarrageExample example);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);
}