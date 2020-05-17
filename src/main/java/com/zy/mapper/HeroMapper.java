package com.zy.mapper;

import com.zy.pojo.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HeroMapper {

    /**
     * 查询全部英雄数据
     * @return List<Hero>
     */
    List<Hero> queryAllHero();

    /**
     * 通过英雄名查询到该英雄的全部信息
     * @param name
     * @return Hero
     */
    Hero getHeroByName(String name);

    /**
     * 添加一个英雄
     * @param hero
     * @return int 方便判断，0失败，1成功
     */
    int addHero(Hero hero);

    /**
     * 通过英雄名，修改英雄的信息
     * @param hero
     * @return int 方便判断，0失败，1成功
     */
    int updateByName(Hero hero);

    /**
     * 通过英雄名，删除英雄
     * @param name
     * @return int 方便判断，0失败，1成功
     */
    int deleteByName(String name);

    //List<Hero> getHeroVague(String name);
    List<Hero> getHeroVague(Map map);

}
