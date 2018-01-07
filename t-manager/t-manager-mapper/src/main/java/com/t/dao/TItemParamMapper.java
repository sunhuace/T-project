package com.t.dao;

import java.util.List;
import java.util.Map;

import com.t.pojo.TItemParam;

public interface TItemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TItemParam record);

    int insertSelective(TItemParam record);

    TItemParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TItemParam record);

    int updateByPrimaryKeyWithBLOBs(TItemParam record);

    int updateByPrimaryKey(TItemParam record);
    
    List<TItemParam> getTItemParamList(Map<String, Object> map);
    
}