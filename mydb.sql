/*
Navicat MySQL Data Transfer

Source Server         : MyDB
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-01-30 18:34:37
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
INSERT INTO `accounts` VALUES ('admin', 'root', '0', '1');
INSERT INTO `accounts` VALUES ('stelios', 'stelios', '700', '0');
INSERT INTO `accounts` VALUES ('valsas', 'valsas', '1000', '0');
INSERT INTO `accounts` VALUES ('panos', 'panos', '1000', '0');

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
INSERT INTO `products` VALUES ('breastplate', '50', '500', 'valsas', '100', 'Armor');
INSERT INTO `products` VALUES ('necklace', '3', '100', 'panos', '30', 'Trinkets');
INSERT INTO `products` VALUES ('sword', '1', '100', 'stelios', '10', 'Weapons');
INSERT INTO `products` VALUES ('brigadine', '100', '750', 'valsas', '550', 'Armor');
INSERT INTO `products` VALUES ('Family Heirloom', '55', '500', 'stelios', '200', 'Trinkets');
