/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.29 : Database - my_mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`my_mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `my_mybatis`;

/*Table structure for table `forces` */

DROP TABLE IF EXISTS `forces`;

CREATE TABLE `forces` (
  `f_id` int(10) NOT NULL COMMENT '势力编号',
  `f_name` varchar(20) DEFAULT NULL COMMENT '势力名',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='势力';

/*Data for the table `forces` */

insert  into `forces`(`f_id`,`f_name`) values (1,'德玛西亚');
insert  into `forces`(`f_id`,`f_name`) values (2,'诺克萨斯');
insert  into `forces`(`f_id`,`f_name`) values (3,'弗雷尔卓德');
insert  into `forces`(`f_id`,`f_name`) values (4,'暗影岛');
insert  into `forces`(`f_id`,`f_name`) values (5,'比尔吉沃特');
insert  into `forces`(`f_id`,`f_name`) values (6,'祖安');
insert  into `forces`(`f_id`,`f_name`) values (7,'艾欧尼亚');

/*Table structure for table `hero` */

DROP TABLE IF EXISTS `hero`;

CREATE TABLE `hero` (
  `name` varchar(20) NOT NULL COMMENT '名字',
  `gender` int(5) NOT NULL COMMENT '性别：1女 0男',
  `force` int(5) DEFAULT NULL COMMENT '势力',
  `skills` varchar(20) DEFAULT NULL COMMENT '技能',
  `hero_class_id` int(5) DEFAULT NULL COMMENT '职业',
  PRIMARY KEY (`name`),
  KEY `fid` (`force`),
  KEY `cid` (`hero_class_id`),
  CONSTRAINT `cid` FOREIGN KEY (`hero_class_id`) REFERENCES `hero_class` (`hc_id`),
  CONSTRAINT `fid` FOREIGN KEY (`force`) REFERENCES `forces` (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英雄';

/*Data for the table `hero` */

insert  into `hero`(`name`,`gender`,`force`,`skills`,`hero_class_id`) values ('嘉文四世',0,1,'天崩地裂',6);
insert  into `hero`(`name`,`gender`,`force`,`skills`,`hero_class_id`) values ('德莱厄斯',0,2,'诺克萨斯断头台',6);
insert  into `hero`(`name`,`gender`,`force`,`skills`,`hero_class_id`) values ('泰隆',0,2,'暗影突袭',3);
insert  into `hero`(`name`,`gender`,`force`,`skills`,`hero_class_id`) values ('盖亚',1,3,'诺克萨斯',5);
insert  into `hero`(`name`,`gender`,`force`,`skills`,`hero_class_id`) values ('盖伦',0,1,'德玛西亚正义',5);
insert  into `hero`(`name`,`gender`,`force`,`skills`,`hero_class_id`) values ('艾希',1,3,'魔法水晶箭',1);
insert  into `hero`(`name`,`gender`,`force`,`skills`,`hero_class_id`) values ('锤石',0,4,'幽魂监牢',4);

/*Table structure for table `hero_class` */

DROP TABLE IF EXISTS `hero_class`;

CREATE TABLE `hero_class` (
  `hc_id` int(5) NOT NULL COMMENT '职业序号',
  `name_us` varchar(20) DEFAULT NULL COMMENT '职业名(英文)',
  `name_cn` varchar(20) DEFAULT NULL COMMENT '职业名(中文)',
  PRIMARY KEY (`hc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='英雄职业';

/*Data for the table `hero_class` */

insert  into `hero_class`(`hc_id`,`name_us`,`name_cn`) values (1,'adc','射手');
insert  into `hero_class`(`hc_id`,`name_us`,`name_cn`) values (2,'ap','法师');
insert  into `hero_class`(`hc_id`,`name_us`,`name_cn`) values (3,'assassin','刺客');
insert  into `hero_class`(`hc_id`,`name_us`,`name_cn`) values (4,'support','辅助');
insert  into `hero_class`(`hc_id`,`name_us`,`name_cn`) values (5,'tank','坦克');
insert  into `hero_class`(`hc_id`,`name_us`,`name_cn`) values (6,'warrior','战士');

/*Table structure for table `routes` */

DROP TABLE IF EXISTS `routes`;

CREATE TABLE `routes` (
  `c_name` varchar(10) NOT NULL COMMENT '职业名',
  `route` varchar(10) DEFAULT NULL COMMENT '分路',
  PRIMARY KEY (`c_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分路';

/*Data for the table `routes` */

insert  into `routes`(`c_name`,`route`) values ('刺客','中路');
insert  into `routes`(`c_name`,`route`) values ('坦克','上路');
insert  into `routes`(`c_name`,`route`) values ('射手','下路');
insert  into `routes`(`c_name`,`route`) values ('战士','上路');
insert  into `routes`(`c_name`,`route`) values ('打野','野区');
insert  into `routes`(`c_name`,`route`) values ('法师','中路');
insert  into `routes`(`c_name`,`route`) values ('辅助','下路');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
