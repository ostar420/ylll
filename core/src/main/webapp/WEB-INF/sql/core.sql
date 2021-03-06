DROP TABLE IF EXISTS `nc_log`;
CREATE TABLE `nc_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT  COMMENT '日志编号',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `module` varchar(200) DEFAULT NULL COMMENT '执行模型名',
  `methods` varchar(200) DEFAULT NULL COMMENT '执行类方法', 
  `action` varchar(200) DEFAULT NULL COMMENT '执行方法自定义中文名',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `actionTime` varchar(30) DEFAULT NULL COMMENT '执行时间',
  `userIP` varchar(30) DEFAULT NULL COMMENT '用户IP',
  `operTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间' ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '系统日志表';


DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `id` int(10) NOT NULL AUTO_INCREMENT  ,
  `countryname` varchar(50) DEFAULT NULL ,
  `countrycode` varchar(50) DEFAULT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '测试表';

