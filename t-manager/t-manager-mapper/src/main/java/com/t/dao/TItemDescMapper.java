package com.t.dao;

import com.t.pojo.TItemDesc;

public interface TItemDescMapper {
    int deleteByPrimaryKey(Long itemId);

    int insert(TItemDesc record);

    int insertSelective(TItemDesc record);

    TItemDesc selectByPrimaryKey(Long itemId);

    int updateByPrimaryKeySelective(TItemDesc record);

    int updateByPrimaryKeyWithBLOBs(TItemDesc record);

    int updateByPrimaryKey(TItemDesc record);
}