/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost
 Source Database       : manner

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : utf-8

 Date: 12/04/2014 22:59:44 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gs2o4yp49kajapsp2n5nbi6sa` (`owner_id`),
  CONSTRAINT `FK_gs2o4yp49kajapsp2n5nbi6sa` FOREIGN KEY (`owner_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_group`
-- ----------------------------
BEGIN;
INSERT INTO `t_group` VALUES ('1', '2014-12-04 22:21:24', 'Pioneer', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_group_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_group_user`;
CREATE TABLE `t_group_user` (
  `group_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  KEY `FK_k698jqcavehu5efbymmk15cpd` (`user_id`),
  KEY `FK_o0t10w177nfmw4ao2oteqmpp1` (`group_id`),
  CONSTRAINT `FK_k698jqcavehu5efbymmk15cpd` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_o0t10w177nfmw4ao2oteqmpp1` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_group_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_group_user` VALUES ('1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `percentage` int(11) NOT NULL,
  `priority` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `created_by_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `last_modified_by_id` bigint(20) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_a1btqirbh4bfq86kxy8ngjlf5` (`created_by_id`),
  KEY `FK_d2ln6ci0ieqf68ldhfgjfghf1` (`group_id`),
  KEY `FK_n0a8lpfgwsdrv3708r9tlo2ra` (`last_modified_by_id`),
  KEY `FK_es8okxw95xalbqt0186iupg3n` (`owner_id`),
  CONSTRAINT `FK_a1btqirbh4bfq86kxy8ngjlf5` FOREIGN KEY (`created_by_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_d2ln6ci0ieqf68ldhfgjfghf1` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`id`),
  CONSTRAINT `FK_es8okxw95xalbqt0186iupg3n` FOREIGN KEY (`owner_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_n0a8lpfgwsdrv3708r9tlo2ra` FOREIGN KEY (`last_modified_by_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_item`
-- ----------------------------
BEGIN;
INSERT INTO `t_item` VALUES ('1', 'task1', '2014-12-04 22:22:48', '2014-12-04 00:00:00', '2014-12-04 22:22:48', '0', '2', 'note1', '0', '1', '1', '1', '1'), ('2', 'task2', '2014-12-04 22:23:22', '2014-12-05 00:00:00', '2014-12-04 22:23:22', '50', '3', 'note2', '1', '1', '1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `last_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `role` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_index` (`username`),
  UNIQUE KEY `email_index` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', 'jason@jason.com', 'Yao', 'Xiao', '$2a$10$8dq6XJjGQGkjgxydrF2PyODeTLkno5/LQA1mLxXZ8B0HctUYVScem', '1', 'jason'), ('2', 'john@john.com', 'John', 'Doe', '$2a$10$LdtDp/dVCaOyq35V8JDyEO/PuiGC3/1xz4NDsey2x27R.3CtpJid2', '1', 'john'), ('3', 'kei@kei.com', 'Kei', 'Sang', '$2a$10$y15vGMedeGTyVoVw2VUKHeVz3ZUoaNT.fs8ZLVPvoWKV42kV/eqWC', '1', 'kei'), ('4', 'dino@dino.com', 'Dino', 'Huang', '$2a$10$kePpy0gXIvgCKkqf3KIYquxT52JSNhgvkGgCH5UpIBjn6XGtTaAMO', '1', 'dino');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
