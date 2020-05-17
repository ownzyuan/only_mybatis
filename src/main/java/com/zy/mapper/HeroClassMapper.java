package com.zy.mapper;

import com.zy.pojo.HeroClass;
import com.zy.pojo.Routes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface HeroClassMapper {

    /**
     * 通过职业序号查询到对应的名称
     * @param hcId
     * @return HeroClass
     */
    HeroClass getNameById(Integer hcId);

    /**
     * 查询全部职业
     * @return HeroClass
     */
    List<HeroClass> getAllName();

    /**
     * 通过任意字段查询对应职业信息
     * @param map
     * @return HeroClass
     */
    HeroClass getByAnyway(Map map);

    /**
     * 添加职业
     * @param heroClass
     * @return int 方便判断，0失败，1成功
     */
    int addHeroClass(HeroClass heroClass);

    /**
     * 修改职业
     * @param heroClass
     * @return int 方便判断，0失败，1成功
     */
    int updateHeroClass(HeroClass heroClass);

    /**
     * 通过职业编号删除职业
     * @param hcId
     * @return int 方便判断，0失败，1成功
     */
    int deleteByhcId(Integer hcId);

}
