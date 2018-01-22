/*
Navicat MySQL Data Transfer

Source Server         : MyDB
Source Server Version : 100129
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 100129
File Encoding         : 65001

Date: 2018-01-22 23:11:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `username` char(255) DEFAULT NULL,
  `pass` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES ('asdasd', '');
INSERT INTO `accounts` VALUES ('valsas', 'peos');
INSERT INTO `accounts` VALUES ('stelios', 'peos');

-- ----------------------------
-- Table structure for armor
-- ----------------------------
DROP TABLE IF EXISTS `armor`;
CREATE TABLE `armor` (
  `Name` varchar(255) DEFAULT NULL,
  `Bid` float(10,0) DEFAULT NULL,
  `Buyout` float(255,0) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of armor
-- ----------------------------
INSERT INTO `armor` VALUES ('dragonscale', '10', '1000', 'stelios');
INSERT INTO `armor` VALUES ('poutsoscale', '0', '1', 'valsas');

-- ----------------------------
-- Table structure for trinkets
-- ----------------------------
DROP TABLE IF EXISTS `trinkets`;
CREATE TABLE `trinkets` (
  `Name` varchar(255) DEFAULT NULL,
  `Bid` float(10,0) DEFAULT NULL,
  `Buyout` float(255,0) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of trinkets
-- ----------------------------
INSERT INTO `trinkets` VALUES ('peos', '3', '34', 'stelios');
INSERT INTO `trinkets` VALUES ('teeth', '1', '25', 'valsas');

-- ----------------------------
-- Table structure for weapons
-- ----------------------------
DROP TABLE IF EXISTS `weapons`;
CREATE TABLE `weapons` (
  `Name` varchar(255) DEFAULT NULL,
  `Bid` float(10,0) DEFAULT NULL,
  `Buyout` float(255,0) DEFAULT NULL,
  `user` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of weapons
-- ----------------------------
INSERT INTO `weapons` VALUES ('sword', '1', '5', 'stelios');
INSERT INTO `weapons` VALUES ('gun', '3', '7', 'valsas');
INSERT INTO `weapons` VALUES ('bow', '3', '50', 'stelios');
