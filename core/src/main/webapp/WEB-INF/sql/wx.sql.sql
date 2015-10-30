CREATE TABLE
    user_info
    (
        id VARCHAR(32) NOT NULL  COMMENT '用户编码',
        name VARCHAR(50) NOT NULL COMMENT '用户名称',
        tel VARCHAR(50) COMMENT '电话',
        phone VARCHAR(50) COMMENT '手机',
        email VARCHAR(50) COMMENT '邮箱',
        address VARCHAR(200) COMMENT '地址',
        oper_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
