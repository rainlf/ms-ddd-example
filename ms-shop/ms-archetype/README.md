# Micro Service Archetype

## Architecture

![](./images/1.png)

## Code Structure

```
├─adapter               Adapter层
│  ├─mobile             移动端
│  │  ├─assembler       移动端 assembler, 实现DTO与DO的转换
│  │  ├─dto             移动端DTO, 前端应用数据的传输载体，不实现任何业务逻辑
│  │  └─facade          移动端对外接口，封装应用服务，提供粗粒度的调用接口；或将用户请求委派给一个或多个应用服务
│  └─web                PC端
│      ├─assembler      PC端 assembler, 实现DTO与DO的转换
│      ├─dto            PC端DTO, 前端应用数据的传输载体，不实现任何业务逻辑
│      └─facade         PC端对外接口，封装应用服务，提供粗粒度的调用接口；或将用户请求委派给一个或多个应用服务
├─application           Application层
│  ├─event              领域事件相关代码，包含事件定义、发布事件、监听事件
│  │  ├─publisher       事件发布相关代码
│  │  └─subscriber      事件订阅相关代码
│  ├─scheduler          计划任务相关代码
│  └─service            应用服务接口
│      └─impl           应用服务实现
├─domain                Domain层
│  ├─entity             存放领域实体代码，包含聚合根、实体、值对象等；实体包含业务属性和业务行为
│  │  └─objectvalue     存放值对象代码
│  ├─gateway            领域层网关接口，存放领域内对外部的依赖接口
│  ├─repository         领域层仓储接口，存放领域层所需的持久化接口
│  └─service            领域服务实现
│      └─impl           领域服务接口，存放领域服务、工厂服务等代码；一个领域服务是由多个实体组合出来的一段业务逻辑；领域服务用来封装多个实体或方法提供上层应用服务的调用
└─infrastucture         Infrastructure层
    ├─config            存放通用配置相关代码
    ├─dao               数据库访问相关代码
    │  ├─entity         存放持久层对象PO，和数据库库表一一对应
    │  └─mapper         Mybatis Mapper 接口
    ├─gatewayimpl       网关接口实现
    ├─message           存放消息队列相关代码
    ├─repositoryimpl    仓储接口实现
    └─util              存放通用工具类
```