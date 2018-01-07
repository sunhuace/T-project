package com.t.dao;

import com.t.pojo.TOrderShipping;

public interface TOrderShippingMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(TOrderShipping record);

    int insertSelective(TOrderShipping record);

    TOrderShipping selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(TOrderShipping record);

    int updateByPrimaryKey(TOrderShipping record);
}