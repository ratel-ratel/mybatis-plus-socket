/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 127.0.0.1:3306
 Source Schema         : github

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 14/01/2019 20:25:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reply_info
-- ----------------------------
DROP TABLE IF EXISTS `reply_info`;
CREATE TABLE `reply_info`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `open_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信用户id',
  `app_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第三方用户唯一凭证',
  `reply_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复的关键字',
  `message_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文本text,图文news',
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文本消息内容',
  `title` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图文消息标题',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图文消息描述信息',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图文消息点击跳转的地址',
  `picture_url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支持JPG,PNG格式,较好的效果为大图640*320,小图80*80',
  `created_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `created_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `updated_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` int(1) NULL DEFAULT 1 COMMENT '删除标记(1:在线2:删除)',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自动回复信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply_info
-- ----------------------------
INSERT INTO `reply_info` VALUES (1077379646597775361, 'peipei', 'wx62b99576ea9266c', '吃饭', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
