package org.jpstale.entity.item;

import lombok.ToString;

@ToString
class ItemCreate {
    long Head; // 头
    long dwVersion; // 创建的版本
    long dwTime; // 创建时间
    long dwChkSum; // 装备校验
}