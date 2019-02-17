/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : db_society

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-02-17 17:01:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_admin`
-- ----------------------------
DROP TABLE IF EXISTS `s_admin`;
CREATE TABLE `s_admin` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 NOT NULL,
  `createday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_admin
-- ----------------------------
INSERT INTO `s_admin` VALUES ('1', 'admin', '1', '2018-12-27 12:36:46');

-- ----------------------------
-- Table structure for `s_courses`
-- ----------------------------
DROP TABLE IF EXISTS `s_courses`;
CREATE TABLE `s_courses` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 NOT NULL,
  `teacher_id` int(4) NOT NULL,
  `department_id` int(4) NOT NULL,
  `max_user` int(8) NOT NULL,
  `selected_man` int(8) NOT NULL DEFAULT '0',
  `info` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `date` varchar(32) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_foreign` (`teacher_id`),
  KEY `department_foreign` (`department_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_courses
-- ----------------------------
INSERT INTO `s_courses` VALUES ('1', '智能小车', '1', '2', '60', '2', 'test', '每周日下午2点吧');
INSERT INTO `s_courses` VALUES ('2', 'office办公软件', '3', '1', '90', '0', '熟练使用office办公软件基础操作', '每周日下午2点般');
INSERT INTO `s_courses` VALUES ('4', 'C语言入门', '3', '1', '30', '0', '该课程为C语言入门级级教程', '每周六下午2点');

-- ----------------------------
-- Table structure for `s_departmentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `s_departmentinfo`;
CREATE TABLE `s_departmentinfo` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 NOT NULL,
  `info` text CHARACTER SET utf8 NOT NULL,
  `createday` char(12) CHARACTER SET utf8 NOT NULL,
  `master` int(4) NOT NULL,
  `contact` varchar(32) CHARACTER SET utf8 NOT NULL,
  `modification_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `master_foreign` (`master`),
  CONSTRAINT `master_foreign` FOREIGN KEY (`master`) REFERENCES `s_manager` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_departmentinfo
-- ----------------------------
INSERT INTO `s_departmentinfo` VALUES ('1', '软件部', '这是软件部', '2017-12-12', '1', '22@qq.com', '2019-01-12 15:31:58');
INSERT INTO `s_departmentinfo` VALUES ('2', '硬件部', 'test', '2017-12-1', '3', '12@qq.com', '2019-01-11 16:17:50');

-- ----------------------------
-- Table structure for `s_manager`
-- ----------------------------
DROP TABLE IF EXISTS `s_manager`;
CREATE TABLE `s_manager` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 NOT NULL,
  `title` varchar(32) CHARACTER SET utf8 NOT NULL,
  `contact_infomation` varchar(32) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_manager
-- ----------------------------
INSERT INTO `s_manager` VALUES ('1', '张三', '1', '会长', '22@qq.com');
INSERT INTO `s_manager` VALUES ('3', '李四', '1', '副会长', '11@163.com');
INSERT INTO `s_manager` VALUES ('4', '王五', '1', '软件部部长', '12@luobo.gq');
INSERT INTO `s_manager` VALUES ('5', '王小二', '1', '软件部副部长', '22@luobo.gq');

-- ----------------------------
-- Table structure for `s_members`
-- ----------------------------
DROP TABLE IF EXISTS `s_members`;
CREATE TABLE `s_members` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 NOT NULL,
  `sex` varchar(4) CHARACTER SET utf8 NOT NULL,
  `age` int(4) NOT NULL,
  `department_id` int(4) NOT NULL,
  `contact` varchar(32) CHARACTER SET utf8 NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `s_departmentinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_members
-- ----------------------------
INSERT INTO `s_members` VALUES ('1', '丽丽', '女', '22', '1', '112', '11');
INSERT INTO `s_members` VALUES ('4', '李斯', '男', '23', '1', '123', '1');
INSERT INTO `s_members` VALUES ('5', '赵兴', '男', '21', '2', '112', '1');
INSERT INTO `s_members` VALUES ('6', '威威', '女', '21', '2', '113', '1');

-- ----------------------------
-- Table structure for `s_selectcourse`
-- ----------------------------
DROP TABLE IF EXISTS `s_selectcourse`;
CREATE TABLE `s_selectcourse` (
  `member_id` int(4) NOT NULL,
  `course_id` int(4) NOT NULL,
  `department_id` int(4) NOT NULL,
  `id` int(4) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `course_foreign` (`course_id`),
  KEY `teacher_foreign` (`department_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of s_selectcourse
-- ----------------------------
INSERT INTO `s_selectcourse` VALUES ('6', '1', '2', '8');
INSERT INTO `s_selectcourse` VALUES ('5', '1', '2', '7');
