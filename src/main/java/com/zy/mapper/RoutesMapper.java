package com.zy.mapper;

import com.zy.pojo.Routes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoutesMapper {

    /**
     * 通过职业名查询分路
     * @param cName
     * @return String
     */
    String getRouteBycName(String cName);

    /**
     * 查询全部分路
     * @return Routes
     */
    List<Routes> getAllRoutes();

    /**
     * 添加分路
     * @param routes
     * @return int 方便判断，0失败，1成功
     */
    int addRoutes(Routes routes);

    /**
     * 修改分路
     * @param routes
     * @return int 方便判断，0失败，1成功
     */
    int updateRoutes(Routes routes);

    /**
     * 通过职业名删除分路
     * @param cName
     * @return int 方便判断，0失败，1成功
     */
    int deleteRoutesBycName(String cName);

}
