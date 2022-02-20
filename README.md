# BiLiBiLiSys
基于SSM和VUE的仿哔哩哔哩视频系统

演示视频链接：https://live.csdn.net/v/185846

1. 介绍

是一个支持用户上传视频、观看视频、搜索视频、发送评论、发送弹幕的视频分享网站。

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

MySQL: 5.7.18-log - Source distribution

JDK: OpenJDK 64-Bit Server VM (build 25.161-b14, mixed mode)

Maven: Apache Maven 3.0.5 (Red Hat 3.0.5-17)

Node: v6.14.0

OS: centos-release-7-4.1708.el7.centos.x86_64
3.2 前端

Vue.js: v2.5.13

jQuery: v3.2.1

Bootstrap: v3.3.7

Bootstrap-select: v1.12.4

ECMAScript: ECMAScript 6

Browser: Chrome, 66.0.3359.139（正式版本） （64 位）

OS: Windows 10, 1803 (内部版本 17134.1)

详询QQ：821898835，微信：egvh56ufy7hh，承接商业项目和毕设
