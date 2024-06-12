# BiLiBiLiSys
基于SSM的仿哔哩哔哩视频系统

演示视频链接：https://www.bilibili.com/video/BV1L841137Mn

1. 介绍

是一个支持用户上传视频、观看视频、搜索视频、发送评论、发送弹幕的视频分享网站。

拥有后台管理和管理员角色，可以对用户、视频、弹幕、评论、视频标签等进行管理。

普通用户可以管理自己的视频、弹幕和评论。

2. 架构

项目将前后端分离，并把功能拆分成 4 个模块，支持分布式部署。

2.1 后台 API - apiServer

提供除了上传的所有服务的支持，功能包括用户注册、登录、修改密码，视频信息上传，视频评论，视频弹幕。

2.2 简单文件上传服务 - simpleUploader

提供基于用户身份验证的文件上传功能。

2.3 前端页面 - web_server

全部的前端页面。

2.4 文件存储获取服务 - storage_server

用于获取上传的文件。

3. 环境

3.1 后台

MySQL: 5.7

JDK: jdk1.8

Maven: Apache Maven 3或以上

Node: v6.14.0或以上

3.2 前端

Vue.js: v2.5.13

jQuery: v3.2.1

Bootstrap: v3.3.7

Bootstrap-select: v1.12.4

ECMAScript: ECMAScript 6

详询 微信1：egvh56ufy7hh ，微信2：dabocode 。承接商业项目、课设、毕设和论文，包括但不限于Web、APP、小程序等，课设、毕设提供远程部署和不限次数代码解答！
