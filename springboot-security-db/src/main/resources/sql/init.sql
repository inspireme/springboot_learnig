SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sb_role
-- ----------------------------
DROP TABLE IF EXISTS `sb_role`;
CREATE TABLE `sb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `nameZh` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sb_role
-- ----------------------------
INSERT INTO `sb_role` VALUES ('1', 'dba', 'DBマネージャー');
INSERT INTO `sb_role` VALUES ('2', 'admin', 'システムマネージャー');
INSERT INTO `sb_role` VALUES ('3', 'user', '普通ユーザー');

-- ----------------------------
-- Table structure for sb_user
-- ----------------------------
DROP TABLE IF EXISTS `sb_user`;
CREATE TABLE `sb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sb_user
-- ----------------------------
INSERT INTO `sb_user` VALUES ('1', 'root', '$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq', '1', '0');
INSERT INTO `sb_user` VALUES ('2', 'admin', '$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq', '1', '0');
INSERT INTO `sb_user` VALUES ('3', 'sang', '$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq', '1', '0');

-- ----------------------------
-- Table structure for sb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sb_user_role`;
CREATE TABLE `sb_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sb_user_role
-- ----------------------------
INSERT INTO `sb_user_role` VALUES ('1', '1', '1');
INSERT INTO `sb_user_role` VALUES ('2', '1', '2');
INSERT INTO `sb_user_role` VALUES ('3', '2', '2');
INSERT INTO `sb_user_role` VALUES ('4', '3', '3');
SET FOREIGN_KEY_CHECKS=1;