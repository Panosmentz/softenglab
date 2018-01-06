/*
Navicat MySQL Data Transfer

Source Server         : MyDB
Source Server Version : 100129
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 100129
File Encoding         : 65001

Date: 2018-01-06 20:21:36
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
INSERT INTO `accounts` VALUES ('asdasd', '');
COMMIT;

-- ----------------------------
-- Table structure for myauctions
-- ----------------------------
DROP TABLE IF EXISTS `myauctions`;
CREATE TABLE `myauctions` (
`PName`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`PPrice`  int(10) NULL DEFAULT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of myauctions
-- ----------------------------
BEGIN;
INSERT INTO `myauctions` VALUES ('Peos', '10');
COMMIT;
