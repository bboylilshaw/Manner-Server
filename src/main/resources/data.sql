/*
 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 50616
 Source Host           : localhost
 Source Database       : manner

 Target Server Type    : MySQL
 Target Server Version : 50616
 File Encoding         : utf-8

 Date: 10/29/2014 22:16:56 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_index` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES 
  ('1', 'jason@jason.com', 'Yao', 'Xiao', '$2a$10$8dq6XJjGQGkjgxydrF2PyODeTLkno5/LQA1mLxXZ8B0HctUYVScem', '1'),
  ('2', 'john@john.com', 'John', 'Doe', '$2a$10$LdtDp/dVCaOyq35V8JDyEO/PuiGC3/1xz4NDsey2x27R.3CtpJid2', '1'),
  ('3', 'kei@kei.com', 'Kei', 'Sang', '$2a$10$y15vGMedeGTyVoVw2VUKHeVz3ZUoaNT.fs8ZLVPvoWKV42kV/eqWC', '1'),
  ('4', 'dino@dino.com', 'Dino', 'Huang', '$2a$10$kePpy0gXIvgCKkqf3KIYquxT52JSNhgvkGgCH5UpIBjn6XGtTaAMO', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
