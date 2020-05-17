package com.zy.mapper;

import com.zy.pojo.Forces;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ForcesMapper {

    /**
     * 查询全部势力信息
     * @return Forces
     */
    List<Forces> queryAllForces();

    /**
     * 通过f_id查询到势力
     * @param fId
     * @return Forces
     */
    Forces getForceByFid(Integer fId);

    /**
     * 添加势力
     * @param forces
     * @return int 方便判断，0失败，1成功
     */
    int addForce(Forces forces);

    /**
     * 通过f_name查询势力
     * @param fName
     * @return Forces
     */
    Forces getForcesByfName(String fName);

    /**
     * 修改势力名，通过f_id
     * @param forces
     * @return int 方便判断，0失败，1成功
     */
    int updateForces(Forces forces);

    /**
     * 通过f_id删除势力
     * @param fId
     * @return int 方便判断，0失败，1成功
     */
    int deleteByfId(Integer fId);

}
