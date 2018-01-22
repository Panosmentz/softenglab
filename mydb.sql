/*
Navicat MySQL Data Transfer

Source Server         : MyDB
Source Server Version : 100129
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 100129
File Encoding         : 65001

Date: 2018-01-22 22:56:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
`username`  char(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`pass`  char(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of accounts
-- ----------------------------
BEGIN;
INSERT INTO `accounts` VALUES ('asdasd', ''), ('valsas', 'peos'), ('stelios', 'peos');
COMMIT;

-- ----------------------------
-- Table structure for armor
-- ----------------------------
DROP TABLE IF EXISTS `armor`;
CREATE TABLE `armor` (
`Name`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`Bid`  float(10,0) NULL DEFAULT NULL ,
`Buyout`  float(255,0) NULL DEFAULT NULL ,
`user`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of armor
-- ----------------------------
BEGIN;
INSERT INTO `armor` VALUES ('dragonscale', '10', '1000', 'stelios'), ('poutsoscale', '0', '1', 'valsas');
COMMIT;

-- ----------------------------
-- Table structure for trinkets
-- ----------------------------
DROP TABLE IF EXISTS `trinkets`;
CREATE TABLE `trinkets` (
`Name`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`Bid`  float(10,0) NULL DEFAULT NULL ,
`Buyout`  float(255,0) NULL DEFAULT NULL ,
`user`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of trinkets
-- ----------------------------
BEGIN;
INSERT INTO `trinkets` VALUES ('peos', '3', '34', 'stelios'), ('teeth', '1', '25', 'valsas');
COMMIT;

-- ----------------------------
-- Table structure for weapons
-- ----------------------------
DROP TABLE IF EXISTS `weapons`;
CREATE TABLE `weapons` (
`Name`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`Bid`  float(10,0) NULL DEFAULT NULL ,
`Buyout`  float(255,0) NULL DEFAULT NULL ,
`user`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of weapons
-- ----------------------------
BEGIN;
INSERT INTO `weapons` VALUES ('sword', '1', '5', 'stelios'), ('gun', '3', '7', 'valsas'), ('bow', '3', '50', 'stelios');
COMMIT;
