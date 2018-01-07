package com.t.dao;

import com.t.pojo.TOrderItem;

public interface TOrderItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(TOrderItem record);

    int insertSelective(TOrderItem record);

    TOrderItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TOrderItem record);

    int updateByPrimaryKey(TOrderItem record);
}