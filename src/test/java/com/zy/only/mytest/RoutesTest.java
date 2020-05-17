package com.zy.only.mytest;

import com.zy.mapper.RoutesMapper;
import com.zy.pojo.Routes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoutesTest {

    @Autowired
    private RoutesMapper routesMapper;

    /**
     * 通过通过职业名查询分路
     */
    @Test
    void getRouteBycName() {
        String c_name = "刺客";
        String route = routesMapper.getRouteBycName(c_name);
        System.out.println(route);
    }

    /**
     * 查询全部分路
     */
    @Test
    void getAllRoutes(){
        List<Routes> allRoutes = routesMapper.getAllRoutes();
        allRoutes.forEach(System.out::println);
    }

    /**
     * 添加分路
     */
    @Test
    void addRoutes(){
        //待添加职业名
        String cName = "打野";
        //待添加分路名
        String route = "野区";

        Routes routes = new Routes();
        routes.setCName(cName);
        routes.setRoute(route);
        int i = routesMapper.addRoutes(routes);
        if (i != 0){
            System.out.println("添加成功");
        }else System.out.println("添加失败");
    }

    /**
     * 修改分路
     */
    @Test
    void updateRoutes(){
        //待修改职业名
        String cName = "打野";
        //待修改分路名
        String route = "野区";

        Routes routes = new Routes();
        routes.setCName(cName);
        routes.setRoute(route);
        int i = routesMapper.updateRoutes(routes);
        if (i != 0){
            System.out.println("修改成功");
        }else System.out.println("修改失败");
    }

    /**
     * 通过职业名删除分路
     */
    @Test
    void deleteRoutesBycName(){
        //待删除职业名
        String cName = "打野";

        int i = routesMapper.deleteRoutesBycName(cName);
        if (i != 0){
            System.out.println("删除成功");
        }else System.out.println("删除失败");
    }

}
