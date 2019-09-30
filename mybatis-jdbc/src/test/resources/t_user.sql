SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `sex` tinyint(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

BEGIN;
INSERT INTO `t_user` VALUES (1, 'oliver', 'Oliver King', 0, NULL, 'oliver.csu@gmail.com', NULL);
INSERT INTO `t_user` VALUES (2, 'cathy', 'Cathy King', 1, NULL, 'cathy.csu@gmail.com', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
