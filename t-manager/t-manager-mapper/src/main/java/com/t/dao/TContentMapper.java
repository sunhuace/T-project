package com.t.dao;

import java.util.List;
import java.util.Map;

import com.t.pojo.TContent;

public interface TContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TContent record);

    int insertSelective(TContent record);

    TContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TContent record);

    int updateByPrimaryKeyWithBLOBs(TContent record);

    int updateByPrimaryKey(TContent record);
    
    List<TContent> getContentsList(Map<String, Object> map);
    
}