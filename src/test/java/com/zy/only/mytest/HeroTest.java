package com.zy.only.mytest;

import com.zy.mapper.ForcesMapper;
import com.zy.mapper.HeroClassMapper;
import com.zy.mapper.HeroMapper;
import com.zy.mapper.RoutesMapper;
import com.zy.pojo.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class HeroTest {

    @Autowired
    private HeroMapper heroMapper;
    @Autowired
    private RoutesMapper routesMapper;
    @Autowired
    private ForcesMapper forcesMapper;
    @Autowired
    private HeroClassMapper heroClassMapper;

    /**
     * 查询全部英雄
     */
    @Test
    void queryAllHero() {
        List<Hero> heroes = heroMapper.queryAllHero();
        heroes.forEach(System.out::println);
    }

    /**
     * 通过英雄名查询到该英雄的全部信息
     */
    @Test
    void getHeroByName() {
        String name = "盖伦";
        Hero hero = heroMapper.getHeroByName(name);
        System.out.println(hero);

        //通过得到的英雄信息的职业名，查询routes表得到分路
        String route = routesMapper.getRouteBycName(hero.getHeroClass());
        System.out.println("分路:"+route);
    }

    /**
     * 添加一个英雄
     * 势力编号 通过 势力名 查询forces表得到
     * 职业编号 通过 职业名 查询hero_class表得到
     */
    @Test
    void addHero(){
        //待添加的英雄名
        String name = "嘉文四世";
        //待添加的性别
        Integer gender = 0;
        //待添加的技能名
        String skills = "天崩地裂";
        //待添加的势力名
        String force = "德玛西亚";
        //待添加的职业名（英文）
        String heroClassUs = "warrior";

        Hero hero = new Hero();
        hero.setName(name);
        hero.setGender(gender);
        hero.setSkills(skills);

        //通过势力名，查询forces表得到其对应f_id
        Integer fId = forcesMapper.getForcesByfName(force).getFId();
        hero.setForce(fId);

        //通过职业名，查询hero_class表得到其对应hc_id
        HashMap map = new HashMap();
        map.put("nameUs",heroClassUs);
        Integer hcId = heroClassMapper.getByAnyway(map).getHcId();
        hero.setHeroClassId(hcId);

        int i = heroMapper.addHero(hero);
        if (i != 0){
            System.out.println("添加成功");
        }else System.out.println("添加失败");
    }

    /**
     * 修改一个英雄信息
     * 势力编号 通过 势力名 查询forces表得到
     * 职业编号 通过 职业名 查询hero_class表得到
     */
    @Test
    void updateByName(){
        //待修改的英雄名
        String name = "布隆";
        //待修改的性别
        Integer gender = 0;
        //待修改的技能名
        String skills = "冰川裂隙";
        //待修改的势力名
        String force = "弗雷尔卓德";
        //待修改的职业名（英文）
        String heroClassUs = "support";

        Hero hero = new Hero();
        hero.setName(name);
        hero.setGender(gender);
        hero.setSkills(skills);

        //通过势力名，查询forces表得到其对应f_id
        Integer fId = forcesMapper.getForcesByfName(force).getFId();
        hero.setForce(fId);

        //通过职业名，查询hero_class表得到其对应hc_id
        HashMap map = new HashMap();
        map.put("nameUs",heroClassUs);
        Integer hcId = heroClassMapper.getByAnyway(map).getHcId();
        hero.setHeroClassId(hcId);

        int i = heroMapper.updateByName(hero);
        if (i != 0){
            System.out.println("修改成功");
        }else System.out.println("修改失败");
    }

    /**
     * 通过英雄名，删除英雄
     */
    @Test
    void deleteByName(){
        //待修改的英雄名
        String name = "布隆";
        int i = heroMapper.deleteByName(name);
        if (i != 0){
            System.out.println("删除成功");
        }else System.out.println("删除失败");
    }

    /*@Test
    void getHeroVague(){
        String name = "盖";
        List<Hero> heros = heroMapper.getHeroVague(name);
        heros.forEach(System.out::println);
    }*/

    @Test
    void getHeroVague(){
        String name = "盖";
        String skills = "天崩";
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("skills",skills);
        List<Hero> heros = heroMapper.getHeroVague(map);
        heros.forEach(System.out::println);
    }

}
