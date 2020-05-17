package com.zy.only.mytest;

import com.zy.mapper.ForcesMapper;
import com.zy.pojo.Forces;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ForcesTest {

    @Autowired
    private ForcesMapper forcesMapper;

    /**
     * 查询全部势力
     */
    @Test
    void queryAllForces() {
        List<Forces> forces = forcesMapper.queryAllForces();
        forces.forEach(System.out::println);
    }

    /**
     * 通过f_id查询到势力，并输出其势力名
     */
    @Test
    void getForceByFid() {
        Integer fid = 4;
        Forces force = forcesMapper.getForceByFid(fid);
        System.out.println("序号为" + fid + "的势力名为:" + force.getFName());
    }

    /**
     * 添加势力
     */
    @Test
    void addForce(){
        Forces force = new Forces();
        force.setFId(8);
        force.setFName("皮尔特沃夫");
        int i = forcesMapper.addForce(force);
        if (i != 0){
            System.out.println("添加成功");
        }else System.out.println("添加失败");
    }

    /**
     * 通过势力名得到势力信息
     */
    @Test
    void getForcesByfName(){
        String force = "弗雷尔卓德";
        Forces forces = forcesMapper.getForcesByfName(force);
        System.out.println(forces);
    }

    /**
     * 修改势力名，通过f_id
     */
    @Test
    void updateForces(){
        //待修改的f_id
        Integer fId = 8;
        //待修改的f_name
        String fName = "恕瑞玛";

        Forces forces = new Forces();
        forces.setFId(fId);
        forces.setFName(fName);
        int i = forcesMapper.updateForces(forces);
        if (i != 0){
            System.out.println("修改成功");
        }else System.out.println("修改失败");
    }

    /**
     * 通过f_id删除势力
     */
    @Test
    void deleteByfId(){
        //待删除f_id
        Integer fId = 8;
        int i = forcesMapper.deleteByfId(fId);
        if (i != 0){
            System.out.println("删除成功");
        }else System.out.println("删除失败");
    }

}
