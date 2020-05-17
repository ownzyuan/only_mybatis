package com.zy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroClass {

    //职业编号
    private Integer hcId;
    //职业英文名
    private String nameUs;
    //职业中文名
    private String nameCn;

}
