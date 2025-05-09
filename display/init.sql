用户表: id(雪花算法生成), 用户名, 密码, 邮箱, 角色(0-管理员, 1-普通用户), 状态(0-禁用, 1-正常), 创建人, 创建时间, 修改人, 修改时间


CREATE TABLE `user` (
                        `id` BIGINT NOT NULL COMMENT '主键ID，雪花算法生成',
                        `username` VARCHAR(50) NOT NULL COMMENT '用户名',
                        `password` VARCHAR(100) NOT NULL COMMENT '密码（加密存储）',
                        `email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
                        `role` TINYINT DEFAULT 1 COMMENT '角色（0-管理员，1-普通用户）',
                        `status` TINYINT DEFAULT 1 COMMENT '状态（0-禁用，1-正常）',
                        `create_by` BIGINT DEFAULT NULL COMMENT '创建人',
                        `create_time` DATETIME Comment '创建时间',
                        `update_by` BIGINT DEFAULT NULL COMMENT '修改人',
                        `update_time` DATETIME comment '修改时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';


电影类别表: id(雪花算法生成), 电影类别, 创建人, 创建时间, 修改人, 修改时间
CREATE TABLE movie_category (
                                id BIGINT NOT NULL PRIMARY KEY COMMENT '雪花算法生成',
                                category_name VARCHAR(255) NOT NULL COMMENT '电影类别',
                                `create_by` BIGINT DEFAULT NULL COMMENT '创建人',
                                `create_time` DATETIME Comment '创建时间',
                                `update_by` BIGINT DEFAULT NULL COMMENT '修改人',
                                `update_time` DATETIME comment '修改时间',
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影类别表';

电影表: id(雪花算法生成), 电影名称, 电影类别(和电影类别表关联), 演员, 导演, 电影时长, 上映时间, 电影链接, 创建人, 创建时间, 修改人, 修改时间
CREATE TABLE movie (
                       id BIGINT NOT NULL PRIMARY KEY COMMENT '雪花算法生成',
                       movie_name VARCHAR(255) NOT NULL COMMENT '电影名称',
                       category_id BIGINT NOT NULL COMMENT '电影类别ID',
                       actors TEXT COMMENT '演员',
                       director VARCHAR(255) COMMENT '导演',
                       duration INT COMMENT '电影时长(分钟)',
                       release_date DATE COMMENT '上映时间',
                       movie_link VARCHAR(500) COMMENT '电影链接',
                       `create_by` BIGINT DEFAULT NULL COMMENT '创建人',
                       `create_time` DATETIME Comment '创建时间',
                       `update_by` BIGINT DEFAULT NULL COMMENT '修改人',
                       `update_time` DATETIME comment '修改时间',
                       FOREIGN KEY (category_id) REFERENCES movie_category(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电影表';

新闻列表: id(雪花算法生成), 新闻标题, 新闻类别, 新闻内容, 发生日期, 创建人, 创建时间, 修改人, 修改时间
CREATE TABLE news (
                      id BIGINT NOT NULL PRIMARY KEY COMMENT '雪花算法生成',
                      news_title VARCHAR(255) NOT NULL COMMENT '新闻标题',
                      news_category VARCHAR(255) NOT NULL COMMENT '新闻类别',
                      news_content TEXT NOT NULL COMMENT '新闻内容',
                      event_date DATE COMMENT '发生日期',
                      `create_by` BIGINT DEFAULT NULL COMMENT '创建人',
                      `create_time` DATETIME Comment '创建时间',
                      `update_by` BIGINT DEFAULT NULL COMMENT '修改人',
                      `update_time` DATETIME comment '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻列表表';


