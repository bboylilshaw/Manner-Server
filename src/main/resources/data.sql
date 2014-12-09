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
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` (id, email, first_name, last_name, password, role)
VALUES
  ('1', 'jason@jason.com', 'Jason', 'Shaw', '$2a$10$8dq6XJjGQGkjgxydrF2PyODeTLkno5/LQA1mLxXZ8B0HctUYVScem', '0'),
  ('2', 'john@john.com', 'John', 'Doe', '$2a$10$LdtDp/dVCaOyq35V8JDyEO/PuiGC3/1xz4NDsey2x27R.3CtpJid2', '1'),
  ('3', 'kei@kei.com', 'Kei', 'Sang', '$2a$10$y15vGMedeGTyVoVw2VUKHeVz3ZUoaNT.fs8ZLVPvoWKV42kV/eqWC', '2'),
  ('4', 'dino@dino.com', 'Dino', 'Huang', '$2a$10$kePpy0gXIvgCKkqf3KIYquxT52JSNhgvkGgCH5UpIBjn6XGtTaAMO', '2');
COMMIT;

-- ----------------------------
--  Records of `t_group`
-- ----------------------------
BEGIN;
INSERT INTO `t_group` (id, created_date, name, owner_id)
VALUES ('1', '2014-12-04 22:21:24', 'Pioneer', '1');
COMMIT;

-- ----------------------------
--  Records of `t_group_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_group_user` (group_id, user_id) VALUES ('1', '1');
COMMIT;

-- ----------------------------
--  Records of `t_item`
-- ----------------------------
BEGIN;
INSERT INTO `t_item` (id, completion_date, content, created_date, due_date, item_type, last_modified_date, percentage, priority, remarks, status, title, created_by_id, group_id, last_modified_by_id, owner_id)
VALUES
  ('1', '2014-12-04 22:22:48', 'task1', '2014-12-04 22:22:48', '2014-12-04 00:00:00', '0', '2014-12-04 22:22:48', '0', '2', 'note1', '0', 'title1', '1', '1', '1', '1'),
  ('2', '2014-12-04 22:22:48', 'task2', '2014-12-04 22:23:22', '2014-12-05 00:00:00', '0', '2014-12-04 22:23:22', '50', '3', 'note2', '1', 'title2', '1', '1', '1', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
