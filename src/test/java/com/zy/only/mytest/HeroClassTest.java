package com.zy.only.mytest;

import com.zy.mapper.HeroClassMapper;
import com.zy.pojo.HeroClass;
import com.zy.pojo.Routes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class HeroClassTest {

    @Autowired
    private HeroClassMapper heroClassMapper;

    /**
     * 通过职业序号查询到对应的名称
     */
    @Test
    void getNameById() {
        Integer hcId = 3;
        HeroClass heroClass = heroClassMapper.getNameById(hcId);
        System.out.println("职业序号为" + hcId + "的");
        System.out.println("英文名:" + heroClass.getNameUs());
        System.out.println("中文名:" + heroClass.getNameCn());
    }

    /**
     * 查询全部职业
     */
    @Test
    void getAllName() {
        List<HeroClass> names = heroClassMapper.getAllName();
        names.forEach(System.out::println);
    }

    /**
     * 通过任意字段查询对应职业信息
     * hc_id,name_us,name_cn
     */
    @Test
    void getByAnyway(){
        Integer hcId = 4;
        String nameUs = "support";
        String nameCn = "辅助";

        HashMap map = new HashMap();
        //map.put("hcId",hcId);
        //map.put("nameUs",nameUs);
        map.put("nameCn",nameCn);

        HeroClass heroClass = heroClassMapper.getByAnyway(map);
        System.out.println(heroClass);
    }


    /**
     * 添加分路
     */
    @Test
    void addRoutes(){
        //待添加职业hc_id
        Integer hcId = 7;
        //待添加职业英文名
        String nameUs = "warrior1";
        //待添加职业中文名
        String nameCn = "战士1";

        HeroClass heroClass = new HeroClass();
        heroClass.setHcId(hcId);
        heroClass.setNameUs(nameUs);
        heroClass.setNameCn(nameCn);
        int i = heroClassMapper.addHeroClass(heroClass);
        if (i != 0){
            System.out.println("添加成功");
        }else System.out.println("添加失败");
    }

    /**
     * 修改分路
     * 可以选择修改想要修改的字段，不会影响到其他列
     */
    @Test
    void updateRoutes(){
        //待修改职业hc_id
        Integer hcId = 7;
        //待修改职业英文名
        String nameUs = "warrior2";
        //待修改职业中文名
        String nameCn = "战士2";

        HeroClass heroClass = new HeroClass();
        heroClass.setHcId(hcId);
        heroClass.setNameUs(nameUs);
        //heroClass.setNameCn(nameCn);
        int i = heroClassMapper.updateHeroClass(heroClass);
        if (i != 0){
            System.out.println("修改成功");
        }else System.out.println("修改失败");
    }

    /**
     * 通过职业名删除分路
     */
    @Test
    void deleteRoutesBycName(){
        //待删除职业hc_id
        Integer hcId = 7;

        int i = heroClassMapper.deleteByhcId(hcId);
        if (i != 0){
            System.out.println("删除成功");
        }else System.out.println("删除失败");
    }
}
