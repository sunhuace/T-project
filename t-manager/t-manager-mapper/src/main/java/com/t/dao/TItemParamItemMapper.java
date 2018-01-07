package com.t.dao;

import java.util.List;
import java.util.Map;

import com.t.pojo.TItemParamItem;

public interface TItemParamItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TItemParamItem record);

    int insertSelective(TItemParamItem record);

    TItemParamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(TItemParamItem record);

    int updateByPrimaryKey(TItemParamItem record);
    
    List<TItemParamItem> getTItemParamItems(Map<String, Object> map);
}