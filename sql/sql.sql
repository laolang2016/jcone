CREATE TABLE `tb_employee` (
  `employeeID` int(11) NOT NULL AUTO_INCREMENT comment '员工ID，主键',
  `employeeName` varchar(20) DEFAULT NULL comment '员工姓名',
  `employeeSex` varchar(5) DEFAULT NULL comment '员工性别',
  `employeeBirth` date DEFAULT NULL comment '员工后日',
  `employeePhone` varchar(20) DEFAULT NULL comment '员工电话',
  `employeePlace` varchar(50) DEFAULT NULL comment '员工住址',
  `joinTime` date DEFAULT NULL comment '员工入职时间',
  `password` varchar(20) DEFAULT NULL comment '员工登陆密码',
  `isLead` int(1) DEFAULT NULL comment '是否领导人员',
  PRIMARY KEY (`employeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8 comment = '员工信息表';

INSERT INTO `tb_employee` VALUES (1001,'老狼','男','1991-12-06','15382009723','中国','2005-05-18','fcl1164891',0);
INSERT INTO `tb_employee` VALUES (1002,'小代码','男','1991-12-06','15382009723','中国','2005-05-18','fcl1164891',1);
INSERT INTO `tb_employee` VALUES (1003,'散人','男','1991-12-06','15382009723','中国','2005-05-18','fcl1164891',0);
INSERT INTO `tb_employee` VALUES (1004,'行者','男','1991-12-06','15382009723','中国','2005-05-18','fcl1164891',1);
INSERT INTO `tb_employee` VALUES (1005,'小龙女','女','1991-12-06','15382009723','中国','2005-05-18','fcl1164891',1);


CREATE TABLE `tb_message` (
  `messageID` int(11) NOT NULL AUTO_INCREMENT comment '消息ID，主键',
  `messageTitle` varchar(50) DEFAULT NULL comment '消息标题',
  `messageContent` text comment '消息内容',
  `employeeID` int(11) DEFAULT NULL comment '发布消息的员工号， 外键',
  `publishTime` datetime DEFAULT NULL comment '发布时间',
  PRIMARY KEY (`messageID`),
  KEY `employeeID` (`employeeID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 comment = '消息信息表';

INSERT INTO `tb_message` VALUES (14,'网络维护公告','<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; text-indent: 48pt; line-height: 42pt; mso-char-indent-count: 2.0; mso-line-height-rule: exactly\"><span style=\"font-size: 24pt; font-family: 宋体; mso-ascii-font-family: \'Times New Roman\'; mso-hansi-font-family: \'Times New Roman\'\">为保证网络上网，网络信息中心特安排了网络维护人员值班。各用户如有网络故障，请按以下方式联系。</span><span lang=\"EN-US\" style=\"font-size: 24pt\"><o:p></o:p></span></p>\r\n<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; text-indent: 24pt; line-height: 42pt; mso-char-indent-count: 1.0; mso-line-height-rule: exactly\"><span style=\"font-size: 24pt; font-family: 宋体; mso-ascii-font-family: \'Times New Roman\'; mso-hansi-font-family: \'Times New Roman\'\">　值班电话：</span><span lang=\"EN-US\" style=\"font-size: 24pt\">XXXXXX</span></p>\r\n<p class=\"MsoNormal\" style=\"margin: 0cm 0cm 0pt; text-indent: 24pt; line-height: 42pt; mso-char-indent-count: 1.0; mso-line-height-rule: exactly\"><span style=\"font-size: 24pt; font-family: 宋体; mso-ascii-font-family: \'Times New Roman\'; mso-hansi-font-family: \'Times New Roman\'\">&nbsp;值班人：周先生</span></p>',3052,'2009-08-25 14:18:59'),;
INSERT INTO `tb_message` VALUES (16,'开会通知','<p><span style=\"color: #3366ff\"><span style=\"background-color: #ffffff\"><span><span style=\"font-size: 20px\">请开发部的所有人员于8月30日的下午2点到三楼会议室，会议重要，请勿缺席。</span></span></span></span></p>',3052,'2009-08-25 14:27:54'),(17,'研发部会议通知','<p><span style=\"color: #ff0000\"><span style=\"font-size: 20px\">请研发部的所有人员于8月30日的下午2点到三楼会议室，会议重要，请勿缺席！！</span></span></p>',3052,'2009-08-25 14:33:51'),(18,'关于国庆放假的通知','<p><span style=\"font-size: 20px\">按国家规定国庆放假七天，8月8日正常上班。</span></p>',3052,'2009-08-25 14:35:35'),(19,'请假一天，望领导能批准','<p>由于家里有事情，急需处理，现请假一天，忘领导能批准。</p>',3052,'2009-08-25 14:37:02'),(20,'测试','HelloWorld',1001,'2015-07-28 17:44:38'),(21,'测试一','测试一',1001,'2015-07-28 21:26:47'),(22,'ckeditor测试','<h1>\r\n  ckeditor测试</h1>\r\n',1001,'2015-07-30 00:20:34');
INSERT INTO `tb_message` VALUES (23,'发布测试001','<p>\r\n 发布测试</p>\r\n',1001,'2015-08-10 05:09:19');
INSERT INTO `tb_message` VALUES (24,'发布测试003','<p>\r\n    发布测试</p>\r\n',1002,'2015-08-10 05:12:52');

CREATE TABLE `tb_criticism` (
  `criticismID` int(11) NOT NULL AUTO_INCREMENT comment '批复ID，主键',
  `criticismContent` text comment '批复内容',
  `employeeID` int(11) DEFAULT NULL comment '批复员工ID，处键',
  `criticismTime` datetime DEFAULT NULL comment '批复时间',
  `messageID` int(11) DEFAULT NULL comment '批复消息ID，处键',
  PRIMARY KEY (`criticismID`),
  KEY `employeeID` (`employeeID`),
  KEY `messageID` (`messageID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 comment = '批复表';

INSERT INTO `tb_criticism` VALUES (5,'<p>测试批复</p>',3052,'2010-01-26 20:53:06',16);
INSERT INTO `tb_criticism` VALUES (19,'测试',1002,'2015-08-10 22:23:16',21);
INSERT INTO `tb_criticism` VALUES (20,'批复测试0001',1002,'2015-08-10 22:23:37',24);
INSERT INTO `tb_criticism` VALUES (21,'发布批复001',1002,'2015-08-10 22:24:35',23);
INSERT INTO `tb_criticism` VALUES (22,'ckeditor批复测试',1002,'2015-08-10 22:25:50',22);



CREATE TABLE `tb_reply` (
  `replyID` int(11) NOT NULL AUTO_INCREMENT comment '回复ID， 主键',
  `replyContent` text comment '回复内容',
  `employeeID` int(11) DEFAULT NULL comment '回复人员ID，处键',
  `replyTime` datetime DEFAULT NULL comment '回复时间',
  `messageID` int(11) DEFAULT NULL comment '回复消息ID，处键',
  PRIMARY KEY (`replyID`),
  KEY `employeeID` (`employeeID`),
  KEY `messageID` (`messageID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 comment = '回复表';

INSERT INTO `tb_reply` VALUES (9,'<p>太好了，希望以后不要再无故掉线了！！！</p>',3052,'2009-08-25 15:03:23',14);
INSERT INTO `tb_reply` VALUES (10,'<p>是哦，总算是能够安心上网了。</p>',3052,'2009-08-25 15:03:49',14);
INSERT INTO `tb_reply` VALUES (11,'<p>测试回复</p>',3052,'2010-01-26 20:52:26',14);
INSERT INTO `tb_reply` VALUES (12,'回复一',1001,'2015-07-28 21:38:35',21);
INSERT INTO `tb_reply` VALUES (13,'回复一',1001,'2015-07-28 21:38:58',21);
INSERT INTO `tb_reply` VALUES (17,'回复测试，回复测试',1002,'2009-08-05 12:15:14',22);
INSERT INTO `tb_reply` VALUES (18,'<p>\r\n    测试回复</p>\r\n',1002,'2015-08-10 04:14:49',22); 
INSERT INTO `tb_reply` VALUES (19,'<p>\r\n   第四次回复</p>\r\n',1002,'2015-08-10 04:17:03',22);
INSERT INTO `tb_reply` VALUES(20,'<p>\r\n  第五次回复</p>\r\n',1002,'2015-08-10 04:27:00',22);
INSERT INTO `tb_reply` VALUES(21,'<p>\r\n  回复测试</p>\r\n',1002,'2015-08-10 05:12:24',23);
