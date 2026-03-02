#!/bin/bash

# JPsTale GameServer 配置查看器启动脚本

echo "正在启动 JPsTale GameServer 配置查看器..."

# 检查 Java 版本
java_version=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
echo "Java 版本: $java_version"

# 运行应用程序
java -jar target/gamedata-viewer-1.0.0-SNAPSHOT.jar

echo "应用程序已退出"