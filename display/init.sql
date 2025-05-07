用户表: id(雪花算法生成), 用户名, 密码, 邮箱, 角色(0-管理员, 1-普通用户), 状态(0-禁用, 1-正常), 创建人, 创建时间, 修改人, 修改时间


CREATE TABLE `user` (
                        `id` BIGINT NOT NULL COMMENT '主键ID，雪花算法生成',
                        `username` VARCHAR(50) NOT NULL COMMENT '用户名',
                        `password` VARCHAR(100) NOT NULL COMMENT '密码（加密存储）',
                        `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
                        `role` TINYINT DEFAULT 1 COMMENT '角色（0-管理员，1-普通用户）',
                        `status` TINYINT DEFAULT 1 COMMENT '状态（0-禁用，1-正常）',
                        `create_by` VARCHAR(50) DEFAULT NULL COMMENT '创建人',
                        `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_by` VARCHAR(50) DEFAULT NULL COMMENT '修改人',
                        `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';
