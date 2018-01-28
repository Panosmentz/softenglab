/*
Navicat MySQL Data Transfer

Source Server         : MyDB
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-01-28 20:26:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `accounts`
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
INSERT INTO `accounts` VALUES ('panos', 'peos');
INSERT INTO `accounts` VALUES ('vlas', '1234');

-- ----------------------------
-- Table structure for `adminaccounts`
-- ----------------------------
DROP TABLE IF EXISTS `adminaccounts`;
CREATE TABLE `adminaccounts` (
  `adName` varchar(255) NOT NULL,
  `adPass` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of adminaccounts
-- ----------------------------
INSERT INTO `adminaccounts` VALUES ('admin', 'root');
INSERT INTO `adminaccounts` VALUES ('valsasad', 'lalala12');

-- ----------------------------
-- Table structure for `armor`
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
INSERT INTO `armor` VALUES ('brigadine', '3000', '10000', 'vlas');
INSERT INTO `armor` VALUES ('exosuit', '1200', '10000', 'stelios');

-- ----------------------------
-- Table structure for `trinkets`
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
INSERT INTO `trinkets` VALUES ('locket', '2', '20', 'stelios');

-- ----------------------------
-- Table structure for `weapons`
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
INSERT INTO `weapons` VALUES ('sword', '5', '5', 'stelios');
INSERT INTO `weapons` VALUES ('bow', '3', '50', 'stelios');
INSERT INTO `weapons` VALUES ('shotgun', '3', '60', 'panos');
INSERT INTO `weapons` VALUES ('valsa_ball', '1', '10', 'valsas');
INSERT INTO `weapons` VALUES ('valsa ball', '1', '10', 'valsas');
