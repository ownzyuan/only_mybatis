**Only-Mybatis**

## 1、概述

springboot创建项目

使用mybatis 进行联表、模糊查询，基本的CRUD，动态SQL

一共有4张表

### hero（英雄）

![image-20200517153026446](D:\Program Files\Typora\image_user\image-20200517153026446.png)

#### name（String）

英雄名，**主键**

#### force（int）

用于在forces表中查询对应势力

#### hero_class_id（int）

用于在hero_class表中查询对应职业



### forces（势力）

![image-20200517153348268](D:\Program Files\Typora\image_user\image-20200517153348268.png)

#### f_id（int）

势力编号，**主键**，用于查询对应势力



### hero_class（职业）

![image-20200517153506092](D:\Program Files\Typora\image_user\image-20200517153506092.png)

#### hc_id（idnt）

职业编号，**主键**，用于查询对应职业



### routes（分路）

![image-20200517153557724](D:\Program Files\Typora\image_user\image-20200517153557724.png)

#### c_name（String）

职业名，**主键**，用于查询该职业对应分路



## 2、测试亮点

### 查询全部英雄

​	queryAllHero----联表查询hero、forces、hero_class

### 通过英雄名查询到该英雄的全部信息

​	getHeroByName---联表查询hero、forces、hero_class

### 添加英雄

​	addHero---添加英雄属性时势力（forrce），职业（hero_class）在英雄表中都是int类型

​	因此会在forces，hero_class_id表中查到对应编号再录入英雄表中

### 模糊查询英雄

​	getHeroVague---只需要部分姓名或是技能名就能查到对应英雄信息

