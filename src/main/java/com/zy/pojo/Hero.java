package com.zy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    //英雄名
    private String name;
    //性别，0男 1女
    private Integer gender;

    //势力编号
    private Integer force;
    //非数据库字段，通过势力编号可以查询到的势力
    private String forces;

    //技能
    private String skills;

    //职业编号
    private Integer heroClassId;
    //非数据库字段，通过职业编号可以查询到的职业
    private String heroClass;

}
