/*
 Navicat Premium Data Transfer

 Source Server         : 本地服务
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : mango

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 09/12/2020 17:21:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_metadata
-- ----------------------------
DROP TABLE IF EXISTS `sys_metadata`;
CREATE TABLE `sys_metadata`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据值',
  `label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名（某一类型下的分类标识）',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `del_flag` tinyint(2) NULL DEFAULT 0 COMMENT '是否删除 0：正常   1：已删除',
  `is_leaf` tinyint(1) NULL DEFAULT NULL COMMENT '是否为叶子节点（1：是，0：否）',
  `retrieve` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拼音检索',
  `right_value` bigint(20) NULL DEFAULT NULL COMMENT '右兄弟节点',
  `left_value` bigint(20) NULL DEFAULT NULL COMMENT '左孩子节点',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4049 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_metadata
-- ----------------------------
INSERT INTO `sys_metadata` VALUES (1, '10', 'METADATA', '元数据', 0, 0, NULL, 16, 1, NULL);
INSERT INTO `sys_metadata` VALUES (2, '1', 'GB/T', '国标元数据', 0, 0, NULL, 7, 2, NULL);
INSERT INTO `sys_metadata` VALUES (3, '2', 'GB/T sex', '性别', 0, 1, 'xb_xingbie', 6, 3, '备注信息');
INSERT INTO `sys_metadata` VALUES (4, '3', 'CV', '企业元数据', 0, 0, NULL, 15, 8, NULL);
INSERT INTO `sys_metadata` VALUES (5, '4', 'CV education', '学位表', 0, 1, NULL, 10, 9, NULL);
INSERT INTO `sys_metadata` VALUES (6, '5', 'CV nation', '民族表', 0, 0, NULL, 14, 11, NULL);
INSERT INTO `sys_metadata` VALUES (7, '6', 'CV educatin han', '汉族', 0, 1, NULL, 13, 12, NULL);
INSERT INTO `sys_metadata` VALUES (8, '5555', 'GB/T TEST', '元数据描述', 0, NULL, NULL, 5, 4, '备注信息');
INSERT INTO `sys_metadata` VALUES (9, '555', 'GB/T TEST2', '元数据描述', 1, NULL, NULL, 7, 6, '备注信息');

SET FOREIGN_KEY_CHECKS = 1;
