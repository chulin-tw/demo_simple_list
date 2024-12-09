#!/bin/sh

current_ip=$(ifconfig en0 | grep 'inet ' | awk '{print $2}')

if [ -z "$current_ip" ]; then
  echo "无法获取当前的IP地址"
  exit 1
fi

project_dir_kotlin="/Users/chulinwang/AndroidStudioProjects/Moments"
project_dir_java="/Users/chulinwang/AndroidStudioProjects/Moments/MomentsJava"

server_js_path="$project_dir_kotlin/backend/server.js"
if [ -f "$server_js_path" ]; then
  sed -i '' "s/^const domain = .*$/const domain = '$current_ip';/" "$server_js_path"
  echo "已成功修改 $server_js_path"
else
  echo "找不到文件 $server_js_path"
  exit 1
fi

list_api_module_path="$project_dir_kotlin/app/src/main/java/com/example/moments/data/api/di/ListApiModule.kt"
if [ -f "$list_api_module_path" ]; then
  sed -i '' "s/^private const val DOMAIN_URL = \".*\"$/private const val DOMAIN_URL = \"$current_ip\"/" "$list_api_module_path"
  echo "已成功修改 $list_api_module_path"
else
  echo "找不到文件 $list_api_module_path"
  exit 1
fi

list_api_module_path_java="$project_dir_java/app/src/main/java/com/example/momentsjava/data/api/di/ListApiModule.java"
if [ -f "$list_api_module_path_java" ]; then
  sed -i '' "s/^private static final String DOMAIN_URL = \".*\"$/private static final String DOMAIN_URL = \"$current_ip\"/" "$list_api_module_path_java"
  echo "已成功修改 $list_api_module_path_java"
else
  echo "找不到文件 $list_api_module_path_java"
  exit 1
fi

echo "脚本成功完成所有修改！"