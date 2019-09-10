

 

 

 



 



## 1.3         参考资料 



# **2**         **数据库环境说明**

| 数据库实例 | 数据库系统 | 数据库部署环境 | 数据库设计工具 | 数据库存放位置 | 说明 |
| ---------- | ---------- | -------------- | -------------- | -------------- | ---- |
|            | mysql      | *linux*        | **/**          | */*            |      |

 

# **3**         **数据库的命名规则**

# **4**         **物理设计**

# 4.1表汇总

User 库

 

 

| 表名            | 功能说明       |
| --------------- | -------------- |
| user            | 用户表         |
| user_role       | 用户角色表     |
| user_permission | 用户权限表     |
| role_permission | 权限角色中间表 |
| Sys_User_role   | 用户角色中间表 |
|                 |                |
|                 |                |

 注:子用户为用户表字段

 

 

 

 

Mall 库

 

| 表名                    | 功能说明         |
| ----------------------- | ---------------- |
| mall                    | 商品表           |
| mall_attribute_robot    | 商品机器人型号表 |
| mall_attribute_server   | 商品服务类型表   |
| mall_attribute_strategy | 商品策略类型表   |
|                         |                  |
|                         |                  |
|                         |                  |

 

 

*Order*库

 

| 表名            | 功能说明   |
| --------------- | ---------- |
| Order           | 订单表     |
| orderitem       | 订单子表   |
| Receipt_address | 收货地址表 |
|                 |            |

 

 

日志库

| 表名             | 功能说明     |
| ---------------- | ------------ |
| User_log         | 用户操作日志 |
| Order_log        | 订单操作日志 |
| Announcement_log | 公告操作日志 |
|                  |              |

 

 

 

 

 

Sms库

 

| 表名                 | 功能说明       |
| -------------------- | -------------- |
| Message              | 系统消息表     |
| Message_Type         | 消息类型表     |
| Monitor_notice       | 消息监听表     |
| Monitor_notice_count | 消息监听数表   |
| Monitor_send_record  | 消息发送记录   |
| Work_query           | 用户消息反馈表 |
| Work_order_info      | 消息详情表     |
| Work_answer          | 客服消息回应表 |
| Work_type            | 消息类型表     |
| announcement_type    | 公告类型表     |
| announcement         | 公告主表       |
|                      |                |
|                      |                |

 

 

 

**Spring cloud+mybatis**

**数据库:mysql   权限框架:security**  

**无状态加密:jwt  缓存管理:redis**

**同步组件:rabbitmq**

**短信:阿里短信**

 

 

 

**时间进度:**

 

**User** **模块:1-2天**

**Mall,cart** **模块 3-4天**

**Authentication** **模块:1-2天**

**Sms** **模块:2天**

 

 

 