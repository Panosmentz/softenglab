/*
Navicat MySQL Data Transfer

Source Server         : MyDB
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-01-29 23:55:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `accounts`
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `username` char(255) NOT NULL,
  `pass` char(255) NOT NULL,
  `balance` float(255,0) NOT NULL,
  `adflg` int(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES ('stelios', 'peos', '1000', '0');
INSERT INTO `accounts` VALUES ('panos', 'peos', '641', '0');
INSERT INTO `accounts` VALUES ('vlas', '1234', '1000', '0');
INSERT INTO `accounts` VALUES ('admin', 'root', '0', '1');
INSERT INTO `accounts` VALUES ('lol', 'lol', '1000', '0');
INSERT INTO `accounts` VALUES ('valsas', 'peos', '1000', '0');

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `Name` varchar(255) NOT NULL,
  `Bid` float(255,0) NOT NULL,
  `Buyout` float(255,0) NOT NULL,
  `user` varchar(255) NOT NULL,
  `EndBid` float(255,0) NOT NULL,
  `Type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('sword', '19', '100', 'stelios', '10', 'Weapons');
INSERT INTO `products` VALUES ('teeth', '3', '300', 'stelios', '30', 'Trinkets');
INSERT INTO `products` VALUES ('o poutsos mou', '100', '100', 'valsas', '50', 'Weapons');
